package Algos.Strings;

import models.Algorithm;

import java.util.HashMap;
import java.util.Map;

public class LongestDistinctCharactersInString extends Algorithm {
    @Override
    protected void init() {

    }

    @Override
    protected void run() {
        System.out.println(longestSubstrDistinctChars("geeksforgeeks"));
    }

    private int longestSubstrDistinctChars(String str){
        int start = 0, end = 0, longest = 0;
        int[] charMap = new int['z' - 'A' + 1];
        for (int i='A'; i<= 'z'; i++) {
            charMap[i - 'A'] = -1;
        }

        // Map<Character, Integer> charMap = new HashMap<>();

        while (end < str.length()){
            int currentCharIndex = str.charAt(end) - 'A';
            int currentCharLastOccurrence = charMap[currentCharIndex];

            // Found duplicate
            if (currentCharLastOccurrence != -1 && currentCharLastOccurrence >= start) {
                // Check and update longest;
                int distinctCharsWidth = end - start;
                if (distinctCharsWidth > longest)
                    longest = distinctCharsWidth;

                start = currentCharLastOccurrence + 1;
            }

            charMap[currentCharIndex] = end;
            end++;
        }

        // Check last diff
        int distinctCharsWidth = end - start;
        if (distinctCharsWidth > longest)
            longest = distinctCharsWidth;

        return longest;
    }
}
