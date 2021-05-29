package Algos.LinkedList;

public class AddTwoNumbersRepresentedByLinkedLists {
    //Function to add two numbers represented by linked list.
    private Node addTwoLists(Node first, Node second){
        if (first == null)
            return second;

        if (second == null)
            return first;

        Node head = null;
        first = reverseLL(first);
        second = reverseLL(second);

        int sum = 0, remainder = 0;
        while (first != null || second != null) {
            int a = 0;
            if (first != null) {
                a = first.data;
                first = first.next;
            }

            int b = 0;
            if (second != null) {
                b = second.data;
                second = second.next;
            }

            sum = a + b + remainder;
            remainder = sum >= 10 ? 1:0;

            Node newNode = new Node(sum%10);
            newNode.next = head;
            head = newNode;
        }

        if (remainder > 0) {
            Node newNode = new Node(remainder);
            newNode.next = head;
            head = newNode;
        }

        return head;
    }

    private Node reverseLL(Node head){
        if (head == null || head.next == null)
            return head;

        Node a = head, b= head.next, c = head.next.next;

        a.next = null;
        while (b != null) {
            b.next = a;

            a = b;
            b = c;

            if (c != null)
                c = c.next;
        }

        return a;
    }
}
