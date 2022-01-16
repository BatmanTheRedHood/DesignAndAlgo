package Algos.Strings;

import java.util.HashMap;
import java.util.Map;

public class StringIgnorance {
    public static void main (String[] args) {
        //code
        if (args == null || args.length == 0)
            return;

        int t = Integer.parseInt(args[0]);

        for (int i=1; i<= t; i++) {
            String word = args[i];

            String result = "";
            Map<Character, Integer> charCountMap = new HashMap<>();
            for (int k=0; k<word.length(); k++) {
                char c = toLower(word.charAt(k));

                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
                if (charCountMap.get(c) %2 == 0)
                    result += word.charAt(k);
            }

            System.out.println(result);
        }
    }

    private static char toLower(char c) {
        return (char) (c >= 'A' && c <= 'Z'? 'a' + c - 'A' : c);
    }
}
