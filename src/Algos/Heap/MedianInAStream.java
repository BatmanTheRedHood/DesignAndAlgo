package Algos.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianInAStream {
    private PriorityQueue<Integer> minHeap; // To store 2nd half
    private PriorityQueue<Integer> maxHeap; // To store 1st half

    public MedianInAStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> -a.compareTo(b)); // Lambda comparator. inverse comparison for max heap
    }

    //Function to insert heap.
    public void insertHeap(int x) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(x);
            return;
        }

        if (x < maxHeap.peek()) { // Insert in 1st half
            maxHeap.add(x);
        } else { // Else in 2nd half
            minHeap.add(x);
        }

        balanceHeaps();
    }

    //Function to balance heaps.
    public void balanceHeaps() {
        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.remove());
        } else if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.remove());
        }
    }

    //Function to return Median.
    public double getMedian() {
        if (maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek())/2;

        if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();

        return minHeap.peek();
    }

}
