package Algos;

import models.ABNumberPair;
import models.Algorithm;

import java.util.Arrays;

/**
 * You are given N pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. You have to find the longest chain which can be formed from the given set of pairs.
 *
 *
 * Example 1:
 *
 * Input:
 * N = 5
 * P[] = {5  24 , 39 60 , 15 28 , 27 40 , 50 90}
 * Output: 3
 * Explanation: The given pairs are { {5, 24}, {39, 60},
 * {15, 28}, {27, 40}, {50, 90} },the longest chain that
 * can be formed is of length 3, and the chain is
 * {{5, 24}, {27, 40}, {50, 90}}
 */
public class MaxLengthChain extends Algorithm {
    private ABNumberPair[] numberPairs;

    @Override
    protected void init() {
        /*
        this.numberPairs = new ABNumberPair[5];
        this.numberPairs[0] = new ABNumberPair(5,  24);
        this.numberPairs[1] = new ABNumberPair(39, 60);
        this.numberPairs[2] = new ABNumberPair(15, 28);
        this.numberPairs[3] = new ABNumberPair(27, 40);
        this.numberPairs[4] = new ABNumberPair(50, 90);
        */

        this.numberPairs = new ABNumberPair[2];
        this.numberPairs[0] = new ABNumberPair(5,  10);
        this.numberPairs[1] = new ABNumberPair(1, 11);
        Arrays.sort(this.numberPairs);
    }

    // Iterative DP sol. No need to consider lots of base condition as solution starts from base where things looks simple
    @Override
    protected void run() {
        // Initialize result array. Max chain with index origin. Left contains including length. Right contains excluding.
        // Actual max length of index origin is max of left and right.
        int[][] maxChainsWithOrigin = new int[this.numberPairs.length][2];
        maxChainsWithOrigin[this.numberPairs.length - 1][0] = 1; // Max length including index pair
        maxChainsWithOrigin[this.numberPairs.length - 1][1] = 0; // Max length excluding index pair

        for (int i = this.numberPairs.length - 2; i >= 0 ; i--){
            // Excluding length
            maxChainsWithOrigin[i][1] = Math.max(maxChainsWithOrigin[i + 1][0], maxChainsWithOrigin[i + 1][1]);

            // Including length
            if (this.numberPairs[i].b < this.numberPairs[i+1].a) {
                maxChainsWithOrigin[i][0] = 1 + maxChainsWithOrigin[i][1];
            } else {
                maxChainsWithOrigin[i][0] = 1 + maxChainsWithOrigin[i + 1][1];
            }
        }

        System.out.println(
                String.format("Max chain length: %d", Math.max(maxChainsWithOrigin[0][0], maxChainsWithOrigin[0][1])));
    }
}