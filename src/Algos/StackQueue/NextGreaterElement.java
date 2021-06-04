package Algos.StackQueue;

import models.Algorithm;

import java.util.Arrays;
import java.util.Stack;

/**
 * greater element for current element is -1. For example, next greater of the last element is always -1.
 *
 * Example 1:
 *
 * Input:
 * N = 4, arr[] = [1 3 2 4]
 * Output:
 * 3 4 4 -1
 * Explanation:
 * In the array, the next larger element
 * to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ?
 * since it doesn't exist, it is -1.
 * Example 2:
 *
 * Input:
 * N = 5, arr[] [6 8 0 1 3]
 * Output:
 * 8 -1 1 3 -1
 * Explanation:
 * In the array, the next larger element to
 * 6 is 8, for 8 there is no larger elements
 * hence it is -1, for 0 it is 1 , for 1 it
 * is 3 and then for 3 there is no larger
 * element on right and hence -1.
 * Your Task:
 * This is a function problem. You only need to complete the function nextLargerElement() that takes list of integers arr[ ] and N as input parameters and returns list of integers of length N denoting the next greater elements for all the corresponding elements in the input array.
 *
 * Expected Time Complexity : O(N)
 * Expected Auxilliary Space : O(N)
 *
 * Constraints:
 * 1 ≤ N ≤ 106
 * 1 ≤ Ai ≤ 1018
 */
public class NextGreaterElement extends Algorithm {

    @Override
    protected void init() {

    }

    @Override
    protected void run() {
        long[] res = nextLargerElement(new long[]{1, 3, 2, 4});
        System.out.println(res[0]);
    }

    //Function to find the next greater element for each element of the array.
    private long[] nextLargerElement(long[] arr)
    {
        long[] result = new long[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i=1; i<arr.length; i++) {
            // If next element is greater
            if (arr[i-1] < arr[i]) {
                result[i-1] = arr[i];

                // Check for elements in stack
                while (!stack.isEmpty()) {
                    int ele = stack.pop();

                    if (arr[ele] < arr[i]) {
                        result[ele] = arr[i];
                    } else {
                        stack.push(ele);
                        break;
                    }
                }
            } else {
                stack.push(i-1);
            }
        }

        // For all element in stack, put -1 as no bigger element found
        while (!stack.isEmpty()){
            result[stack.pop()] = -1;
        }

        // same for last arr element
        result[result.length - 1] = -1;

        return result;
    }
}
