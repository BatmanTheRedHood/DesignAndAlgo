package Design.LRUCache;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    private int cacheSize;
    private DLL<Integer> deque;
    private HashMap<Integer, DLLNode<Integer>> hashMap;

    public LRUCache(int cacheSize){
        this.cacheSize = cacheSize;
        this.deque = new DLL();
        this.hashMap = new HashMap<>();
    }

    public void refer(int page) {
        // Page not found
        if (!hashMap.containsKey(page)) {
            // Cache is FULL
            if (this.deque.getSize() == this.cacheSize){
                DLLNode<Integer> deletedNode = this.deque.removeLast();
                this.hashMap.remove(deletedNode.value);
            }

            DLLNode<Integer> newNode = deque.insertAtFirst(page);
            this.hashMap.put(page, newNode);
        } else{
            DLLNode<Integer> foundNode = hashMap.get(page);

            // Page fount not at front
            if (foundNode != this.deque.getFrontNode()) {
                this.deque.removeNode(foundNode);

                DLLNode<Integer> newNode = deque.insertAtFirst(page);
                this.hashMap.put(page, newNode);
            }
        }
    }

    public void printCache(){
        this.deque.printAll();
        System.out.println();
    }
}
