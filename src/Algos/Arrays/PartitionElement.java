package Algos.Arrays;

import models.Algorithm;

/**
 * Given an unsorted array of size N. Find the first element in array such that all of its left elements are smaller and all right elements to it are greater than it.
 * Element with left side smaller and right side greater
 * Note: Left and right side elements can be equal to required element. And extreme elements cannot be required element.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * N = 4
 * A[] = {4, 2, 5, 7}
 * Output:
 * 5
 * Explanation:
 * Elements on left of 5 are smaller than 5
 * and on right of it are greater than 5.
 *
 *
 * Example 2:
 *
 * Input:
 * N = 3
 * A[] = {11, 9, 12}
 * Output:
 * -1
 */
public class PartitionElement extends Algorithm {
    private int[] arr;

    @Override
    protected void init() {
        arr = new int[]{11, 9, 12}; //{4, 2, 5, 7};
    }

    @Override
    protected void run() {
        System.out.println(String.format("Partition element: %d", findElement()));
    }

    public int findElement(){
        int[] leftMax = new int[arr.length];
        int[] rightMin = new int[arr.length];

        // left max
        leftMax[0] = arr[0];
        for (int i=1; i<arr.length; i++) {
            leftMax[i] = arr[i]>leftMax[i-1]? arr[i]: leftMax[i-1];
        }

        // right min
        rightMin[arr.length - 1] = arr[arr.length - 1];
        for(int i=arr.length-2; i>=0; i--){
            rightMin[i] = arr[i] < rightMin[i+1]? arr[i]: rightMin[i+1];
        }

        for(int i=1; i<arr.length-1; i++) {
            if (leftMax[i] == rightMin[i])
                return arr[i];
        }

        return -1;
    }
}
