package Algos.Tree;

public class CheckHeightBalancedTree {
    //Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root) {
        if (root == null)
            return true;

        return heightTreeWithBalanceCheck(root) > 0;
    }

    int heightTreeWithBalanceCheck(Node root) {
        if (root == null)
            return 0;

        int leftTreeHeight = heightTree(root.left);
        int rightTreeHeight = heightTree(root.right);

        // Do not process further and return -1 is any child subtree is imbalanced.
        if (leftTreeHeight < 0 || rightTreeHeight < 0)
            return -1;

        // Return -1 to indicate imbalanced tree
        if (Math.abs(leftTreeHeight - rightTreeHeight) > 1)
            return -1;

        return 1 + Math.max(leftTreeHeight, rightTreeHeight);
    }

    int heightTree(Node root) {
        if (root == null)
            return 0;

        int leftTreeHeight = heightTree(root.left);
        int rightTreeHeight = heightTree(root.right);

        return 1 + Math.max(leftTreeHeight, rightTreeHeight);
    }
}
