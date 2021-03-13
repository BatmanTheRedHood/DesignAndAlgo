package Design.VendingMachine;

import Design.VendingMachine.Models.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductInventory extends Inventory<Product> {
    private Map<String, Product> productMap;

    public ProductInventory(){
        this.productMap = new HashMap<>();
    }

    @Override
    public void setInventory() {
        this.inventory = new HashMap<>();
    }

    @Override
    public void addItem(Product item, Integer quantity) {
        super.addItem(item, quantity);

        if (!this.productMap.containsKey(item.code)){
            this.productMap.put(item.code, item);
        }
    }

    public Product getItemByCode(String code){
        return this.productMap.get(code);
    }
}
