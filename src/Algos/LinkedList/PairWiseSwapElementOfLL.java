package Algos.LinkedList;

public class PairWiseSwapElementOfLL {
    private Node pairwiseSwap(Node head)
    {
        if (head == null || head.next == null)
            return head;

        Node newHead = null, swappedPairHead, swappedPairTail = null, prevSwappedPairTail;

        // Initialize
        while (head != null) {
            prevSwappedPairTail = swappedPairTail;
            swappedPairTail = head;

            // Swap pair
            Node[] swapPairResult = swapPair(head);
            swappedPairHead = swapPairResult[0];
            head = swapPairResult[1];

            // Prev swap pair point to start of new swapped pair
            if (prevSwappedPairTail != null) prevSwappedPairTail.next = swappedPairHead;

            // Set new head
            if (newHead == null) newHead = swappedPairHead;
        }

        return newHead;
    }

    // Return head of swapped pair and remaining LL
    private Node[] swapPair(Node head) {
        if (head == null || head.next == null)
            return new Node[]{head, null};

        Node a = head, b = head.next, c = head.next.next;
        b.next = a;
        a.next = null;

        return new Node[]{ b, c};
    }
}
