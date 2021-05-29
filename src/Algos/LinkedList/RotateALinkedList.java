package Algos.LinkedList;

public class RotateALinkedList {
    //Function to rotate a linked list.
    // Assumption: K <= length of LL
    public Node rotate(Node head, int k) {
        Node ll1s = head, ll1e = head;
        Node ll2s, ll2e;

        for (int i=1; i<k; i++) {
            ll1e = ll1e.next;
        }

        // K == LL length
        if (ll1e.next == null)
            return head;

        // Find 2nd LL start end;
        ll2s = ll1e.next;
        ll2e = ll2s;
        while (ll2e.next != null) {
            ll2e = ll2e.next;
        }

        // link them
        ll1e.next = null;
        ll2e.next = ll1s;

        return ll2s;
    }
}
