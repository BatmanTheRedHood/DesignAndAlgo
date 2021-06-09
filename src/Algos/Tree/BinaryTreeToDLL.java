package Algos.Tree;

import java.util.Stack;

public class BinaryTreeToDLL {
    private static Node prev;
    private static Node head;

    public void run() {
        treeToDLLWithoutRecursion(new Node(10));
    }

    //Function to convert binary tree to doubly linked list and return it.
    private Node bToDLL(Node root) {
        prev = null;
        head = null;
        treeToDLL(root);

        return head;
    }

    private void treeToDLL(Node root) {
        if (root.left != null) {
            treeToDLL(root.left);
        }

        if (prev != null) {
            prev.right = root;
            root.left = prev;
        } else {
            head = root;
        }

        prev = root;

        if (root.right != null) {
            treeToDLL(root.right);
        }
    }

    private Node treeToDLLWithoutRecursion(Node root) {
        if (root == null)
            return root;

        Node prev = null, head = null;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            while (root.left != null) {
                stack.push(root);
                root = root.left;
            }

            // Got leftmost node in root;
            if (prev == null) {
                head = root;
            } else {
                prev.right = root;
                root.left = prev;
            }

            prev = root;

            if (root.right != null)
                stack.push(root.right);
        }

        return head;
    }
}
