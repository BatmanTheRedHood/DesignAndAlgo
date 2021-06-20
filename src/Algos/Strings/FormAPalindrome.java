package Algos.Strings;

import models.Algorithm;

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
}
