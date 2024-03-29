package Algos.Strings;

import models.Algorithm;

/**
 * Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S. Incase of conflict, return the substring which occurs first ( with the least starting index).
 *
 *
 * Example 1:
 *
 * Input:
 * S = "aaaabbaa"
 * Output: aabbaa
 * Explanation: The longest Palindromic
 * substring is "aabbaa".
 * â€‹Example 2:
 *
 * Input:
 * S = "abc"
 * Output: a
 * Explanation: "a", "b" and "c" are the
 * longest palindromes with same length.
 * The result is the one with the least
 * starting index.
 *
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function longestPalin() which takes the string S as input and returns the longest palindromic substring of S.
 *
 *
 * Expected Time Complexity: O(|S|2).
 * Expected Auxiliary Space: O(1).
 *
 *
 * Constraints:
 * 1 ≤ |S| ≤ 103
 */
public class LongestPalindromeInAString extends Algorithm {
    @Override
    protected void init() {

    }

    @Override
    protected void run() {
        System.out.println(longestPalindrome("aaaabbaa"));
    }

    private String longestPalindrome(String str){
        String longestPalin = "" + str.charAt(0);
        for (int i=0; i<str.length(); i++) {
            // Handling even length palindrome.
            int leftIndex = i;
            int rightIndex = i+1;
            String word = "";

            while (leftIndex>= 0 && rightIndex < str.length() && str.charAt(leftIndex) == str.charAt(rightIndex)) {
                word = str.charAt(leftIndex) + word + str.charAt(rightIndex);
                leftIndex--;
                rightIndex++;
            }

            if (longestPalin.length() < word.length())
                longestPalin = word;

            // Handle odd length palindrome
            leftIndex = i -1;
            rightIndex = i + 1;
            word = "" + str.charAt(i);

            while (leftIndex >= 0 && rightIndex < str.length() && str.charAt(leftIndex) == str.charAt(rightIndex)) {
                word = str.charAt(leftIndex) + word + str.charAt(rightIndex);
                leftIndex--;
                rightIndex++;
            }

            if (longestPalin.length() < word.length())
                longestPalin = word;

        }

        return longestPalin;
    }
}
