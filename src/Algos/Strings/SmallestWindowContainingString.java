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
            int count = charCountMap.containsKey(p.charAt(i)) ? charCountMap.get(p.charAt(i)) : 0;
            charCountMap.put(p.charAt(i), count - 1);
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
        System.out.println(smallestWindow("zoomlazapzo", "oza"));
    }
}
