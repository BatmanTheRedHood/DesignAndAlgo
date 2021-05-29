package Algos.Strings;

/**
 * Given a array of N strings, find the longest common prefix among all strings present in the array.
 *
 * Example 1:
 *
 * Input:
 * N = 4
 * arr[] = {geeksforgeeks, geeks, geek,
 *          geezer}
 * Output: gee
 * Explanation: "gee" is the longest common
 * prefix in all the given strings.
 * â€‹Example 2:
 *
 * Input:
 * N = 2
 * arr[] = {hello, world}
 * Output: -1
 * Explanation: There's no common prefix
 * in the given strings.
 *
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function longestCommonPrefix() which takes the string array arr[] and its size N as inputs and returns the longest common prefix common in all the strings in the array. If there's no prefix common in all the strings, return "-1".
 *
 *
 * Expected Time Complexity: O(N*max(|arri|)).
 * Expected Auxiliary Space: O(max(|arri|)) for result.
 *
 *
 * Constraints:
 * 1<=N<=103
 * 1<=|arri|<=103
 */
public class LongestCommonPrefixInAnArray {
    String longestCommonPrefix(String arr[], int n){
        // code here
        String prefix = "";

        int charIndex = 0;
        while (true) {
            for (int i=0; i< arr.length; i++) {
                if (charIndex >= arr[i].length() ||
                        arr[i].charAt(charIndex) != arr[0].charAt(charIndex)) {
                    return prefix.length() == 0 ? "-1": prefix;
                }
            }

            prefix += arr[0].charAt(charIndex);
            charIndex++;
        }
    }
}
