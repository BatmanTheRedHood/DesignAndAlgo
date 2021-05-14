package Algos;

import models.Algorithm;
import models.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1

Left view of following tree is 1 2 4 8.
          1
       /     \
     2        3
   /     \    /    \
  4     5   6    7
   \
     8


Input:
   1
 /  \
3    2
Output: 1 3
 */
public class LeftViewOfBinaryTree extends Algorithm {
    private BinaryTreeNode<Integer> tree;

    @Override
    protected  void init() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);

        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);

        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);

        root.left.left.right = new BinaryTreeNode(8);

        BinaryTreeNode root2 = new BinaryTreeNode(10);
        root2.left = new BinaryTreeNode(20);
        root2.right = new BinaryTreeNode(30);

        root2.left.left = new BinaryTreeNode(40);
        root2.left.right = new BinaryTreeNode(50);

        //root.right.left = new BinaryTreeNode(6);
        //root.right.right = new BinaryTreeNode(7);

        root2.left.right.right = new BinaryTreeNode(60);

        this.tree = root;
    }

    // BFS
    // put level and rank while pushing to queue
    // Traverse by level... push child if any... maintain min rank per level...
    // print min rank when level ends
    // continue until queue is empty
    @Override
    protected void run() {
        LeftViewTreeNode minRankNode = new LeftViewTreeNode(this.tree, 0, 0);
        Queue<LeftViewTreeNode> queue = new LinkedList<>();
        queue.add(minRankNode);

        while(!queue.isEmpty()){
            LeftViewTreeNode lvNode = queue.remove();

            // Print minNode if next level
            if (lvNode.level > minRankNode.level){
                System.out.println(String.format(" Level %d left most node: %d", minRankNode.level, minRankNode.node.value));

                minRankNode = lvNode;
            } else if (lvNode.rank < minRankNode.rank){
                minRankNode = lvNode;
            }

            System.out.print(lvNode.node.value);
            if (lvNode.node.left != null) {
                queue.add(new LeftViewTreeNode(lvNode.node.left, lvNode.level + 1, lvNode.rank - 1));
            }

            if (lvNode.node.right != null) {
                queue.add(new LeftViewTreeNode(lvNode.node.right, lvNode.level + 1, lvNode.rank + 1));
            }
        }

        System.out.println(String.format(" Level %d left most node: %d", minRankNode.level, minRankNode.node.value));
    }

    private class LeftViewTreeNode{
        public BinaryTreeNode node;
        public int level;
        public int rank;

        public LeftViewTreeNode(BinaryTreeNode node, int l, int r){
            this.node = node;
            this.level = l;
            this.rank = r;
        }
    }
}
