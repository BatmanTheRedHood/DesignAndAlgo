package Algos.Strings;

import java.util.HashMap;
import java.util.Map;

public class SecondMostRepeatedStringInASequence {

    public String secFrequent(String[] arr, int n) {
        String mostFreq = null, secondMostFreq = null;
        int maxFreq = 0, secMaxFreq = 0;
        Map<String, Integer> wordFreqMap = new HashMap<>();

        for (int i=0; i< n; i++) {
            String word = arr[i];
            int wordCount = wordFreqMap.containsKey(word) ? wordFreqMap.get(word) : 0;
            wordFreqMap.put(word, wordCount + 1);
        }

        for (Map.Entry<String, Integer> entry: wordFreqMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                secondMostFreq = mostFreq;
                secMaxFreq = maxFreq;

                mostFreq = entry.getKey();
                maxFreq = entry.getValue();
            } else if (entry.getValue() > secMaxFreq) {
                secondMostFreq = entry.getKey();
                secMaxFreq = entry.getValue();
            }
        }

        return secondMostFreq;
    }
}
