package Algos.DivideAndConquer;

public class SearchInRotatedArray {
    int search(int arr[], int start, int end, int key) {
        while (start < end) {
            int mid = (start + end)/2;

            if (arr[mid] == key)
                return mid;

            if (arr[start] < arr[mid]) { // Left is strictly increasing
                if (key >= arr[start] && key < arr[mid]) { // key is in left
                    end = mid -1;
                } else { // key is in right
                    start = mid + 1;
                }
            } else { // Right is strictly increasing
                if (key > arr[mid] && key <= arr[end]) { // key is in right
                    start = mid + 1;
                } else { // key is in left
                    end = mid - 1;
                }
            }
        }

        return arr[start] == key? start: -1;
    }
}
