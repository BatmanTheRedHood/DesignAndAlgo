package Algos.Arrays;

public class MaximumIndex {
    private int maxIndexDiff(int arr[], int n) {
        int max = 0;
        for (int i=0; i<arr.length && arr.length -i > max; i++) {
            for (int j= arr.length - 1; j > i && j-i > max; j--) {
                if (arr[i] < arr[j])
                    max = j - i;
            }
        }

        return max;
    }
}
