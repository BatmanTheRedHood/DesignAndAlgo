package Algos.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {
    //Function to connect nodes at same level.
    private void connect(Node root) {
        if (root == null)
            return;

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.add(root);
        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (q1.isEmpty()) {
                processBFSQueue(q2, q1);
            } else {
                processBFSQueue(q1, q2);
            }
        }
    }

    private void processBFSQueue(Queue<Node> q1, Queue<Node> q2) {
        Node prev = null;
        while (!q1.isEmpty()) {
            Node node = q1.remove();

            // process node
            if (prev != null) {
                prev.nextRight = node;
            }

            prev = node; // shift previous

            // Add child nodes
            if (node.left != null) {
                q2.add(node.left);
            }

            if (node.right != null) {
                q2.add(node.right);
            }
        }
    }
}