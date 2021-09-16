package Algos.Strings;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentWord {
    private String mfw(String[] arr) {
        int mIndex = 0, max = 0;
        Map<String, Pair> map = new HashMap<>();

        for (int i=0; i<arr.length; i++) {
            String word = arr[i];
            Pair pair;
            if (map.containsKey(word) ) {
                pair = map.get(word);
            } else {
                pair = new Pair(i, 0);
                map.put(word, pair);
            }

            pair.freq++;

            if (pair.freq > max) {
                max = pair.freq;
                mIndex = i;
            } else if (pair.freq == max && pair.firstOccur > map.get(arr[mIndex]).firstOccur) {
                mIndex = i;
            }
        }

        return arr[mIndex];
    }
}

class Pair {
    public int firstOccur;
    public int freq;

    public Pair(int occr, int freq) {
        firstOccur = occr;
        this.freq = freq;
    }
}
