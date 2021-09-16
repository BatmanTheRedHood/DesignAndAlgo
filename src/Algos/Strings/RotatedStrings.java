package Algos.Strings;

public class RotatedStrings {
    boolean areRotations(String s1,String s2) {
        // Your code here
        if (s1.length() != s2.length())
            return false;

        s1 += s1;

        for (int i=0; i<= s1.length() - s2.length(); i++) {
            if (s1.charAt(i) == s2.charAt(0) && compareStrings(s2, s1, i))
                return true;
        }

        return false;
    }

    private boolean compareStrings(String s2, String s1, int k) {
        for (int i=1; i<s2.length(); i++) {
            if (s2.charAt(i) != s1.charAt(k + i))
                return false;
        }

        return true;
    }
}
