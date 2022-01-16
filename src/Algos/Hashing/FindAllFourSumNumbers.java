package Algos.Hashing;

import java.util.ArrayList;
import java.util.Arrays;

public class FindAllFourSumNumbers {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                int start = j+1;
                int end = arr.length -1;

                while (start < end) {
                    int sum = arr[i] + arr[j] + arr[start] + arr[end];
                    if (sum == k && (result.size() == 0 || (result.size()>0 && (arr[i] != result.get(result.size() -1).get(0)
                                    || arr[j] != result.get(result.size() -1).get(1)
                                    || arr[start] != result.get(result.size() -1).get(2)
                                    || arr[end] != result.get(result.size() -1).get(3))))) {
                        ArrayList<Integer> found = new ArrayList<>();
                        found.add(arr[i]);
                        found.add(arr[j]);
                        found.add(arr[start]);
                        found.add(arr[end]);

                        result.add(found);
                    }

                    if (sum > k)
                        end--;
                    else
                        start++;
                }
            }
        }

        return result;
    }
}
