package Algos.DivideAndConquer;

public class SumOfMiddleElement {
    // Assumption: Array is non-empty
    int findMidSum(int[] ar1, int[] ar2, int n) {
        if (n==1)
            return ar1[0] + ar2[0];

        return findSum(ar1, ar2, 0, n-1, 0, n-1);
    }

    int findSum(int[] arr1, int[] arr2, int s1, int e1, int s2, int e2) {
        while (e1-s1 > 1) {
            int m1 = (e1 + s1)/2;
            int m2 = (s2 + e2)/2;

            int noOfElements = e1 - s1 + 1;
            if (arr1[m1] > arr2[m2]) {
                e1 = m1;
                s2 = m2;
                if (noOfElements % 2 == 0) { // To equal arrays length.
                    e1 += 1;
                }
            } else {
                e2 = m2;
                s1 = m1;
                if (noOfElements % 2 == 0) { // To equal arrays length.
                    e2 += 1;
                }
            }
        }

        return Math.max(arr1[s1], arr2[s2]) + Math.min(arr1[e1], arr2[e2]);
    }
}
