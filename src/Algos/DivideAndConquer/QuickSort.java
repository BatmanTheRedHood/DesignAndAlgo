package Algos.DivideAndConquer;

public class QuickSort {
    //Function to sort an array using quick sort algorithm.
    void quickSort(int arr[], int low, int high) {
        // code here
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    int partition(int arr[], int low, int high) {
        // your code here
        int pivot = high;

        int i = low, j = high - 1;
        while (i<j) {
            while (i<j && arr[i]< arr[pivot])
                i++;

            while (i<j && arr[j] >= arr[pivot])
                j--;

            swap(arr, i, j);
        }

        if (arr[i] >= arr[pivot]) { // Catch:
            swap(arr, i, pivot);
            return i;
        }

        return pivot;
    }

    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
