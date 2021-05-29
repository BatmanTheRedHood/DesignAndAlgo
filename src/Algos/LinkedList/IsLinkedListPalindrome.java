package Algos.LinkedList;

public class IsLinkedListPalindrome {
    //Function to check whether the list is palindrome.
    private boolean isPalindrome(Node head)
    {
        if (head == null || head.next == null)
            return true;

        int llLength = 0;
        Node temp = head;
        while (temp != null) {
            llLength++;
            temp = temp.next;
        }

        int mid = (int) llLength % 2 == 0? llLength/2 : (llLength + 1)/2;
        temp = head;
        for (int i=1; i < mid; i++) {
            temp = temp.next;
        }

        Node second = temp.next;
        temp.next = null;

        second = reverseLL(second);

        while (second != null) {
            if (second.data != head.data)
                return false;

            second = second.next;
            head = head.next;
        }

        return true;
    }

    private Node reverseLL(Node head) {
        if (head == null || head.next == null){
            return head;
        }

        Node a= head, b= head.next, c= head.next.next;

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
