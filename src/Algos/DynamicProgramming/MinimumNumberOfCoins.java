package Algos.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumNumberOfCoins {
    List<Integer> minPartition(int n) {
        int[] coins = new int[]{1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };

        List<Integer> result = new ArrayList();
        for (int i=coins.length; i>=0; i--) {
            while (n > 0 && n > coins[i]) {
                n = n - coins[i];
                result.add(coins[i]);
            }
        }

        return result;
    }

    List<Integer> minPartition2(int n) {
        int[] coins = new int[]{1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };

        List<Integer> result = new ArrayList();
        for (int i=coins.length-1; i>=0 && n>0; i--) {
            if (n > 0 && n >= coins[i]) {
                int c = n/coins[i];
                n = n%coins[i];

                Integer[] temp = new Integer[c];
                Arrays.fill(temp, coins[i]);
                result.addAll(Arrays.asList(temp));
            }
        }

        return result;
    }
}
