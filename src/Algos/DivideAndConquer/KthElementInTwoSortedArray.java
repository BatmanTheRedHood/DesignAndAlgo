package Algos.DivideAndConquer;

public class KthElementInTwoSortedArray {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        if (k > m+n)
            return -1;

        return kth(arr1, arr2, 0, n, 0, m, k);
    }

    int kth(int[] arr1, int[] arr2, int s1, int e1, int s2, int e2, int k) {
        while (e1-s1>1 && e2-s2>1) {
            int m1 = (s1+e1)/2;
            int m2 = (s2+e2)/2;

            if (k > (m1 -s1) + (m2-s2)) { // Discard left elements
                k = k - (m1-s1) - (m2-s2);
                s1 = m1;
                s2 = m2;
            } else { // Discard right elements
                e1 = m1;
                e2 = m2;
            }
        }

        while (e1 >= s1 && e2 >= s2) {

        }
        
        if (k == 1)
            return Math.min(arr1[s1], arr2[s2]);

        if (k == 2)
            return Math.max(arr1[s1], arr2[s2]);

        if (k == 3)
            return Math.min(arr1[e1], arr2[e2]);

        // K = 4
        return Math.max(arr1[e1], arr2[e2]);
    }
}
