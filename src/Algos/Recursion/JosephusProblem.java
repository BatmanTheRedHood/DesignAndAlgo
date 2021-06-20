package Algos.Recursion;

import java.util.LinkedList;

public class JosephusProblem {
    public void notWorking() {
        System.out.println("Time complexity is O(n*n) expected is O(n) ") ;
    }

    private int josephus(int n, int k) {
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = i + 1;
        }

        return last(arr, n, k);
    }

    private int last(int[] arr, int n, int k) {
        int startIndex = 0;
        while (n != 1) {
            // Get kth element
            startIndex = (startIndex + (k - 1)) % n;

            // Swap k to move to nth position
            int item = arr[startIndex];
            for (int i=startIndex + 1; i< n; i++){
                arr[i - 1] = arr[i];
            }

            arr[n-1] = item;

            // reduce arr size
            n--;
        }

        return arr[0];
    }
}
