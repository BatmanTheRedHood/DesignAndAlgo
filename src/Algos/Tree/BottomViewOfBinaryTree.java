package Algos.Tree;

import java.util.*;

public class BottomViewOfBinaryTree {
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root) {
        if (root == null)
            return null;

        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Node> treeMap = new TreeMap<>(); // To store node sorted based on their rank
        Queue<BottomViewNode> q1 = new LinkedList<>();
        Queue<BottomViewNode> q2 = new LinkedList<>();

        // Level order traversal
        q1.add(new BottomViewNode(root , 0));
        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (q1.isEmpty()) {
                processQueue(q2, q1, treeMap);
            } else {
                processQueue(q1, q2, treeMap);
            }
        }

        for (Map.Entry<Integer, Node> entry: treeMap.entrySet()) {
            res.add(entry.getValue().data);
        }

        return res;
    }

    private void processQueue(Queue<BottomViewNode> q1, Queue<BottomViewNode> q2, Map<Integer, Node> treeMap) {
        while (!q1.isEmpty()) {
            BottomViewNode bottomViewNode = q1.remove();
            treeMap.put(bottomViewNode.rank, bottomViewNode.treeNode);

            if (bottomViewNode.treeNode.left != null) {
                q2.add(new BottomViewNode(bottomViewNode.treeNode.left, bottomViewNode.rank - 1));
            }

            if (bottomViewNode.treeNode.right != null) {
                q2.add(new BottomViewNode(bottomViewNode.treeNode.right, bottomViewNode.rank + 1));
            }
        }
    }
}

class BottomViewNode {
    public Node treeNode;
    public int rank;

    public BottomViewNode(Node node, int r) {
        treeNode = node;
        rank = r;
    }
}
