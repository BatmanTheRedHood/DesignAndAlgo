package Algos.DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubstring {
    int longestCommonSubstr(String s1, String s2, int n, int m){
        int[][] alreadyComputed = new int[s1.length()][s2.length()];
        for (int i=0; i<s1.length(); i++)
            Arrays.fill(alreadyComputed[i], -1);

        return maxLengthMatched(s1, s2, 0, 0, "", alreadyComputed);
    }

    int maxLengthMatched(String s1, String s2, int i, int j, String word, int[][] alreadyComputed) {
        if (i >= s1.length() || j>=s2.length())
            return word.length();

        if (alreadyComputed[i][j] != -1)
            return alreadyComputed[i][j];

        // Max substring excluding current Char
        alreadyComputed[i][j] = Math.max(
                maxLengthMatched(s1, s2, i+1, j, "", alreadyComputed),
                maxLengthMatched(s1, s2, i, j+1, "", alreadyComputed));

        // Max substring excluding current Char & including current char if matches
        if (s1.charAt(i) == s2.charAt(j)) {
            word = word + s1.charAt(i);
            alreadyComputed[i][j] = Math.max(alreadyComputed[i][j], maxLengthMatched(s1, s2, i+1, j+1, word, alreadyComputed));
        }

        return alreadyComputed[i][j];
    }
}
