package Algos;

import java.util.Comparator;

public class BinarySearch {
    public static <T> int search(
            T[] arr, T key, int startIndex, int endIndex, Comparator<? super T> c){
        while (startIndex <= endIndex) {
            int mid = (int) ((startIndex + endIndex) % 2 == 0? (startIndex + endIndex)/2 : (startIndex + endIndex - 1)/2);

            int compareResult = c.compare(key, arr[mid]);
            if (compareResult == 0) {
                return mid;
            }

            if (compareResult < 0) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }

        return -1;
    }

    public static <T> int searchGreaterOrEqual(T[] arr, T key, int start, int end, Comparator<? super T> c) {
        int mid, compareResult;

        while (start < end) {
            mid = (end + start) % 2 == 0? (end + start)/2 : (end + start -1)/2;

            compareResult = c.compare(arr[mid], key);
            if (compareResult == 0) {
                return mid;
            }

            if (compareResult < 0) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        // Handle start == end.  start > end? Mid is left biased, so mid will be start and mid + 1 = end. So start > end should never happen.
        return c.compare(arr[end], key) >= 0? end : -1;
    }

    public static <T> int searchGreater(T[] arr, T key, int start, int end, Comparator<? super T> c){
        int mid, compareResult;

        while (start < end) {
            mid = (end + start)%2 == 0? (end + start)/2 : (end + start - 1)/2; // Left biased mid

            compareResult = c.compare(arr[mid], key);

            if (compareResult <= 0) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        // Start == end
        return c.compare(arr[end], key) > 0? end : -1;
    }
}
