package Algos.Heap;

import Algos.LinkedList.Node;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLL {
    //Function to merge K sorted linked list.
    Node mergeKList(Node[] arr, int K) {
        Node head = null, tail = null;
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.data));

        for (int i=0; i<K; i++){
            if (arr[i] != null)
                minHeap.add(arr[i]);
        }

        while (!minHeap.isEmpty()) {
            Node temp = minHeap.remove();
            if (temp.next != null) {
                minHeap.add(temp.next);
            }

            temp.next = null;
            if (head == null) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
        }

        return head;
    }
}
