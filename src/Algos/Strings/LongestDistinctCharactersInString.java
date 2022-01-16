package Algos.Strings;

import models.Algorithm;

import java.util.Arrays;
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

        //Arrays.fill(charMap, -1); Or use hashmap. map.getOrDefault
        for (int i='A'; i<= 'z'; i++) {
            charMap[i - 'A'] = -1;
        }

        while (end < str.length()){
            int currentCharIndex = str.charAt(end) - 'A';
            int currentCharLastOccurrence = charMap[currentCharIndex];

            // Found duplicate
            if (currentCharLastOccurrence != -1 && currentCharLastOccurrence >= start) {
                // Check and update longest;
                longest = Math.max(longest, end-start);
                start = currentCharLastOccurrence + 1;
            }

            charMap[currentCharIndex] = end;
            end++;
        }

        // Check last diff
        return Math.max(longest, end-start);
    }

    int atoi(String str)
    {
        // Your code here
        int num = 0, base = 1;

        for (int i=str.length() - 1; i>=0; i--) {
            if (str.charAt(i) == '-') {
                if (i==0)
                    return -num;

                return -1;
            }

            if (str.charAt(i) < '0' || str.charAt(i) > '9')
                return -1;

            int currentCharInt = str.charAt(i) - '0';
            num += currentCharInt * base;
            base *= 10;
        }

        return num;
    }

}
