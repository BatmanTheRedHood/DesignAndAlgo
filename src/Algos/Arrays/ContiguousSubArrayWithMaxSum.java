package Algos.Arrays;

import models.Algorithm;

/**
 * Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * N = 5
 * arr[] = {1,2,3,-2,5}
 * Output:
 * 9
 * Explanation:
 * Max subarray sum is 9
 * of elements (1, 2, 3, -2, 5) which
 * is a contiguous subarray.
 * Example 2:
 *
 * Input:
 * N = 4
 * arr[] = {-1,-2,-3,-4}
 * Output:
 * -1
 * Explanation:
 * Max subarray sum is -1
 * of element (-1)
 *
 *
 * Your Task:
 * You don't need to read input or print anything. The task is to complete the function maxSubarraySum() which takes arr and N as input parameters and returns the sum of subarray with maximum sum.
 *
 *
 *
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(1)
 */
public class ContiguousSubArrayWithMaxSum extends Algorithm {
    private int[] arr;

    @Override
    protected void init() {
        // this.arr = new int[]{1,2,3,-2,5};
        this.arr = new int[]{-1,-2,-3,-4};
    }

    @Override
    protected void run() {
        this.contiguousSubArrayWithMaxSum();
    }

    private void contiguousSubArrayWithMaxSum(){
        int max = this.arr[0];
        int sum = 0;
        int i = 0;
        int j = 0;

        while (j < this.arr.length) {
            sum += this.arr[j];
            j++;

            if (sum > max) { // Set MAX
                max = sum;
            }

            if (sum <= 0) { // RESET
                i = j;
                sum = 0;
            }
        }

        System.out.println(String.format("Contiguous SubArray With Max Sum: %d", max));
    }
}
