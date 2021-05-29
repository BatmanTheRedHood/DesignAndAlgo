package Algos.Strings;

import models.Algorithm;

public class Anagram extends Algorithm {

    @Override
    protected void init() {

    }

    @Override
    protected void run() {
        System.out.println(isAnagram("geeksforgeeks", "forgeeksgeeks"));
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
}
