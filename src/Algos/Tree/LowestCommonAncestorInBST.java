package Algos.Tree;

public class LowestCommonAncestorInBST {
    //Function to find the lowest common ancestor in a BST.
    private Node lca(Node root, int n1, int n2) {
        if (root.data > n1 && root.data > n2) { // Check in left tree
            return lca(root.left, n1, n2);
        } else if (root.data < n1 && root.data < n2) { // check in right tree
            return lca(root.right, n1, n2);
        }

        return root;
    }
}
