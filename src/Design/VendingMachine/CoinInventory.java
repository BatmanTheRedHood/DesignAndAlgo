package Design.VendingMachine;

import Design.VendingMachine.Models.Coin;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CoinInventory extends Inventory<Coin> {
    @Override
    public void setInventory(){
        // Coin comparator sort in descending order
        this.inventory = new TreeMap(new Comparator<Coin>() {
            @Override
            public int compare(Coin o1, Coin o2) {
                return -Integer.compare(o1.value, o2.value);
            }
        });
    }

    public Map<Coin, Integer> refund(int amount) throws Exception{
        if (!isRefundable(amount)) {
            throw new Exception("Non refundable transaction");
        }

        Map<Coin, Integer> refundCoins = new HashMap<>();
        for (Map.Entry<Coin, Integer> entry: this.inventory.entrySet()) {
            Coin coin = entry.getKey();
            Integer quantity = entry.getValue();

            while (quantity > 0 && amount > coin.value){
                amount -= coin.value;
                quantity--;
            }

            // Update remaining coins in inventory
            int coinDiff = entry.getValue() - quantity;
            if (coinDiff > 0){
                this.deductItem(coin, coinDiff);
                refundCoins.put(coin, quantity);
            }

            if (amount == 0) {
                break;
            }
        }

        return refundCoins;
    }

    public boolean isRefundable(int amount){
        for (Map.Entry<Coin, Integer> entry: this.inventory.entrySet()) {
            Coin coin = entry.getKey();
            Integer quantity = entry.getValue();

            while (quantity > 0 && amount > coin.value){
                amount -= coin.value;
                quantity--;
            }

            if (amount == 0) {
                return true;
            }
        }

        return false;
    }
}
