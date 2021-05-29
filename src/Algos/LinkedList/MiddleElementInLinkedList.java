package Algos.LinkedList;

import models.Algorithm;

public class MiddleElementInLinkedList extends Algorithm {
    @Override
    protected void init() {

    }

    @Override
    protected void run() {

    }

    // Assumption head is not NULL
    private int findMiddle(Node head){
        Node first = head, second = head;

        while (second != null) {
            if (second.next ==null) {
                return first.data;
            } else {
                first = first.next;
                second = second.next.next;
            }
        }

        return first.data;
    }
}
