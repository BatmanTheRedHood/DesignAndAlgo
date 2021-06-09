package Algos.Tree;

public class HeightOfBinaryTree {
    //Function to find the height of a binary tree.
    int height(Node node) {
        // code here
        return treeHeight(node);
    }

    private int treeHeight(Node root) {
        if (root == null)
            return 0;

        return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }
}
