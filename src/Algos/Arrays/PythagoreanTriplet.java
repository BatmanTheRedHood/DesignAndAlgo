package Algos.Arrays;

import models.Algorithm;

import java.util.Arrays;

/**
 * Given an array arr of N integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2, otherwise false.
 *
 * Example 1:
 *
 * Input:
 * N = 5
 * Arr[] = {3, 2, 4, 6, 5}
 * Output: Yes
 * Explanation: a=3, b=4, and c=5 forms a
 * pythagorean triplet.
 * Example 2:
 *
 * Input:
 * N = 3
 * Arr[] = {3, 8, 5}
 * Output: No
 * Explanation: No such triplet possible.
 * Your Task:
 * Complete the function checkTriplet() which takes an array arr, single integer n, as input parameters and returns boolean denoting answer to the problem. You don't to print answer or take inputs.
 * Note: The driver will print "Yes" or "No" instead of boolean.
 *
 * Expected Time Complexity: O(max(Arr[i])2)
 * Expected Auxiliary Space: O(max(Arr[i]))
 *
 * Constraints:
 * 1 <= N <= 107
 * 1 <= Arr[i] <= 1000
 */
public class PythagoreanTriplet extends Algorithm {
    private Integer[] arr;
    @Override
    protected void init() {
        arr= new Integer[]{3, 2, 4, 6, 5};
    }

    @Override
    protected void run() {
        findTripletImproved();
    }

    private void findTripletBF(){
        // Square array
        for (int i=0; i<arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }

        Arrays.sort(arr);

        for (int i=0; i<arr.length-2; i++) {
            for(int j= i+1; j<arr.length - 1; j++) {
                int search = Arrays.binarySearch(arr, j+1, arr.length-1, arr[i]+ arr[j]);
                if (search >= 0) {
                    System.out.println(String.format("%d + %d = %d", arr[i], arr[j], arr[search]));
                }
            }
        }
    }

    private void findTripletImproved(){
        // Square array
        for (int i=0; i<arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }

        Arrays.sort(arr);
        for(int i=arr.length-1; i> 1; i--) {
            // find a and b such that arr[a] + arr[b] = arr[i];
            int start = 0;
            int end = i-1;

            while (start < end) {
                int sum = arr[start] + arr[end];
                if (sum == arr[i]) {
                    System.out.println(String.format("%d + %d = %d", arr[start], arr[end], arr[i]));
                    break;
                } else if (sum > arr[i]) {
                    end--;
                } else {
                    start++;
                }
            }
        }
    }
}
