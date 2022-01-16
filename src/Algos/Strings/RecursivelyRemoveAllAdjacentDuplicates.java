package Algos.Strings;

import models.Algorithm;

import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates0744/1
public class RecursivelyRemoveAllAdjacentDuplicates extends Algorithm {
    @Override
    protected void init() {

    }

    @Override
    protected void run() {
        // System.out.println("RecursivelyRemoveAllAdjacentDuplicates Not working!");
        System.out.println(removeRec("abccbccba"));
    }

    private String remove(String s) {
        String word = "";
        int i = 0;
        while (i+1 < s.length()) {
            if (s.charAt(i) == s.charAt(i+1)) {
                i = nextIndex(s, i);
            } else {
                word += s.charAt(i);
                i++;
            }
        }

        if (i+1 == s.length()) {
            word += s.charAt(i);
        }

        return word.length() == s.length() ? word : remove(word);
    }

    private String remove2(String s) {
        if (s == null)
            return s;

        for (int i=0; i<s.length();) {
            int j=i;

            while (j+1 < s.length() && s.charAt(i) == s.charAt(j+1))
                j++;

            if (j > i) { // Duplicate found
                // TO STORE PREV and Remove from prev last... STACK fits best
                String prev = s.substring(0, i); // i exclusive.

                String remaining = "";
                if (j+1 < s.length()) // Duplicates from i till j
                    remaining = s.substring(j + 1); // j exclusive

                s = prev + remaining; // new string without dupes found so far
                i = prev.length() > 0? i-1 : i; // for recursive dupe check
            } else { // no dupes found, check for next
                i++;
            }
        }

        return s;
    }

    private String remove3(String s) {
        if (s == null || s == "")
            return s;

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i<s.length();) {
            if (stack.peek() == s.charAt(i)) { // case:  next char match stack top
                char top = stack.pop();
                while (i < s.length() && s.charAt(i) == top) { // move i to next until duplicate found
                    i++;
                }
            } else { // next char didn't match stack top. Push and move to next
                stack.push(s.charAt(i));
                i++;
            }
        }

        // Stack will have all unique chars
        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }

        return result;
    }

    private String removeRec(String s) {
        String prev = "";
        boolean dupFound = false;
        for (int i = 0; i<s.length();) {
            int j = i;
            // If duplicate
            while (j+1 < s.length() && s.charAt(i) == s.charAt(j+1)) {
                dupFound = true;
                j++;
            }

            if (j > i) { // means i to j are all dup... ignore all...move i to j+1
                i = j + 1;
            } else { // no adjacent dup. Add charAt(i) in prev and move i. Reset dupFound
                prev += s.charAt(i);
                i++;
            }
        }

        if (dupFound)
            return removeRec(prev);

        return prev;
    }

    private int nextIndex(String str, int dupIndex) {
        int i = dupIndex;
        while (i < str.length() && str.charAt(i) == str.charAt(dupIndex)) {
            i++;
        }

        return i;
    }
}
