package Algos.DivideAndConquer;

public class MergeSort {
    void merge(int arr[], int l, int m, int r) {
        int[] result = new int[r-l + 1];

        int i = l, j = m+1, k=0;
        while (i<=m && j<=r) {
            if (arr[i] < arr[j]) {
                result[k++] = arr[i++];
            } else {
                result[k++] = arr[j++];
            }
        }

        while (i<=m)
            result[k++] = arr[i++];

        while (j<=r)
            result[k++] = arr[j++];

        for (i=0; i<k; i++) {
            arr[l+i] = result[i];
        }
    }

    void mergeSort(int arr[], int l, int r) {
        if (l<r) {
            int mid = (l+r)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }
}
