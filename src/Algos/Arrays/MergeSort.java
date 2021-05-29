package Algos.Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort {
    public static <T> void sort(T[] arr, Comparator<? super T> c){
        mergeSort(arr, 0, arr.length - 1, c);
    }

    private static <T> void mergeSort(T[] arr, int start, int end, Comparator<? super T> c){
        if (start < end) {
            int mid = (int) ((start + end)%2 == 0? (start + end)/2 : (start + end -1)/2);

            mergeSort(arr, start, mid, c);
            mergeSort(arr, mid+1, end, c);
            merge(arr, start, mid, end, c);
        }
    }

    private static <T> void merge(T[] arr, int start, int mid, int end, Comparator<? super T> c){
        int i = start;
        int j = mid + 1;
        List<T> mergeArr = new ArrayList<>(end - start + 1);

        /*
        * Wanted to create arr of type T. But cannot initialize with new keyword
        * int k = 0;
        * T[] mergeArr = new T[end - start + 1];
        */

        // Merge
        while (i <= mid && j <= end) {
            if (c.compare(arr[i], arr[j]) < 0) {
                mergeArr.add(arr[i++]);
            } else {
                mergeArr.add(arr[j++]);
            }
        }

        while (i <= mid) {
            mergeArr.add(arr[i++]);
        }

        while (j <= end) {
            mergeArr.add(arr[j++]);
        }

        // Copy from start position to end position in array.
        for (int k=start; k <= end; k++){
            arr[k] = mergeArr.get(k - start);
        }
    }
}
