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
}
