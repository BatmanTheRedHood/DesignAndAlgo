package Algos.LinkedList;

import models.Algorithm;

/**
 * Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list.
 *
 * Example 1:
 *
 * Input:
 * LinkedList: 1->2->2->4->5->6->7->8
 * K = 4
 * Output: 4 2 2 1 8 7 6 5
 * Explanation:
 * The first 4 elements 1,2,2,4 are reversed first
 * and then the next 4 elements 5,6,7,8. Hence, the
 * resultant linked list is 4->2->2->1->8->7->6->5.
 * Example 2:
 *
 * Input:
 * LinkedList: 1->2->3->4->5
 * K = 3
 * Output: 3 2 1 5 4
 * Explanation:
 * The first 3 elements are 1,2,3 are reversed
 * first and then elements 4,5 are reversed.Hence,
 * the resultant linked list is 3->2->1->5->4.
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function reverse() which should reverse the linked list in group of size k and return the head of the modified linked list.
 *
 * Expected Time Complexity : O(N)
 * Expected Auxilliary Space : O(1)
 *
 * Constraints:
 * 1 <= N <= 104
 * 1 <= k <= N
 */
public class ReverseALinkedListInGroups extends Algorithm {
    @Override
    protected void init() {

    }

    @Override
    protected void run() {

    }

    public Node reverse(Node node, int k)
    {
        if (node == null || node.next == null || k == 1)
            return node;

        Node reversedLLStart = null, reversedLLEnd, remainingLLStart = node;
        Node prevReversedLLEnd = null, newHead = null;

        // Reversal is possible until b is null
        while (remainingLLStart != null) {
            // Start is end of next reversedLL
            reversedLLEnd = remainingLLStart;

            Node[] reverseRes = reverseKNodes(remainingLLStart, k);

            reversedLLStart = reverseRes[0];
            remainingLLStart = reverseRes[1];

            if (prevReversedLLEnd != null)
                prevReversedLLEnd.next = reversedLLStart;
            prevReversedLLEnd = reversedLLEnd;

            if (newHead == null)
                newHead = reversedLLStart;
        }

        return newHead;
    }

    // Return reversed LL head and remaining LL head
    private Node[] reverseKNodes(Node head, int k) {
        if (head == null || head.next == null || k == 1)
            return new Node[] {head, null};

        Node a = head,  b = head.next, c = head.next.next;

        a.next =null;
        for (int i=1; i<k && b!=null; i++) {
            b.next = a;

            a = b;
            b = c;

            if (c != null)
                c = c.next;
        }

        return new Node[] { a, b};
    }



}

