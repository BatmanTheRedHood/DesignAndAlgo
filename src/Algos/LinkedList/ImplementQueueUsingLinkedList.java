package Algos.LinkedList;

public class ImplementQueueUsingLinkedList {
    Node front, rear;

    //Function to push an element into the queue. Push using rear node
    void push(int a) {
        Node newNode = new Node(a);
        if (rear == null) {
            front = newNode;
        } else {
            rear.next = newNode;
        }

        rear = newNode;
    }

    //Function to pop front element from the queue. Pop using head node
    int pop() {
        if (front == null) // queue is empty
            return -1;

        Node temp = front;
        if (front == rear) {// only one node
            front = null;
            rear = null;

            return temp.data;
        }

        front = front.next;
        temp.next = null;
        return temp.data;
    }
}
