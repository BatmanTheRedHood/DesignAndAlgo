package Algos.Heap;

import java.util.Arrays;

public class BinaryMaxHeap {
    //Function to sort an array using Heap Sort. MAX heap
    public void heapSort(int arr[]) {
        buildHeap(arr, arr.length);

        System.out.println(Arrays.asList(arr));
        int size = arr.length;
        for (int i = size; i >= 2; i--) {
            swap(arr, adjustI(1), adjustI(i));
            size--;
            maxHeapify(arr, 1, size);
        }
    }

    //Function to build a Heap from array.
    void buildHeap(int arr[], int n) {
        for (int i = n % 2 == 0 ? n/2 : (n-1)/2; i >= 1; i--) {
            maxHeapify(arr, i, n);
        }
    }

    //Heapify function to maintain heap property.
    // Assumption i is in array range
    void maxHeapify(int arr[], int i, int n) {
        int largest = i;
        int left = 2*i;
        int right = 2*i + 1;

        // Compare with left child if exist
        if (left <= n && arr[adjustI(left)] > arr[adjustI(i)]) {
            largest = left;
        }

        // compare with right child if exist
        if (right <= n && arr[adjustI(right)] > arr[adjustI(largest)]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, adjustI(largest), adjustI(i));
            maxHeapify(arr, largest, n);
        }
    }

    private int adjustI(int index) {
        return index - 1;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private void print(int[] arr) {
        for (int i=0;i<arr.length;i++)
            System.out.print(arr[i]);

        System.out.println();
    }
}
