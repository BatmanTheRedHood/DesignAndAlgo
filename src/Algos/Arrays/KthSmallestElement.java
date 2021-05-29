package Algos.Arrays;

import models.Algorithm;

import java.util.*;

/**
 * Given an array arr[] and a number K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.
 *
 * Example 1:
 *
 * Input:
 * N = 6
 * arr[] = 7 10 4 3 20 15
 * K = 3
 * Output : 7
 * Explanation :
 * 3rd smallest element in the given
 * array is 7.
 * Example 2:
 *
 * Input:
 * N = 5
 * arr[] = 7 10 4 20 15
 * K = 4
 * Output : 15
 * Explanation :
 * 4th smallest element in the given
 * array is 15.
 * Your Task:
 * You don't have to read input or print anything. Your task is to complete the function kthSmallest() which takes the array, it's size and an integer k as input and returns the kth smallest element.
 *
 *
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 * Constraints:
 * 1 <= N <= 105
 * 1 <= arr[i] <= 105
 * 1 <= K <= N
 */
public class KthSmallestElement extends Algorithm {
    private Integer[] arr;
    private int k;

    @Override
    protected void init() {
        arr = new Integer[]{7, 10, 4, 3, 20, 15};
        // arr = new Integer[]{7, 10, 4, 20, 15};
        k = 5;
    }

    @Override
    protected void run() {
        System.out.println(String.format("%dth smallest no. : %d", k, kthSmallest(k -1)));
    }

    // Assumption: k is less than size of arr
    private int kthSmallest(int k) {
        System.out.println(Arrays.asList(arr));

        int start = 0;
        int end = arr.length - 1;
        int partition = partition(arr, start, end);
        System.out.println(String.format("Partition: %d", partition));
        System.out.println(Arrays.asList(arr));

        while (partition != k) {
            if (partition < k) {
                start = partition + 1;
            } else {
                end = partition - 1;
            }

            partition = partition(arr, start, end);
            System.out.println(String.format("Partition: %d", partition));
            System.out.println(Arrays.asList(arr));
        }

        return arr[partition];
    }

    private int partition(Integer[] arr, int start, int end){
        // Added random pivot to avoid worst case complexity
        int randomNum = start + (int)(Math.random() * ((end - start) + 1));
        swap(arr, randomNum, end);

        int pivot = end;

        end = end - 1;
        while (start <= end) {
            while (start <= end && arr[start] <= arr[pivot])
                start++;

            while (start <= end && arr[end] >= arr[pivot])
                end --;

            if (start < end )
                swap(arr, start, end);
        }

        // start will stop to element >= pivot after crossing end
        swap(arr, start, pivot);

        return start;
    }

    private void swap(Integer arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
