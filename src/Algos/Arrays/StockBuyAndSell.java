package Algos.Arrays;

import models.Algorithm;

import java.util.ArrayList;

/***
 * The cost of stock on each day is given in an array A[] of size N. Find all the days on which you buy and sell the stock so that in between those days your profit is maximum.
 * Note: There may be multiple possible solutions. Return any one of them.
 *
 * Example 1:
 *
 * Input:
 * N = 7
 * A[] = {100,180,260,310,40,535,695}
 * Output:
 * 1
 * Explanation:
 * One possible solution is (0 3) (4 6)
 * We can buy stock on day 0,
 * and sell it on 3rd day, which will
 * give us maximum profit. Now, we buy
 * stock on day 4 and sell it on day 6.
 * Example 2:
 *
 * Input:
 * N = 5
 * A[] = {4,2,2,2,4}
 * Output:
 * 1
 * Explanation:
 * There are multiple possible solutions.
 * one of them is (3 4)
 * We can buy stock on day 3,
 * and sell it on 4th day, which will
 * give us maximum profit.
 *
 * Your Task:
 * The task is to complete the function stockBuySell() which takes an array A[] and N as input parameters and finds the days of buying and selling stock. The function must return a 2D list of integers containing all the buy-sell pairs. If there is No Profit, return an empty list. The driver code will return 1 if your answer is correct, otherwise, it will return 0. In case there's no profit the driver code will return the string "No Profit" for a correct solution.
 *
 *
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(N)
 *
 *
 * Constraints:
 * 2 ≤ N ≤ 106
 * 0 ≤ A[i] ≤ 106
 */
public class StockBuyAndSell extends Algorithm {
    private int[] A;

    @Override
    protected void init() {
        A = new int[]{4,2,2,2,4}; //{100,180,260,310,40,535,695};
    }

    @Override
    protected void run() {
        System.out.println(buySell());
    }

    private ArrayList<ArrayList<Integer>> buySell() {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int start = 0;
        int end  = 0;

        for (int i=0; i<A.length - 1; i++) {
            if (A[i]< A[i+1]) {
                end = i+1;
            } else {
                if (start < end) {
                    // Save pair.
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(start);
                    pair.add(end);
                    result.add(pair);
                }

                start = i+1;
                end = start;
            }
        }

        // Save last pair
        if (start < end) {
            // Save
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(start);
            pair.add(end);
            result.add(pair);
        }

        return result;
    }
}
