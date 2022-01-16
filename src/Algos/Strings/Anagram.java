package Algos.Strings;

import models.Algorithm;

import java.util.HashMap;
import java.util.Map;

public class Anagram extends Algorithm {

    @Override
    protected void init() {

    }

    @Override
    protected void run() {
        System.out.println(isAnagram2("geeksforgeeks", "forgeeksgeeks"));
    }

    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a,String b)
    {
        if (a.length() != b.length()) {
            return false;
        }

        int[] charCount = new int[26];
        for (int i=0; i<charCount.length; i++){
            charCount[i] = 0;
        }

        for (int i=0; i<a.length(); i++){
            charCount[a.charAt(i) - 'a']++;
            charCount[b.charAt(i) - 'a']--;
        }

        for (int i=0; i<charCount.length; i++){
            if (charCount[i] != 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isAnagram2(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<a.length();i++) {
            map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
            map.put(b.charAt(i), map.getOrDefault(b.charAt(i), 0) - 1);
        }

        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (entry.getValue() != 0)
                return false;
        }

        return true;
    }
}
