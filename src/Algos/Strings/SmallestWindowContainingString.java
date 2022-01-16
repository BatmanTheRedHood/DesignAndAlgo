package Algos.Strings;

import models.Algorithm;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowContainingString extends Algorithm {

    private String smallestWindow(String s, String p) {
        String result = s;
        boolean isWindow = false;
        Map<Character, Integer> charCountMap = new HashMap<>();

        if (s.length() < p.length())
            return "-1";

        // Initiate map with patters chars
        for (int i=0; i<p.length(); i++) {
            charCountMap.put(p.charAt(i), charCountMap.getOrDefault(p.charAt(i), 0) - 1);
        }

        int matchedCharCount = 0;

        // Traverse 1st pattern length characters
        for (int i=0; i<p.length(); i++) {
            // Optimization: Only consider char in P to put in hashmap.
            if (charCountMap.containsKey(s.charAt(i))) {
                if (charCountMap.get(s.charAt(i)) < 0) {
                    matchedCharCount++;
                }

                charCountMap.put(s.charAt(i), charCountMap.get(s.charAt(i)) + 1);
            }
        }

        if (matchedCharCount == p.length())
            return s.substring(0, p.length());

        int start = 0;
        for (int i = p.length(); i < s.length(); i++) {
            if (charCountMap.containsKey(s.charAt(i))) {
                if (charCountMap.get(s.charAt(i)) < 0) {
                    matchedCharCount++;
                }

                charCountMap.put(s.charAt(i), charCountMap.get(s.charAt(i)) + 1);
            }

            // Check for window
            if (matchedCharCount == p.length()) {
                isWindow = true;

                // check to shrink window
                /*
                if (charCountMap.containsKey(s.charAt(start)))
                    charCountMap.put(s.charAt(start), charCountMap.get(s.charAt(start)) - 1);

                start++;
                while (containsAllChar(charCountMap)) {
                    if (charCountMap.containsKey(s.charAt(start)))
                        charCountMap.put(s.charAt(start), charCountMap.get(s.charAt(start)) - 1);

                    start++;
                }
                */

                while (true) {
                    if (charCountMap.containsKey(s.charAt(start))) {
                        charCountMap.put(s.charAt(start), charCountMap.get(s.charAt(start)) - 1);

                        if (charCountMap.get(s.charAt(start)) < 0) {
                            matchedCharCount--;
                            start++;
                            break;
                        }
                    }

                    start++;
                }

                // System.out.println(s.substring(start -1, i+1));
                // System.out.println(charCountMap);
                if (result.length() > i - start + 2)
                    result = s.substring(start -1, i+1); // start -1 is position which include all chars in p. i+1 as end is exclusive
            }
        }

        return isWindow ? result : "-1";
    }

    private String smallestWindow2(String s, String p) {
        if (s.length() < p.length())
            return "-1";

        // Initialize haspMap for p
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i=0;i<p.length(); i++) {
            charCountMap.put(p.charAt(i), charCountMap.getOrDefault(p.charAt(i), 0) + 1);
        }

        // Start looking for smallest window
        int start = 0;
        int matchCount = 0;
        int smallestWindow = 0;
        for (int end = 0; end<s.length(); end++) {
            char c = s.charAt(end);
            if (charCountMap.containsKey(c)) { // If char is in pattern P
                if (charCountMap.get(c) > 0) {
                    matchCount++; // Increment matchCount for +ve match
                }

                charCountMap.put(c, charCountMap.get(c) - 1);
            }

            // Match window found
            if (matchCount == p.length()) {
                // Shrunk window
                while (true) {
                    // Check if char at start is not ignorable.
                    if (charCountMap.containsKey(s.charAt(start))) {
                        charCountMap.put(s.charAt(start), charCountMap.get(s.charAt(start)) + 1);

                        // Check if not extra match. Window cannot shrink further. Update smallest window
                        if (charCountMap.get(s.charAt(start)) > 0) {
                            smallestWindow = Math.min(smallestWindow, end - start + 1);

                            // Set for next window
                            matchCount--;
                            start++;
                            break;
                        }

                    }

                    start++;
                }
            }
        }

        return smallestWindow != 0 ? "smallestWindow" : "-1";
    }

    private boolean containsAllChar(Map<Character, Integer> charCountMap) {
        for (Map.Entry<Character, Integer> entry: charCountMap.entrySet()){
            if (entry.getValue() < 0)
                return false;
        }

        return true;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void run() {
        // System.out.println(smallestWindow("timetopractice", "toc"));
        // System.out.println(smallestWindow("zoomlazapzo", "oza"));

        System.out.println(smallestWindow("amazonwebservice", "aws"));
    }
}
