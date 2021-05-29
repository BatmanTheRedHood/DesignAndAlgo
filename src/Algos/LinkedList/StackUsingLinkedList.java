package Algos.LinkedList;

public class StackUsingLinkedList {
    Node top;

    //Function to push an integer into the stack.
    void push(int a) {
        Node newNode = new Node(a);
        newNode.next = top;
        top = newNode;
    }

    //Function to remove an item from top of the stack.
    int pop() {
        if (top == null)
            return -1;

        Node temp = top;
        top = top.next;
        temp.next = null;

        return temp.data;
    }
}
