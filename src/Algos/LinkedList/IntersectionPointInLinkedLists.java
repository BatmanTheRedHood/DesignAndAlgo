package Algos.LinkedList;

/**
 * Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * LinkList1 = 3->6->9->common
 * LinkList2 = 10->common
 * common = 15->30->NULL
 * Output: 15
 * Explanation:
 * Y ShapedLinked List
 * Example 2:
 *
 * Input:
 * Linked List 1 = 4->1->common
 * Linked List 2 = 5->6->1->common
 * common = 8->4->5->NULL
 * Output: 8
 * Explanation:
 *
 * 4              5
 * |              |
 * 1              6
 *  \             /
 *   8   -----  1
 *    |
 *    4
 *    |
 *   5
 *   |
 *   NULL
 * Your Task:
 * You don't need to read input or print anything. The task is to complete the function intersetPoint() which takes the pointer to the head of linklist1(head1) and linklist2(head2) as input parameters and returns data value of a node where two linked lists intersect. If linked list do not merge at any point, then it should return -1.
 * Challenge : Try to solve the problem without using any extra space.
 *
 *
 *
 * Expected Time Complexity: O(N+M)
 * Expected Auxiliary Space: O(1)
 *
 *
 *
 * Constraints:
 * 1 ≤ N + M ≤ 2*105
 * -1000 ≤ value ≤ 1000
 */
public class IntersectionPointInLinkedLists {
    // Function to find intersection point in Y shaped Linked Lists.
    int intersectPoint(Node head1, Node head2)
    {
        int ll1Length = 0, ll2Length = 0;
        Node ll1 = head1, ll2 = head2;

        // Get LL1 length
        while (ll1 != null) {
            ll1Length++;
            ll1 = ll1.next;
        }

        // Get LL2 length
        while (ll2 != null) {
            ll2Length++;
            ll2 = ll2.next;
        }

        ll1 = head1;
        ll2 = head2;

        // Shift their head to equal length
        if (ll1Length > ll2Length) {
            for (int i=1; i <= ll1Length - ll2Length; i++) {
                ll1 = ll1.next;
            }
        } else {
            for (int i=1; i <= ll2Length - ll1Length; i++) {
                ll2 = ll2.next;
            }
        }

        // Now check for equality and keep moving left until LL is over or intersection is found
        while (ll1 != null) {
            // System.out.println(String.format("ll1: %d, ll2: %d", ll1.data, ll2.data));

            if (ll1 == ll2)
                return ll1.data;

            ll1 = ll1.next;
            ll2 = ll2.next;
        }

        return -1;
    }
}
