package Algos.Strings;

import models.Algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Input:
 * MMMDCCXCIV
 *
 * Its Correct output is:
 * 3794
 *
 * Given a string in roman no format (s)  your task is to convert it to an integer . Various symbols and their values are given below.
 * I 1
 * V 5
 * X 10
 * L 50
 * C 100
 * D 500
 * M 1000
 *
 * Example 1:
 *
 * Input:
 * s = V
 * Output: 5
 * Example 2:
 *
 * Input:
 * s = III
 * Output: 3
 * Your Task:
 * Complete the function romanToDecimal() which takes an string as input parameter and returns the equivalent decimal number.
 *
 * Expected Time Complexity: O(|S|), |S| = length of string S.
 * Expected Auxiliary Space: O(1)
 *
 * Constraints:
 * 1<=roman no range<=3999
 */
public class RomanNumberToInteger extends Algorithm {
    @Override
    protected void init() {

    }

    @Override
    protected void run() {
        System.out.println(romanToDecimal("MMMDCCXCIV"));
    }

    private int romanToDecimal(String str) {
        Map<Character, Integer> symbolMap = new HashMap<>();
        symbolMap.put('I', 1);
        symbolMap.put('V', 5);
        symbolMap.put('X', 10);
        symbolMap.put('L', 50);
        symbolMap.put('C', 100);
        symbolMap.put('D', 500);
        symbolMap.put('M', 1000);

        char lastChar = str.charAt(0);
        int lastCharValue = symbolMap.get(lastChar);
        int currSum = lastCharValue;

        for (int i=1; i<str.length(); i++){
            int currentSymbolValue = symbolMap.get(str.charAt(i));
            if (lastCharValue < currentSymbolValue) {
                currSum += currentSymbolValue - 2* lastCharValue; // as lastCharValue was added earlier
            } else {
                currSum += currentSymbolValue;
            }

            lastCharValue = currentSymbolValue;
        }

        return currSum;
    }
}
