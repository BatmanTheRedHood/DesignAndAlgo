package Algos.Arrays;

public class SmallestPositiveMissingNumber {
    int missingNumber(int arr[], int size) {
        for (int i=0; i< arr.length; i++) {
            if (arr[i] <= 0)
                arr[i] = arr.length + 1;
        }

        for (int i=0; i< arr.length; i++) {
            int abs = Math.abs(arr[i]);

            // Negate only +ve number. Or say negate to give negative number only
            if (abs >= 1 && abs <= arr.length)
                arr[abs -1] = -Math.abs(arr[abs -1]); // Duplicate handling
        }

        for (int i=0; i<arr.length; i++) {
            if (arr[i] > 0)
                return i+1;
        }

        return arr.length + 1;
    }
}
