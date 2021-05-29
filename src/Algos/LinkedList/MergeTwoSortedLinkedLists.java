package Algos.LinkedList;

public class MergeTwoSortedLinkedLists {
    //Function to merge two sorted linked list.
    Node sortedMerge(Node a, Node b) {
        if (a == null)
            return b;

        if (b == null)
            return a;

        Node prev = null, head = a;

        // Merge b into a
        while (b != null && a != null) {
            if (a.data <= b.data) { // move a and prev if a.data is small.
                prev = a;
                a = a.next;
            } else { // Insert b node in a list
                Node temp = b;
                b = b.next;

                temp.next = a;
                if (prev != null) {
                    prev.next = temp;
                } else {
                    head = temp;
                }

                prev = temp;
            }
        }

        // If a is over and b still remaining
        if (a == null) {
            prev.next = b;
        }

        return head;
    }
}
