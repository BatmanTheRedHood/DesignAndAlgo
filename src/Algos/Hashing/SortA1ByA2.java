package Algos.Hashing;

import java.util.Arrays;

public class SortA1ByA2 {
    // A1[] : the input array-1
    // N : size of the array A1[]
    // A2[] : the input array-2
    // M : size of the array A2[]

    //Function to sort an array according to the other array.
    public int[] sortA1ByA2(int A1[], int N, int A2[], int M) {
        int[] res = new int[N];

        Arrays.sort(A1);

        int prev = -1;
        for (int i=0; i<M; i++) {
            int bSIndex = Arrays.binarySearch(A1, A2[i]);

            // Insert
            if (bSIndex != -1) {

            }
        }
        return null;
    }
}
