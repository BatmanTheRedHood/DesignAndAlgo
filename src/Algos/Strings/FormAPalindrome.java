package Algos.Strings;

import models.Algorithm;

import java.util.Arrays;

/**
 * Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
 * For Example:
 * ab: Number of insertions required is 1. bab or aba
 * aa: Number of insertions required is 0. aa
 * abcd: Number of insertions required is 3. dcbabcd
 *
 *
 * Example 1:
 *
 * Input: str = "abcd"
 * Output: 3
 * Explanation: Inserted character marked
 * with bold characters in dcbabcd
 * Example 2:
 *
 * Input: str = "aa"
 * Output: 0
 * Explanation:"aa" is already a palindrome.
 *
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function countMin() which takes the string str as inputs and returns the answer.
 *
 * Expected Time Complexity: O(N2), N = |str|
 * Expected Auxiliary Space: O(N2)
 *
 * Constraints:
 * 1 ≤ |str| ≤ 103
 * str contains only lower case alphabets.
 */
public class FormAPalindrome extends Algorithm {
    @Override
    protected void init() {

    }

    @Override
    protected void run() {
        System.out.println("FormAPalindrome Not working!");
        System.out.println(countMin("abcddd"));
    }

    private int countMin3(String str) {
        int[][] computedResult = new int[str.length()][str.length()];
        for (int i=0; i<str.length(); i++) {
            Arrays.fill(computedResult[i], -1);
        }

        return formPalindrome(str, 0, str.length() -1, computedResult);
    }

    private int formPalindrome(String str, int start, int end, int[][] computedResult) {
        if (computedResult[start][end] != -1)
            return computedResult[start][end];

        if (start > end)
            return 0;

        if (start == end)
            return 0;

        if (str.charAt(start) == str.charAt(end)) {
            computedResult[start][end] = formPalindrome(str, start + 1, end - 1, computedResult);
        } else {
            computedResult[start][end] = 1 + Math.min(formPalindrome(str, start + 1, end, computedResult),
                    formPalindrome(str, start, end - 1, computedResult));
        }

        return computedResult[start][end];
    }

    /**
     * Wrong Answer. !!!Wrong Answer
     *
     * Possibly your code doesn't work correctly for multiple test-cases (TCs).
     *
     * The first test case where your code failed:
     *
     * Input:
     * helppreanadkada
     *
     * Its Correct output is:
     * 10
     *
     * And Your Code's output is:
     * 12
     * @param str = helppreanadkada
     * @return = 12 expected 10
     */
    private  int countMin(String str) {
        if (isPalin(str, 0, str.length() -1))
            return 0;

        int longestPalin = 0;
        for (int i=0; i<str.length(); i++) {
            int currentPalinLength = palinLength(str, i);
            if (currentPalinLength > longestPalin)
                longestPalin = currentPalinLength;

        }

        return str.length() - longestPalin;
    }

    private boolean isPalin(String str, int start, int end)     {
        while (start < end ) {
            if (str.charAt(start) != str.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }

    private int palinLength(String str, int source) {
        int i, j;

        // Even length palindrome
        i = source;
        j = source+1;
        while (i >=0 && j < str.length() && str.charAt(i) == str.charAt(j)) {
            i--;
            j++;
        }

        int evenLongestPalin = j - i - 1;

        // Odd length palindrome
        i = source - 1;
        j = source + 1;
        while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)) {
            i--;
            j++;
        }

        int oddLongestPalin = j - i - 1;

        return Math.max(evenLongestPalin, oddLongestPalin);
    }

    // "abc"
    private int countMin2(String str) {
        // Null or empty or 1 length return 0
        if (str == null || str.length() == 0)
            return 0;

        int maxPalinLength = 1;

        // Find palins from start with length str.length() to 2 till we find one
        for (int len = str.length(); len > 1; len--) {
            if (isPalin2(str, 0, len -1)) {
                maxPalinLength = len;
                break; // Break as other lengths will be smaller
            }
        }

        if (maxPalinLength == str.length())
            return 0;

        // Find palins from end
        for (int i = 1; i < str.length(); i++) {
            if (isPalin2(str, i, str.length() - 1)) {
                maxPalinLength = Math.max(maxPalinLength, str.length() - i);
                break;
            }
        }

        return str.length() - maxPalinLength;
    }

    private boolean isPalin2(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }
}
