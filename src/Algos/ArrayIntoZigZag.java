package Algos;

import models.Algorithm;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array Arr (distinct elements) of size N. Rearrange the elements of array in zig-zag fashion. The converted array should be in form a < b > c < d > e < f. The relative order of elements is same in the output i.e you have to iterate on the original array only.
 *
 * Example 1:
 *
 * Input:
 * N = 7
 * Arr[] = {4, 3, 7, 8, 6, 2, 1}
 * Output: 3 7 4 8 2 6 1
 * Explanation: 3 < 7 > 4 < 8 > 2 < 6 > 1
 * Example 2:
 *
 * Input:
 * N = 4
 * Arr[] = {1, 4, 3, 2}
 * Output: 1 4 2 3
 * Explanation: 1 < 4 > 2 < 3
 */
public class ArrayIntoZigZag extends Algorithm {
    private Integer[] arr;

    @Override
    protected void init() {
        arr = new Integer[]{4, 3, 7, 8, 6, 2, 1};
    }

    @Override
    protected void run() {
        System.out.println(Arrays.asList(arr));
        makeZigZag();
        System.out.println(Arrays.asList(arr));
    }

    private void makeZigZag() {
        for (int i=0; i<arr.length -1; i++) {
            if (i%2 == 0) {
                if (arr[i] > arr[i+1])
                    swap(arr, i, i+1);
            } else {
                if (arr[i] < arr[i+1])
                    swap(arr, i, i+1);
            }
        }
    }

    private void swap(Integer[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
