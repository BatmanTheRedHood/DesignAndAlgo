package Algos;

import models.Algorithm;
import models.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/*
https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
Input:
     2
      \
       3
      /
     4
Output: 2 4 3

Input:
       1
    /    \
   2      3
 /   \      \
4     5      6
Output: 4 2 1 5 3 6


Input:
           1
        /    \
       2      3
      / \   /   \
     4   5  6   7
               /  \
              8   9


The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9
 */
public class VerticalTraversalOfBinaryTree extends Algorithm {
    // properties
    private BinaryTreeNode<Integer> tree;

    // methods:
    @Override
    protected void init() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);
        root.right.left.right = new BinaryTreeNode(8);
        root.right.right.right = new BinaryTreeNode(9);

        this.tree = root;
    }

    // BFS
    // Maintain Hashmap Key: Rank, Value is LL
    // Initialize LL if not found.. add to first to LL if found
    @Override
    protected void run() {
        // Initialize Queue for BFS
        Queue<RankedNode> queue = new LinkedList<>();
        queue.add(new RankedNode(this.tree, 0));

        // Initialize Hashmap for Ranked List
        TreeMap<Integer, LinkedList<BinaryTreeNode<Integer>>> treeMap = new TreeMap<>();

        while(!queue.isEmpty()){
            // Remove latest
            RankedNode rankedNode = queue.remove();

            // Do Stuff
            if (treeMap.containsKey(rankedNode.rank)) {
                LinkedList<BinaryTreeNode<Integer>> ll = treeMap.get(rankedNode.rank);
                ll.addLast(rankedNode.node);
            } else {
                LinkedList<BinaryTreeNode<Integer>> ll = new LinkedList<>();
                ll.add(rankedNode.node);
                treeMap.put(rankedNode.rank, ll);
            }

            // Push connected nodes
            if (rankedNode.node.left != null) {
                queue.add(new RankedNode(rankedNode.node.left, rankedNode.rank - 1));
            }

            if (rankedNode.node.right != null) {
                queue.add(new RankedNode(rankedNode.node.right, rankedNode.rank + 1));
            }
        }

        // Traversing a map
        for(Map.Entry<Integer, LinkedList<BinaryTreeNode<Integer>>> e: treeMap.entrySet()){
            LinkedList<BinaryTreeNode<Integer>> ll = e.getValue();

            // Traversing a linked list
            for (BinaryTreeNode node: ll) {
                System.out.print(node.value);
                System.out.print(" ");
            }

            System.out.println();
        }
    }

    private class RankedNode{
        public int rank;
        public BinaryTreeNode<Integer> node;

        public RankedNode(BinaryTreeNode<Integer> n, int r){
            this.rank = r;
            this.node = n;
        }
    }
}
