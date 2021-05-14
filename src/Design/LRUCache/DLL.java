package Design.LRUCache;

//   NULL <- A <=> B <=> C -> NULL
public class DLL<T> {
    private int llSize;
    private DLLNode<T> start;
    private DLLNode<T> end;

    public DLL(){
        this.llSize = 0;
    }

    public DLLNode<T> getFrontNode(){
        return this.start;
    }

    public int getSize(){
        return this.llSize;
    }

    // methods:
    // insert at start
    public DLLNode<T> insertAtFirst(T item){
        DLLNode<T> newNode = new DLLNode<>(item);

        this.llSize++;
        if (this.start == null) {
            this.start = this.end = newNode;
        } else {
            newNode.nextNode = this.start;
            this.start.prevNode = newNode;

            // Shift start node pointer
            this.start = newNode;
        }

        return newNode;
    }

    // remove last
    public DLLNode<T> removeLast(){
        DLLNode<T> deletedNode = this.end;
        if (this.end == null) {
            return null;
        }

        this.llSize--;
        if (this.start == this.end) {
            this.start = this.end = null;
            return deletedNode;
        }

        // Shift end
        this.end = this.end.prevNode;
        this.end.nextNode = null;

        return deletedNode;
    }

    // remove node
    public void removeNode(DLLNode<T> node){
        if (node == null) {
            return;
        }

        this.llSize--;
        if (node.prevNode == null){ // Start node. Not handling case where node doesn't belong to DLL
            this.start = this.start.nextNode;
            this.start.prevNode = null;
        } else {
            node.prevNode.nextNode = node.nextNode;
        }

        if (node.nextNode == null){ // End node. Not handling case where node doesn't belong to DLL
            this.end = this.end.prevNode;
            this.end.nextNode = null;
        } else {
            node.nextNode.prevNode = node.prevNode;
        }
    }

    public void printAll() {
        DLLNode<T> temp = this.start;
        while (temp != null) {
            System.out.print(temp.value);
            System.out.print(", ");
            temp = temp.nextNode;
        }
    }
}
