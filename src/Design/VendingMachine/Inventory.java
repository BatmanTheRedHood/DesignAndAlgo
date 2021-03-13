package Design.VendingMachine;

import Design.VendingMachine.Interfaces.IInventory;

import java.util.Map;
import java.util.TreeMap;

public abstract class Inventory<T> implements IInventory<T> {
    protected Map<T, Integer> inventory;

    public abstract void setInventory();

    @Override
    public void addItem(T item, Integer quantity) {
        // If item doesn't exist
        if (this.inventory.containsKey(item)){
            int count = this.inventory.get(item);
            this.inventory.put(item, count + quantity);
        } else {
            this.inventory.put(item, quantity);
        }
    }

    @Override
    public void deductItem(T item, Integer quantity) throws Exception{
        if (!this.inventory.containsKey(item)) {
            throw new Exception("Invalid operation. Item not found");
        }

        int count = this.inventory.get(item);
        this.inventory.put(item, count - quantity);
    }

    @Override
    public int getQuantity(T item) {
        if (this.inventory.containsKey(item)){
            return this.inventory.get(item);
        }

        return 0;
    }
}
