package Algos.Arrays;

import java.util.Arrays;

public class TwoNumberSumClosestToZero {
    // Assumption: Array has atleast 2 elements
    private int closestToZero(int arr[]) {
        Arrays.sort(arr);

        int i = 0, j = arr.length -1;
        int min = arr[0] + arr[1];
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == 0)
                return 0;

            if (Math.abs(min) > Math.abs(sum) ||
                    Math.abs(min) == Math.abs(sum) && sum > min) // To handle maximum sum close to 0
                min = sum;

            if (sum < 0)
                i++;
            else
                j--;
        }

        return min;
    }
}
