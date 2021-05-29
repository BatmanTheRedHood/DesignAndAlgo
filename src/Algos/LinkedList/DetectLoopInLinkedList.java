package Algos.LinkedList;

public class DetectLoopInLinkedList {
    //Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head){
        if (head == null || head.next == null)
            return false;

        Node one = head, two = head;

        while (two != null && two.next != null) {
            one = one.next;
            two = two.next.next;

            if (one == two || one.next == two)
                return true;
        }

        return false;
    }
}
