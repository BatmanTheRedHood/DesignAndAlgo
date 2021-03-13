package Design.VendingMachine;

import Design.VendingMachine.Interfaces.IVendingMachine;
import Design.VendingMachine.Models.Coin;
import Design.VendingMachine.Models.Product;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine implements IVendingMachine {
    private boolean lock;
    private Product selectedProduct;
    private int coinSum;

    // Can change type from class to interface to avoid tight coupling
    private CoinInventory coinInventory;
    private ProductInventory productInventory;

    public VendingMachine(){
        // TODO: Should come from Factory or DI. Tight coupling with implementation.
        this.coinInventory = new CoinInventory();
        this.productInventory = new ProductInventory();
    }

    @Override
    public int selectItemAndGetPrice(String code) throws Exception {
        this.selectedProduct = this.productInventory.getItemByCode(code);

        if (this.selectedProduct == null){
            throw new Exception("Product not found. Try another product code!");
        }

        if (this.productInventory.getQuantity(this.selectedProduct) == 0){
            this.selectedProduct = null;
            throw new Exception("Product is out of stock. Try another product code!");
        }

        // Start fresh transaction.
        this.coinSum = 0;
        return this.selectedProduct.price;
    }

    @Override
    public void insertCoin(Coin coin) throws Exception {
        if (this.selectedProduct == null){
            throw new Exception("Please select a product!");
        }

        this.coinSum += coin.value;
        this.coinInventory.addItem(coin, 1);
    }

    @Override
    public Map<Coin, Integer> refund() throws Exception {
        if (this.lock && this.coinSum == 0) {
            return null;
        }

        // Take lock and refund
        this.lock = true;
        Map<Coin, Integer> refundCoins = this.coinInventory.refund(this.coinSum);

        // Finish transaction
        this.selectedProduct = null;
        this.coinSum = 0;
        this.lock = false;

        return refundCoins;
    }

    @Override
    public Map<Product, Map<Coin, Integer>> collectItemAndChange() throws Exception {
        if (this.selectedProduct == null){
            throw new Exception("Please select a product!");
        }

        if (this.selectedProduct.price > this.coinSum){
            throw new Exception("Insufficient balance. Please insert more coin!");
        }

        int refundAmount = this.coinSum - this.selectedProduct.price;

        // Take lock and Start transaction
        this.lock = true;
        Map<Coin, Integer> refundCoins = null;
        Map<Product, Map<Coin, Integer>> result= new HashMap<>();
        this.productInventory.deductItem(this.selectedProduct, 1);

        if (refundAmount  > 0) {
            refundCoins = this.coinInventory.refund(refundAmount);
        }

        result.put(this.selectedProduct, refundCoins);

        // Finish transaction
        this.selectedProduct = null;
        this.coinSum = 0;
        this.lock = false;

        return result;
    }

    @Override
    public void reset() {
    }

    private void initializeInventory(){
        // Initialize products and coins
    }
}
