package Algos.Strings;

import models.Algorithm;
import models.CharacterOccurrence;

import java.util.HashMap;
import java.util.Map;

public class SubstringsWithUniqueCharacter extends Algorithm {

    @Override
    protected void init() {
    }

    @Override
    protected void run() {
        printSubstring("abade");
        printSubstring("abcade");
        printSubstring("abcadea");
        printSubstring("abcbcde");
    }

    private void printSubstring(String str){
        Map<Character, CharacterOccurrence> charMap = getCharOccurrenceMap(str);

        int f, l; // substring;
        for (int i=0; i<str.length();) {
            // Initialize new substring
            CharacterOccurrence currentChar = charMap.get(str.charAt(i));
            f = currentChar.firstOccurrence;
            l = currentChar.lastOccurrence;

            // Check for substring end.
            while (i < l) {
                i++;
                currentChar = charMap.get(str.charAt(i));
                if (l < currentChar.lastOccurrence) {
                    l = currentChar.lastOccurrence;
                }
            }

            // print substring
            if (i == l) {
                System.out.println(str.substring(f, l + 1));
                i++;
            }
        }
    }

    private Map<Character, CharacterOccurrence> getCharOccurrenceMap(String str) {
        Map<Character, CharacterOccurrence> charMap = new HashMap<>();

        for (int i=0; i<str.length(); i++){
            char c = str.charAt(i);

            CharacterOccurrence charOccurrence;
            if (charMap.containsKey(c)) {
                charOccurrence = charMap.get(c);
                charOccurrence.lastOccurrence = i;
            } else {
                charOccurrence = new CharacterOccurrence(c, i);
                charMap.put(c, charOccurrence);
            }
        }

        return charMap;
    }
}
