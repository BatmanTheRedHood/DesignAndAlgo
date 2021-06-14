package Algos.Heap;

import java.util.PriorityQueue;

public class KthLargestElementInStream {
    private int[] kthLargest(int k, int[] arr, int n) {
            int[] res = new int[n];
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            for (int i=0; i<n; i++) {
                res[i] = processInt(arr[i], k, minHeap);
            }

            return res;
    }

    private int processInt(int a, int k, PriorityQueue<Integer> minHeap) {
        if (minHeap.size() < k) {
            minHeap.add(a);
            return -1;
        }

        if (a > minHeap.peek()) {
            minHeap.remove();
            minHeap.add(a);
        }

        return minHeap.peek();
    }
}
