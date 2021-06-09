package Algos.Tree;

public class CheckForBST {
    //Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        return isTreeBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isTreeBST(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.data > max || root.data < min)
            return false;

        return isTreeBST(root.left, min, root.data) && isTreeBST(root.right, root.data, max);
    }
}
