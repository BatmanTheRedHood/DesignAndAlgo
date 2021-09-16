package Algos.Strings;

public class RepeatedCharacters {
    public char firstRep(String s) {
        int lastRepIndex =  -1;
        int[] charCount = new int[26];

        for (int i=0; i< charCount.length; i++) {
            charCount[i] = 0;
        }

        for (int i=s.length()-1; i>=0; i--) {
            if (charCount[s.charAt(i) - 'a'] > 0) {
                lastRepIndex = i;
            }

            charCount[s.charAt(i) - 'a']++;
        }

        return lastRepIndex == -1? '#' : s.charAt(lastRepIndex);
    }
}
