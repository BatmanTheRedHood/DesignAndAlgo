package Algos.Tree;

public class LongestConsecutiveSequenceInBinaryTree {
    private static int maxLen = 0;

    private int longSeq(Node root, Node parent) {
        if (root == null)
            return 0;

        // Max from left and right child
        int max = Math.max(longSeq(root.left, root), longSeq(root.right, root));

        // Return max from left and right child
        if (parent == null)
            return max;

         if (parent.data + 1 == root.data)
             return 1 + max;

         if (maxLen < max)
             maxLen = max;

         return 0;
    }
}
