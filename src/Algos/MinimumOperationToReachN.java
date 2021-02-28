package Algos;

import models.Algorithm;

/**
 * Given a number N. Find the minimum number of operations required to reach N starting from 0. You have 2 operations available:
 *
 * Double the number
 * Add one to the number
 *
 * Example 1:
 *
 * Input:
 * N = 8
 * Output: 4
 * Explanation: 0 + 1 = 1, 1 + 1 = 2,
 * 2 * 2 = 4, 4 * 2 = 8
 *
 * Example 2:
 *
 * Input:
 * N = 7
 * Output: 5
 * Explanation: 0 + 1 = 1, 1 + 1 = 2,
 * 1 + 2 = 3, 3 * 2 = 6, 6 + 1 = 7
 * https://practice.geeksforgeeks.org/problems/find-optimum-operation4504/1
 * 
 * DP problem: 
 * 1. Top to bottom traversal: Recursive. Or close to far traversal: Iterative. Consider stop condition or base condition.
 * 2. Save previous calculated result. DP mool mantra. 
 */
public class MinimumOperationToReachN extends Algorithm {
    private int n;
    @Override
    protected void init() {
        this.n = 8;
    }

    @Override
    protected void run() {
        // Initialize result array with infinte no. of operations
        int[] noOfOps = new int[this.n + 1];
        for (int i = 0; i < noOfOps.length; i++) {
            noOfOps[i] = Integer.MAX_VALUE; // Careful while using MAX_VALUE. MAX_VLAUE + 1 will give min value.
        }

        //System.out.println(String.format("No. of operations: %d", 1 + findNoOfOperations(1, this.n, noOfOps)));
        iterativeSol();

    }

    // Recursive solution
    private int findNoOfOperations(int start, int end,  int[] noOfOps){
        // Base condition.
        if (start == end) {
            return 0;
        }

        // Out of boundary. Not possible moves
        if (start > end) {
            return Integer.MAX_VALUE;
        }

        // Use pre-calculated result
        if (noOfOps[start] != Integer.MAX_VALUE) {
            return noOfOps[start];
        }

        // The Algo.
        noOfOps[start] = 1 + Math.min(
                findNoOfOperations(start + 1, end, noOfOps),
                findNoOfOperations(2* start, end, noOfOps));

        return noOfOps[start];
    }

    private void iterativeSol(){
        int[] noOfOps = new int[this.n + 1];
        noOfOps[n]= 0;
        for (int i = n-1; i > 0 ; i--){
            if (2 * i > n) {
                noOfOps[i] = 1 + noOfOps[i + 1];
            } else {
                noOfOps[i] = Math.min(1 + noOfOps[i + 1] , 1 + noOfOps[2* i]);
            }
        }

        System.out.println(String.format("No. of operations: %d", 1 + noOfOps[1]));
    }
}
