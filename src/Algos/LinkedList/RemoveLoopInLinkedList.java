package Algos.LinkedList;

/**
 * You are given a linked list of N nodes. Remove the loop from the linked list, if present.
 * Note: X is the position of the node to which the last node is connected to. If it is 0, then there is no loop.
 *
 * Example 1:
 *
 * Input:
 * N = 3
 * value[] = {1,3,4}
 * X = 2
 * Output: 1
 * Explanation: The link list looks like
 * 1 -> 3 -> 4
 *      ^    |
 *      |____|
 * A loop is present. If you remove it
 * successfully, the answer will be 1.
 * â€‹
 * Example 2:
 *
 * Input:
 * N = 4
 * value[] = {1,8,3,4}
 * X = 0
 * Output: 1
 * Explanation: The Linked list does not
 * contains any loop.
 *
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function removeLoop() which takes the head of the linked list as input parameter. Simply remove the loop in the list (if present) without disconnecting any nodes from the list. The driver code will print 1 if your code is correct.
 *
 *
 * Expected time complexity : O(n)
 * Expected auxiliary space : O(1)
 *
 *
 *
 * Constraints:
 * 1 <= N <= 104
 */
public class RemoveLoopInLinkedList {
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        // Check if loop and find node in loop
        if (head == null || head.next == null)
            return;

        Node one = head, two = head;

        while (two != null && two.next != null){
            one = one.next;
            two = two.next.next;

            if (one == two)
                break;
        }

        // No loop exist
        if (one != two)
            return;

        // Loop exists. Now consider head is a LL head and two is head of another LL and they have intersection.
        one = head;
        Node ll2Head = two;
        int ll1Length = 0;

        // LL1 length
        while (one != two) {
            one = one.next;
            ll1Length++;
        }

        // LL2 length
        int ll2Length = 1;
        while (two.next != ll2Head) {
            two = two.next;
            ll2Length++;
        }

        /***
         * This method is also dependent on Floyd’s Cycle detection algorithm.
         * Detect Loop using Floyd’s Cycle detection algorithm and get the pointer to a loop node.
         * Count the number of nodes in loop. Let the count be k.
         * Fix one pointer to the head and another to a kth node from the head.
         * Move both pointers at the same pace, they will meet at loop starting node.
         * Get a pointer to the last node of the loop and make next of it as NULL.
         */
        one = head;
        two = ll2Head;
        for (int i=0; i < ll1Length - ll2Length; i++) {
            one = one.next;
        }

        Node twoPrev = null;
        for (int i=0; i < ll2Length - ll1Length; i++) {
            twoPrev = two;
            two = two.next;
        }

        while (one != two){
            twoPrev = two;

            one = one.next;
            two = two.next;
        }

        twoPrev.next = null;
    }
}
