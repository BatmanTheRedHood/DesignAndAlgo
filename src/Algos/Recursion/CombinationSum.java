package Algos.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/combination-sum-part-21208
public class CombinationSum {
    public void notWorking() {
        System.out.println("CombinationSum NOT Working. Duplicate handling problem");
    }

    List<List<Integer>> combinationSum(int A[], int N, int B) {
        // code here
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(A);
        cSum(A, 0, B, 0, new int[A.length], res);

        return res;
    }

    // Assumption: Sum > 0
    private void cSum(int[] arr, int i, int sum, int currSum, int[] boolArr, List<List<Integer>> res) {
        // Base conditions
        if (currSum == sum) {
            res.add(getCombination(arr, boolArr, i));
            return;
        }

        if (currSum > sum || i >= arr.length) {
            return;
        }

        // not taken
        boolArr[i] = 0;
        cSum(arr, i+1, sum, currSum, boolArr, res);

        // taken
        boolArr[i] = 1;
        currSum +=arr[i];
        cSum(arr, i+1, sum, currSum, boolArr, res);
    }

    private List<Integer> getCombination(int[] arr, int[] boolarr, int k) {
        List<Integer> res = new ArrayList<>();
        for (int i=0; i < k; i++) {
            if (boolarr[i] == 1)
                res.add(arr[i]);
        }

        return res;
    }
}
