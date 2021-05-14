package Algos;

import models.BinaryTreeNode;

public class BinarySearchTree<T extends Comparable<T>> {
    // properties:
    private BinaryTreeNode<T> rootNode;

    // methods
    public void add(T key){
        this.rootNode = addR(key, this.rootNode);
    }

    public BinaryTreeNode<T> search(T key) {
        return searchR(key, this.rootNode);
    }

    public void delete(T key){
        if (this.rootNode.value.compareTo(key) == 0) {
            this.rootNode = null;
        }


    }

    public void inOrderTraversal(){
        inOrderTraversalR(this.rootNode);
    }

    private BinaryTreeNode<T> addR(T key, BinaryTreeNode<T> root) {
        if (root == null) {
            return new BinaryTreeNode<T>(key);
        }

        if (key.compareTo(root.value) < 0) {
            root.left = addR(key, root.left);
        } else {
            root.right = addR(key, root.right);
        }

        return root;
    }

    private BinaryTreeNode<T> searchR(T key, BinaryTreeNode<T> root){
        if (root == null || root.value.compareTo(key) == 0) {
            return root;
        }

        if (key.compareTo(root.value) < 0) {
            return searchR(key, root.left);
        }

        return searchR(key, root.right);
    }

    // private BinaryTreeNode<T>

    private void inOrderTraversalR(BinaryTreeNode<T> root){
        if (root != null) {
            inOrderTraversalR(root.left);
            System.out.println(String.format("%s ", root.value));
            inOrderTraversalR(root.right);
        }
    }
}
