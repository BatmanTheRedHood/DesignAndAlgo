package Algos.DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChain {

    int maxChainLength(Pair[] arr, int n) {
        Arrays.sort(arr, Comparator.comparingInt(p -> p.y));
        /*
            Arrays.sort(arr, (p1, p2) -> Integer.compare(p1.b, p2.b));
            Arrays.sort(arr, (p1, p2) -> {
                return Integer.compare(p1.b, p2.b);
            });
         */

        int count = 1;
        int last = arr[0].y;
        for (int i=1; i<arr.length; i++) {
            if (arr[i].x > last) {
                count++;
                last = arr[i].y;
            }
        }

        return count;
    }
}

class Pair{
    int x;
    int y;
}