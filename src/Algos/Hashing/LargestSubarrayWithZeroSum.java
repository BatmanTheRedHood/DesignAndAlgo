package Algos.Hashing;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithZeroSum {
    int maxLen(int arr[], int n) {
        Map<Integer, Integer> sumMap = new HashMap<>();

        int sum = arr[0];
        int maxLen = 0;
        sumMap.put(sum, 0);

        for (int i=1; i<arr.length; i++) {
            sum += arr[i];

            if (sum == 0)
                maxLen = i + 1;

            if (sumMap.containsKey(sum)) {
                maxLen = Math.max(maxLen, i-sumMap.get(sum));
            } else {
                sumMap.put(sum, i);
            }
        }

        return maxLen;
    }
}
