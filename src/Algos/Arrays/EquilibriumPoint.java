package Algos.Arrays;

import models.Algorithm;

import java.util.ArrayList;
import java.util.List;

/***
 * Given an array A of n positive numbers. The task is to find the first Equilibium Point in the array.
 * Equilibrium Point in an array is a position such that the sum of elements before it is equal to the sum of elements after it.
 *
 * Example 1:
 *
 * Input:
 * n = 1
 * A[] = {1}
 * Output: 1
 * Explanation: Since its the only
 * element hence its the only equilibrium
 * point.
 * Example 2:
 *
 * Input:
 * n = 5
 * A[] = {1,3,5,2,2}
 * Output: 3
 * Explanation: For second test case
 * equilibrium point is at position 3
 * as elements before it (1+3) =
 * elements after it (2+2).
 *
 *
 * Your Task:
 * The task is to complete the function equilibriumPoint() which takes the array and n as input parameters and returns the point of equilibrium. Return -1 if no such point exists.
 *
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 *
 * Constraints:
 * 1 <= n <= 106
 * 1 <= A[i] <= 108
 */
public class EquilibriumPoint extends Algorithm {
    private Integer[] arr;

    @Override
    protected void init() {
        arr = new Integer[]{1,3,5,2,2};
    }

    @Override
    protected void run() {
        System.out.println(String.format("Equilibrium point: %d", find()));
    }

    private int find(){
        int sum = 0;
        for (int i=0; i<arr.length; i++){
            sum += arr[i];
        }

        int leftSum = 0;
        for (int i=0; i<arr.length; i++){
            if (i>0)
                leftSum += arr[i-1];

            int rightSum = sum - leftSum - arr[i];
            if (leftSum == rightSum)
                return i;
        }

        return -1;
    }
}
