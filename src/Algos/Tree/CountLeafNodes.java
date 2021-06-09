package Algos.Tree;

public class CountLeafNodes {
    int countLeaves(Node node) {
        if (node == null)
            return 0;

        // Leaf node
        if (node.left == null && node.right == null)
            return 1;

        return countLeaves(node.left) + countLeaves(node.right);
    }
}
