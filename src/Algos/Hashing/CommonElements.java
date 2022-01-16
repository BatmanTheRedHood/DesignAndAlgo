package Algos.Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CommonElements {
    public ArrayList<Integer> common_element(ArrayList<Integer> v1, ArrayList<Integer> v2) {
        Map<Integer, Integer> numCountMap = new HashMap<>();

        for (int i=0; i<v2.size(); i++) {
            int count = numCountMap.getOrDefault(v2.get(i), 0);
            numCountMap.put(v2.get(i), count+1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (Integer num: v1) {
            int count = numCountMap.getOrDefault(num, 0);
            if (count > 0) {
                result.add(num);
                numCountMap.put(num, count -1);
            }
        }

        Collections.sort(result);
        return result;
    }
}
