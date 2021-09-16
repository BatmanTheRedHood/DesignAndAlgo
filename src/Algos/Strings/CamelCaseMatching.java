package Algos.Strings;

import java.util.ArrayList;
import java.util.List;

public class CamelCaseMatching {
    private List<String> camelCase(String[] dic, String pattern) {
        List<String> res = new ArrayList<>();

        for (int i=0; i<dic.length; i++) {
            String word = dic[i];
            int counter = 0;

            for (int j=0; j<word.length(); j++) {
                char c = word.charAt(j);
                if (c >= 'A' && c<= 'Z') {
                    // Break if pattern char didn't match
                    if (c != pattern.charAt(counter))
                        break;

                    counter++;
                    // Pattern full match
                    if (counter >= pattern.length()) {
                        res.add(word);
                        break;
                    }
                }
            }
        }

        return res;
    }
}
