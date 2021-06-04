package Algos.StackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackFromQueues {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    //Function to push an element into stack using two queues.
    void push(int a)
    {
        q1.add(a);
    }

    //Function to pop an element from stack using two queues.
    int pop() {
        if (q1.isEmpty())
            return -1;

        // Move all element from q1 to q2 except last
        while (true) {
            int last = q1.remove();

            if (q1.isEmpty()) {
                // add back all to q1 from q2
                while (!q2.isEmpty())
                    q1.add(q2.remove());

                return last;
            } else {
                q2.add(last);
            }
        }
    }
}
