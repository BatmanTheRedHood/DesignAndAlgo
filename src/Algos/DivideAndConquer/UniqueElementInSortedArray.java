package Algos.DivideAndConquer;

/*
https://practice.geeksforgeeks.org/problems/find-the-element-that-appears-once-in-sorted-array0624/1
Find the element that appears once in sorted array
Basic Accuracy: 60.97% Submissions: 8966 Points: 1
Given a sorted array arr[] of size N. Find the element that appears only once in the array. All other elements appear exactly twice.

Example 1:

Input:
N = 11
arr[] = {1, 1, 2, 2, 3, 3, 4, 50, 50, 65, 65}
Output: 4
Explanation: 4 is the only element that
appears exactly once.
 */
public class UniqueElementInSortedArray {

    // Based on question there will always be odd number of element.
    int findOnce(int arr[], int n) {
        int start = 0, end=n-1;

        while (start < end) {
            int mid = (start + end)/2;

            // Mid is even
            if (mid%2 == 0) {
                if (arr[mid] == arr[mid + 1]) { // look into right
                    start = mid + 2;
                } else { // mid can be unique. look into left mid inclusive
                    end = mid;
                }
            } else {
                if (arr[mid] == arr[mid - 1]) { // look into right. mid exclusive
                    start = mid + 1;
                } else { // look into left . mid inclusive
                    end = mid - 1;
                }
            }
        }

        return arr[start];
    }
}
