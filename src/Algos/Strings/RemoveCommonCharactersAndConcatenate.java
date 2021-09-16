package Algos.Strings;

public class RemoveCommonCharactersAndConcatenate {
    public String removeCommon(String s1, String s2){
        int[] commonChars = new int[26];

        for (int i=0; i<26; i++){
            commonChars[i] = 0;
        }

        for (int i=0; i<s2.length(); i++) {
            commonChars[s2.charAt(i) - 'a'] = 1;
        }

        String result = "";
        for (int i=0; i<s1.length(); i++) {
            if (commonChars[s1.charAt(i) - 'a'] > 0) {
                commonChars[s1.charAt(i) - 'a'] = 2;
            } else {
                result += s1.charAt(i);
            }
        }

        for (int i=0; i<s2.length(); i++) {
            if (commonChars[s2.charAt(i) - 'a'] != 2)
                result += s2.charAt(i);
        }

        return result.length() > 0 ? result: "-1";
    }
}
