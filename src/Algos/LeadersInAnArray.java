package Algos;

import models.Algorithm;

import java.util.ArrayList;
import java.util.List;

/***
 * Given an array A of positive integers. Your task is to find the leaders in the array. An element of array is leader if it is greater than or equal to all the elements to its right side. The rightmost element is always a leader.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * n = 6
 * A[] = {16,17,4,3,5,2}
 * Output: 17 5 2
 * Explanation: The first leader is 17
 * as it is greater than all the elements
 * to its right.  Similarly, the next
 * leader is 5. The right most element
 * is always a leader so it is also
 * included.
 *
 *
 * Example 2:
 *
 * Input:
 * n = 5
 * A[] = {1,2,3,4,0}
 * Output: 4 0
 *
 *
 * Your Task:
 * You don't need to read input or print anything. The task is to complete the function leader() which takes array A and n as input parameters and returns an array of leaders in order of their appearance.
 *
 *
 *
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(n)
 *
 *
 *
 * Constraints:
 * 1 <= n <= 107
 * 0 <= Ai <= 107
 */
public class LeadersInAnArray extends Algorithm {
    private Integer[] arr;

    @Override
    protected void init() {

    }

    @Override
    protected void run() {

    }

    private List<Integer> findLeaders(){
        List<Integer> leaders = new ArrayList<>();

        int max = 0;
        for(int i=arr.length -1; i>=0; i--){
            if (arr[i] >= max){
                leaders.add(arr[i]);
                max = arr[i];
            }
        }

        reverseList(leaders);

        return leaders;
    }

    private <T> void reverseList(List<T> list) {
        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            swap(list, start, end);
            start++;
            end--;
        }
    }

    private <T> void swap(List<T> list, int a, int b) {
        T temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
}
