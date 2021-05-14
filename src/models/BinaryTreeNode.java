package models;

public class BinaryTreeNode<T extends Comparable<T>> {
    public T value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(T val){
        this.value = val;
    }
}
