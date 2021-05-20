package Algos;

import models.Algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them in such a manner that they form the largest number possible.The result is going to be very large, hence return the result in the form of a string.
 *
 * Example 1:
 *
 * Input:
 * N = 5
 * Arr[] = {3, 30, 34, 5, 9}
 * Output: 9534330
 * Explanation: Given numbers are {3, 30, 34,
 * 5, 9}, the arrangement 9534330 gives the
 * largest value.
 * Example 2:
 *
 * Input:
 * N = 4
 * Arr[] = {54, 546, 548, 60}
 * Output: 6054854654
 * Explanation: Given numbers are {54, 546,
 * 548, 60}, the arrangement 6054854654
 * gives the largest value.
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function printLargest() which takes the array of strings arr[] as parameter and returns a string denoting the answer.
 *
 * Expected Time Complexity: O(NlogN)
 * Expected Auxiliary Space: O(1)
 *
 * Constraints:
 * 1 ≤ N ≤ 10^5
 * 0 ≤ Arr[i] ≤ 10^18
 */
public class LargestNumberFormedFromArray extends Algorithm {
    private Integer[] numbers;

    @Override
    protected void init() {
        this.numbers = new Integer[]{3, 30, 34, 5, 9};
    }

    @Override
    protected void run() {
        Arrays.sort(this.numbers, new CompareByDigitValue());

        //System.out.println(); doesn't print full array but print full collection.
        Arrays.asList(this.numbers).forEach(n -> System.out.print(n));
    }

    private String printLargest(String[] arr) {
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return compareStrNum(a+b, b+a);
            }

            private int compareStrNum(String ab, String ba){
                for (int i=0; i<ab.length(); i++){
                    int compareResult = Character.compare(ab.charAt(i), ba.charAt(i));

                    if (compareResult !=0)
                        return compareResult;
                }

                return 0;
            }
        });

        String result = "";
        for (int i=0; i<arr.length; i++){
            result += arr[i];
        }

        return result;
    }

    // Comparator type arg cannot be primitive type. Collection APIs doesn't work
    private class CompareByDigitValue implements Comparator<Integer>{
        @Override
        public int compare(Integer a, Integer b) {
            return -Integer.compare(this.getABNum(a, b), this.getABNum(b, a));
        }

        private int getABNum(int a, int b){
            int base = 10;
            while ((double)(b / base) >= 1){
                base *= 10;
            }

            return a * base + b;
        }
    }
}
