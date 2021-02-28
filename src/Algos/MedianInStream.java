package Algos;


import models.Algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianInStream extends Algorithm {
    private int[] stream;
    @Override
    protected void init() {
        // this.stream = new int[]{5,15,1,3};
        this.stream = new int[]{5,10,15};
    }

    // Maintain max heap for left half stream and min heap for right half stream
    // For each new item, check whether it belongs to left or right. Insert and balance if size diff is > 1
    // Print median
    @Override
    protected void run() {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return - Integer.compare(o1, o2);
            }
        });

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int item : this.stream){
            this.insertItem(maxHeap, minHeap, item);
            this.balanceHeaps(maxHeap, minHeap);
            this.getMedian(maxHeap, minHeap);
        }
    }

    private void insertItem(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int value){
        if (maxHeap.isEmpty()) {
            maxHeap.add(value);
            return;
        }

        if (value > maxHeap.peek()){
            minHeap.add(value);
        } else {
            maxHeap.add(value);
        }
    }

    private void balanceHeaps(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap){
        if (maxHeap.size() - minHeap.size() > 1) {
            int removedItem = maxHeap.remove();
            minHeap.add(removedItem);
        } else if(minHeap.size() - maxHeap.size() > 1) {
            int removedItem = minHeap.remove();
            maxHeap.add(removedItem);
        }
    }

    private void getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap){
        if (maxHeap.size() > minHeap.size()) {
            System.out.println(String.format("Current median: %d", maxHeap.peek()));
        } else if (minHeap.size() > maxHeap.size()) {
            System.out.println(String.format("Current median: %d", minHeap.peek()));
        } else {
            System.out.println(String.format("Current median: %.2f", (double)(minHeap.peek() + maxHeap.peek())/2));
        }
    }
}
