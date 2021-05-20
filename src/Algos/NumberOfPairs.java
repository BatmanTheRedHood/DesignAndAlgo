package Algos;

import models.Algorithm;

import java.util.Arrays;

/***
 * Given two arrays X and Y of positive integers, find the number of pairs such that xy > yx (raised to power of) where x is an element from X and y is an element from Y.
 *
 * Example 1:
 *
 * Input:
 * M = 3, X[] = [2 1 6]
 * N = 2, Y[] = [1 5]
 * Output: 3
 * Explanation:
 * The pairs which follow xy > yx are
 * as such: 21 > 12,  25 > 52 and 61 > 16 .
 * Example 2:
 *
 * Input:
 * M = 4, X[] = [2 3 4 5]
 * N = 3, Y[] = [1 2 3]
 * Output: 5
 * Explanation:
 * The pairs for the given input are
 * 21 > 12 , 31 > 13 , 32 > 23 , 41 > 14 ,
 * 51 > 15 .
 *
 * Your Task:
 * This is a function problem. You only need to complete the function countPairs() that takes X, Y, M, N as parameters and returns the total number of pairs.
 *
 * Expected Time Complexity: O((N + M)log(N)).
 * Expected Auxiliary Space: O(1).
 *
 * Constraints:
 * 1 ≤ M, N ≤ 105
 * 1 ≤ X[i], Y[i] ≤ 103
 */
public class NumberOfPairs extends Algorithm {
    private Integer[] arrX;
    private Integer[] arrY;

    @Override
    protected void init() {
        this.arrX = new Integer[]{1, 1, 2,2, 3,  3, 4, 5, 5,5,5,76,8,86,66,7,7,7,10,8,10,8,8,6}; //{2, 1, 6};
        this.arrY = new Integer[]{1, 2, 3}; //{1, 5};
    }

    @Override
    protected void run() {
        System.out.println(String.format("No of pairs: %d", this.findPairs()));
        /*Arrays.sort(arrX);
        System.out.println(String.format("ArrrX length %d", arrX.length));
        System.out.println(Arrays.asList(arrX));

        int key = 100;
        System.out.println(String.format("Index on smallest number gt %d in x: %d",
                key, BinarySearch.searchGreater(arrX, key, 0, arrX.length-1, Integer::compare)));

         */
    }

    private int findPairs(){
        // Sort arrays
        Arrays.sort(this.arrX);
        Arrays.sort(this.arrY);

        /**
         * Following are the exceptions :
         *
         * if x = 0, then count for this is 0.
         *  if x = 1, then count is total no of 0s in Y[] only.
         * if x = 2, for y = 3, y = 4, the above property does not hold, and the count should be decreased
         * if x = 3, for x = 2, the count need to be increased
         int y2s = 0;
         int y34s = 0;
         */

        // loop through arrX, for each x, find y's index i.e. y >= x. sum
        int sum = 0;
        for (int i=0; i<this.arrX.length; i++) {
            if (this.arrX[i] >= this.arrY[this.arrY.length - 1])
                break;

            if (this.arrX[i] == 1)
                continue;

            int yIndex = BinarySearch.searchGreater(
                    this.arrY, this.arrX[i], 0, this.arrY.length - 1, Integer::compare);

            System.out.println(String.format("For %d in X, y is %d", this.arrX[i], yIndex >=0? this.arrY[yIndex] : -1));

            sum += yIndex >= 0? this.arrY.length - yIndex : 0;
        }

        // Handle exception case i.e. if Y has 1, all X > 1 makes a pair
        if (Arrays.binarySearch(this.arrY, 1) == 0) {
            int xIndex = BinarySearch.searchGreater(this.arrX, 1, 0, this.arrX.length - 1, Integer::compare);
            System.out.println(String.format("Index of number greater than 1 in X: %d", xIndex));

            sum += xIndex >=0 ? this.arrX.length - xIndex : 0;
        }


        return sum;
    }
}
