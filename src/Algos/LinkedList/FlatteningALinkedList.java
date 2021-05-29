package Algos.LinkedList;

public class FlatteningALinkedList {
    private Node flatten(Node root)
    {
        if (root == null || root.next == null) {
            return root;
        }

        Node a = root, b = root.next;
        Node c = b.next;

        a.next = null;
        while (b != null) {
            b.next = null;

            a = sortedMergeLL(a, b);

            b = c;

            if (c != null)
                c = c.next;
        }

        return a;
    }

    // Assumption: Both a and b are not null.
    private Node sortedMergeLL(Node a, Node b) {
        Node prev = null, head = a;

        // Merge b into a
        while (b != null && a != null) {
            if (a.data <= b.data) { // move a and prev if a.data is small.
                prev = a;
                a = a.bottom;
            } else { // Insert b node in a list
                Node temp = b;
                b = b.bottom;

                temp.bottom = a;
                if (prev != null) {
                    prev.bottom = temp;
                } else {
                    head = temp;
                }

                prev = temp;
            }
        }

        // If a is over and b still remaining
        if (a == null) {
            prev.bottom = b;
        }

        return head;
    }
}
