package Algos.Strings;

import models.Algorithm;

public class RecursivelyRemoveAllAdjacentDuplicates extends Algorithm {
    @Override
    protected void init() {

    }

    @Override
    protected void run() {
        System.out.println("Not working!");
        System.out.println(remove("Given a string s, remove all its adjacent duplicate characters recursively. abccba"));
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

    private int nextIndex(String str, int dupIndex) {
        int i = dupIndex;
        while (i < str.length() && str.charAt(i) == str.charAt(dupIndex)) {
            i++;
        }

        return i;
    }
}
