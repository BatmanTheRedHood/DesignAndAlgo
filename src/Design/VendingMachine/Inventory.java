package Design.VendingMachine;

import Design.VendingMachine.Interfaces.IInventory;

import java.util.Map;
import java.util.TreeMap;

public abstract class Inventory<T> implements IInventory<T> {
    protected Map<T, Integer> inventory;

    public abstract void setInventory();

    @Override
    public void addItem(T item, Integer quantity) {
        int count = this.inventory.getOrDefault(item, 0) + quantity;
        this.inventory.put(item, count);
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
        return this.inventory.getOrDefault(item, 0);
    }
}
