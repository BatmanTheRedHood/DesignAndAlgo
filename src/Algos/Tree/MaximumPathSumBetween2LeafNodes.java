package Algos.Tree;

import models.Algorithm;

/**
 * https://practice.geeksforgeeks.org/problems/maximum-path-sum/1#
 */
public class MaximumPathSumBetween2LeafNodes extends Algorithm {
    private int maxPathSum(Node root) {
        // code here
        if (root == null)
            return 0;

        int maxFromLeftTree = maxPathSum(root.left);
        int maxFromRightTree = maxPathSum(root.right);

        return Math.max(root.data + maxFromLeftTree, root.data + maxFromRightTree);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void run() {
        System.out.println("Not working");
    }
}
