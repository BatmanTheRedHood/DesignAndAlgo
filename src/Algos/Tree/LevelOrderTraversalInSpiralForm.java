package Algos.Tree;

import java.util.*;

public class LevelOrderTraversalInSpiralForm {
    //Function to return a list containing the level order traversal in spiral form.
    ArrayList<Integer> findSpiral(Node root) {
        if (root == null) {
            return null;
        }

        ArrayList<Integer> res = new ArrayList<>();
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        Stack<Node> stack = new Stack<>();

        q1.add(root);
        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (q1.isEmpty()) { // Process q2 left to right
                while (!q2.isEmpty()) {
                    Node node = q2.remove();
                    res.add(node.data);

                    if (node.left != null) {
                        q1.add(node.left);
                    }

                    if (node.right != null) {
                        q1.add(node.right);
                    }
                }
            } else {
                while (!q1.isEmpty()) { // process q1 left to right but push node to stack for reverse order
                    Node node = q1.remove();
                    stack.push(node); // Move q1 nodes to stack. Later add to result for reverse order

                    if (node.left != null) {
                        q2.add(node.left);
                    }

                    if (node.right != null) {
                        q2.add(node.right);
                    }
                }

                while (!stack.isEmpty()){
                    res.add(stack.pop().data);
                }
            }
        }

        return res;
    }
}
