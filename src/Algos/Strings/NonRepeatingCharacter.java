package Algos.Strings;

public class NonRepeatingCharacter {
    public char firstNonRepeatChar(String s) {
        int[] charArr = new int[26];

        for (int i=0; i<charArr.length; i++) {
            charArr[i] = 0;
        }

        for (int i=0; i<s.length(); i++) {
            charArr[s.charAt(i) - 'a']++;
        }

        for (int i=0; i<s.length(); i++) {
            if (charArr[s.charAt(i) - 'a'] == 1)
                return s.charAt(i);
        }

        return '$';
    }
}

