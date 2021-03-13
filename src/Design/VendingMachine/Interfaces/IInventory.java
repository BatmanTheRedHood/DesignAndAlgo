package Design.VendingMachine.Interfaces;

public interface IInventory<T> {
    // Add new item or update item quantity
    void addItem(T item, Integer quantity);

    void deductItem(T item, Integer quantity) throws Exception;

    int getQuantity(T item);
}
