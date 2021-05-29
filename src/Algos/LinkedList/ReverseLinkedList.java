package Algos.LinkedList;

public class ReverseLinkedList {
    private Node reverseList(Node head) {
        if (head == null || head.next == null)
            return head;

        Node a = head, b = head.next, c = head.next.next;
        a.next = null;

        while(b != null) {
            b.next = a;

            a = b;
            b = c;
            if (c != null)
                c = c.next;
        }

        return a;
    }
}
