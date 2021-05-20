package Algos;

import models.Algorithm;

/**
 * Given an array arr[] of N non-negative integers representing the height of blocks. If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season.
 *
 *
 * Example 1:
 *
 * Input:
 * N = 6
 * arr[] = {3,0,0,2,0,4}
 * Output:
 * 10
 * Explanation:
 *
 * Example 2:
 *
 * Input:
 * N = 4
 * arr[] = {7,4,0,9}
 * Output:
 * 10
 * Explanation:
 * Water trapped by above
 * block of height 4 is 3 units and above
 * block of height 0 is 7 units. So, the
 * total unit of water trapped is 10 units.
 * Example 3:
 *
 * Input:
 * N = 3
 * arr[] = {6,9,9}
 * Output:
 * 0
 * Explanation:
 * No water will be trapped.
 *
 * Your Task:
 * You don'y need to read input or print anything. The task is to complete the function trappingWater() which takes arr and N as input parameters and returns the total amount of water that can be trapped.
 *
 *
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(N)
 *
 *
 * Constraints:
 * 3 <= N <= 107
 * 0 <= Ai <= 108
 */
public class TrappingRainWater extends Algorithm {
    private Integer[] arr;

    @Override
    protected void init() {
        //arr = new Integer[]{3,0,0,2,0,4};
        arr = new Integer[]{6,9,9};
    }

    @Override
    protected void run() {
        System.out.println(String.format("Water trapped: %d", rainWaterTrapped()));
    }

    private int rainWaterTrapped(){
        int sum = 0;

        Integer[] leftMax = new Integer[arr.length];
        Integer[] rightMax = new Integer[arr.length];

        // Initialize left max
        leftMax[0] = arr[0];
        for (int i=1; i<arr.length; i++) {
            leftMax[i] = arr[i] > leftMax[i-1] ? arr[i] : leftMax[i -1];
        }

        // Initialize rightMax
        rightMax[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length-2; i>=0; i--){
            rightMax[i] = arr[i] > rightMax[i+1] ? arr[i] : rightMax[i+1];
        }

        // Calculate water trapped.
        for (int i=0; i<arr.length; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);

            sum += min - arr[i];
        }

        return sum;
    }
}
