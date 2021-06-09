package Algos.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Assumption: Tree has positive numbers
public class SerializeDeserializeBinaryTree {
    //Function to serialize a tree and return a list containing nodes of tree.
    public void serialize(Node root, ArrayList<Integer> arr) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node node = q.remove();

            if (node != null) {
                arr.add(node.data);
                q.add(node.left);
                q.add(node.right);
            } else {
                arr.add(-1);
            }
        }
    }

    //Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> arr) {
        Queue<Node> q = new LinkedList<>();

        Node root = getNode(arr.get(0));
        if (root == null)
           return root;

        q.add(root);
        int i = 1;
        while (!q.isEmpty()) {
            Node node = q.remove();

            // If root is not null... arr next 2 elements are child of the root;
            if (node != null) {
                Node left = getNode(arr.get(i));
                Node right = getNode(arr.get(i + 1));

                node.left = left;
                node.right = right;

                q.add(left);
                q.add(right);
                i = i + 2;
            }
        }

        return root;
    }

    private Node getNode(int data) {
        return data >= 0? new Node(data) : null;
    }
}
