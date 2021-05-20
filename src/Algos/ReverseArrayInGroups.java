package Algos;

import models.Algorithm;

import java.util.Arrays;

/**
 * Given an array arr[] of positive integers of size N. Reverse every sub-array group of size K.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * N = 5, K = 3
 * arr[] = {1,2,3,4,5}
 * Output: 3 2 1 5 4
 * Explanation: First group consists of elements
 * 1, 2, 3. Second group consists of 4,5.
 *
 *
 * Example 2:
 *
 * Input:
 * N = 4, K = 3
 * arr[] = {5,6,8,9}
 * Output: 8 6 5 9
 *
 *
 * Your Task:
 * You don't need to read input or print anything. The task is to complete the function reverseInGroups() which takes the array, N and K as input parameters and modifies the array in-place.
 *
 *
 *
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(N)
 *
 *
 *
 * Constraints:
 * 1 ≤ N, K ≤ 107
 * 1 ≤ A[i] ≤ 1018
 */
public class ReverseArrayInGroups extends Algorithm {
    private Integer[] arr;

    @Override
    protected void init() {
        arr = new Integer[]{1,2,3, 4, 5};
    }

    @Override
    protected void run() {
        reverseInGroup(3);

        System.out.println(Arrays.asList(arr));
    }

    private void reverseInGroup(int k){
        int start = 0;
        while (start < arr.length) {
            int end = start + k - 1;
            reverse(arr, start, end < arr.length? end : arr.length-1);
            start = end + 1;
        }
    }

    private <T> void reverse(T[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private <T> void swap(T[] arr, int a, int b) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
