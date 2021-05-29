package Algos.Arrays;

import models.Algorithm;

import java.util.Arrays;
import java.util.List;

/***
 * Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order without using any extra space. Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.
 *
 *
 * Example 1:
 *
 * Input:
 * n = 4, arr1[] = [1 3 5 7]
 * m = 5, arr2[] = [0 2 6 8 9]
 * Output:
 * arr1[] = [0 1 2 3]
 * arr2[] = [5 6 7 8 9]
 * Explanation:
 * After merging the two
 * non-decreasing arrays, we get,
 * 0 1 2 3 5 6 7 8 9.
 * Example 2:
 *
 * Input:
 * n = 2, arr1[] = [10, 12]
 * m = 3, arr2[] = [5 18 20]
 * Output:
 * arr1[] = [5 10]
 * arr2[] = [12 18 20]
 * Explanation:
 * After merging two sorted arrays
 * we get 5 10 12 18 20.
 *
 *
 * Your Task:
 * You don't need to read input or print anything. You only need to complete the function merge() that takes arr1, arr2, n and m as input parameters and modifies them in-place so that they look like the sorted merged array when concatenated.
 *
 *
 * Expected Time Complexity:  O((n+m) log(n+m))
 * Expected Auxilliary Space: O(1)
 *
 *
 * Constraints:
 * 1 <= n, m <= 5*104
 * 0 <= arr1i, arr2i <= 107
 */
public class MergeWithoutExtraSpace extends Algorithm {
    private Integer[] arrA;
    private Integer[] arrB;

    @Override
    protected void init() {
        this.arrA = new Integer[] {10, 12}; // {1, 3, 5, 7};
        this.arrB = new Integer[]{5, 18, 20}; //{0, 2, 6, 8, 9};
    }

    @Override
    protected void run() {
        this.merge();

        System.out.println(Arrays.asList(this.arrA));
        System.out.println(Arrays.asList(this.arrB));
    }

    private void merge(){
        int k = 0;
        int min, max;

        while (k < this.arrA.length) {
            if (this.arrA[k] > this.arrB[0]) {
                min = this.arrB[0];
                max = this.arrA[this.arrA.length - 1];

                // Shift arrA right >>
                for (int i = this.arrA.length - 1; i > k; i--){
                    this.arrA[i] = this.arrA[i-1];
                }

                this.arrA[k] = min;

                // Insert max to arrB
                int j = 1;
                while (this.arrB[j] < max && j < this.arrB.length) {
                    this.arrB[j -1] = this.arrB[j];
                    j++;
                }

                this.arrB[j - 1] = max;
            }

            k++;
        }
    }
}
