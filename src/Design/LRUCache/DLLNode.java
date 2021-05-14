package Design.LRUCache;

public class DLLNode<T> {
    // properties:
    public DLLNode prevNode;
    public DLLNode nextNode;
    public T value;

    public DLLNode(T value){
        this.value = value;
        this.prevNode = null;
        this.nextNode = null;
    }
}
