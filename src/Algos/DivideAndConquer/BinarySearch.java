package Algos.DivideAndConquer;

public class BinarySearch {
    int binarySearch(int arr[], int n, int k){
        int start = 0, end = n-1;

        while (start < end) {
            int mid = (start + end)/2;

            if (arr[mid] == k)
                return mid;

            if (k < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }

        return arr[start] == k? start: -1;
    }
}
