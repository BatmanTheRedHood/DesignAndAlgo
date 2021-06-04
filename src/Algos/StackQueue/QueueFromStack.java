package Algos.StackQueue;

import java.util.Stack;

public class QueueFromStack {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    //Function to push an element in queue by using 2 stacks.
    void Push(int x) {
        s1.push(x);
    }


    //Function to pop an element from queue by using 2 stacks.
    int Pop() {
        // Move all item from S1 to S2.
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // Pop top item which was first pushed
        int popItem = s2.pop();

        // Move remaining items back to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return popItem;
    }
}
