package Algos.StackQueue;

import java.util.HashMap;
import java.util.Map;

public class LeastRecentlyUsedCache {
    private int capacity;
    private Map<Integer, DLLNode> map;
    private DoubleLL dll;
    private int cacheItemCount;

    // Assumption: Cap > 0
    public LeastRecentlyUsedCache(int cap){
        capacity = cap;
        cacheItemCount = 0;
        map = new HashMap<>();
        dll = new DoubleLL();
    }

    //Function to return value corresponding to the key.
    public int get(int key) {
        // Check map
        if (!map.containsKey(key)){
            return -1;
        }

        // Delete node and place in front
        DLLNode node = dll.deleteNode(map.get(key));
        dll.addToFront(node);
        return node.data;
    }

    //Function for storing key-value pair.
    public void set(int key, int value) {
        // Check if already present
        if (map.containsKey(key)){ // Setting new value to existing key. Move to front
            // Remove
            DLLNode existingNode = map.get(key);
            dll.deleteNode(existingNode);
            map.remove(key);

            // Add
            DLLNode newNode = new DLLNode(key, value);
            map.put(key, newNode);
            dll.addToFront(newNode);
            return;
        }

        // Check if max capacity reached
        if (cacheItemCount >= capacity) {
            DLLNode rearNode = dll.deleteRearNode(); // Delete from DLL
            map.remove(rearNode.key); // Delete from map
        } else {
            cacheItemCount++;
        }

        DLLNode newNode = new DLLNode(key, value);
        map.put(key, newNode);
        dll.addToFront(newNode);
    }
}

class DoubleLL{
    public DLLNode front, rear;

    public DoubleLL(){
        front = null;
        rear = null;
    }

    public void addToFront(DLLNode newNode) {
        newNode.right = front;
        if (front != null) {
            front.left = newNode;
        } else {
            rear = newNode;
        }

        front = newNode;
    }

    // Assumption: Node is not null
    public DLLNode deleteNode(DLLNode node) {
        DLLNode prev = node.left, next = node.right;

        if (prev != null) {
            prev.right = next;
        } else {
            front = next;
        }

        if (next != null) {
            next.left = prev;
        } else {
            rear = prev;
        }

        node.left = node.right = null;
        return node;
    }

    public DLLNode deleteRearNode() {
        return deleteNode(rear);
    }
}

class DLLNode{
    int key;
    int data;
    DLLNode left;
    DLLNode right;

    public DLLNode(int key, int data) {
        this.key = key;
        this.data = data;
        left = null;
        right = null;
    }
}
