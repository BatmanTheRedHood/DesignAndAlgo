package Algos.Tree;

import Algos.LeftViewOfBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintLeftViewOfBinaryTree {
    //Function to return list containing elements of left view of binary tree.
    private ArrayList<Integer> leftView(Node root) {
        if (root == null)
            return null;

        ArrayList<Integer> res = new ArrayList<>();
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.add(root);
        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (q1.isEmpty()) { // process q2
                res.add(processQueue(q2, q1));
            } else { // process q1
                res.add(processQueue(q1, q2));
            }
        }

        return res;
    }

    private int processQueue(Queue<Node> q1, Queue<Node> q2) {
        Node minPositionNode = null;
        while (!q1.isEmpty()) {
            Node qNode = q1.remove();

            // Check and set minPositionNode
            if (minPositionNode == null) {
                minPositionNode = qNode;
            }

            // move children to q2
            if (qNode.left != null) {
                q2.add(qNode.left);
            }

            if (qNode.right != null) {
                q2.add(qNode.right);
            }
        }

        return minPositionNode.data;
    }
}


