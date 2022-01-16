package Algos.Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortA1ByA2 {
    // A1[] : the input array-1
    // N : size of the array A1[]
    // A2[] : the input array-2
    // M : size of the array A2[]

    //Function to sort an array according to the other array.
    public int[] sortA1ByA2(int[] arr1, int N, int[] arr2, int M) {
        Map<Integer, Integer> sortMap = new HashMap<>();

        for (int i=0;i<arr2.length; i++) {
            sortMap.put(arr2[i], 0);
        }

        for (int i=0;i<arr1.length; i++) {
            if (sortMap.containsKey(arr1[i])) {
                int count = sortMap.get(arr1[i]);
                sortMap.put(arr1[i], count + 1);
            }
        }

        int k = arr1.length-1;
        for (int i=arr1.length-1; i>=0;i--) {
            if (!sortMap.containsKey(arr1[i])) {
                arr1[k--] = arr1[i];
            }
        }

        Arrays.sort(arr1, k + 1, arr1.length);

        k = 0;
        for (int i = 0; i < arr2.length; i++) {
            int count = sortMap.get(arr2[i]);
            while (count > 0) {
                arr1[k++] = arr2[i];
                count--;
            }
        }

        return arr1;
    }
}
