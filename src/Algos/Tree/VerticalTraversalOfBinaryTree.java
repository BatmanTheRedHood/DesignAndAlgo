package Algos.Tree;

import java.util.*;

/**
 * TreeMap can be replaced with array with length MaxRank - MinRank
 */
public class VerticalTraversalOfBinaryTree {
    //Function to find the vertical order traversal of Binary Tree.
    private ArrayList<Integer> verticalOrder(Node root) {
        if (root == null)
            return null;

        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, List<Node>> treeMap = new TreeMap<>();
        Queue<VerticalTraversalNode> q1 = new LinkedList<>();
        Queue<VerticalTraversalNode> q2 = new LinkedList<>();

        // Level order traversal
        q1.add(new VerticalTraversalNode(root, 0));
        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (q1.isEmpty()) {
                processBFSQueue(q2, q1, treeMap);
            } else {
                processBFSQueue(q1, q2, treeMap);
            }
        }

        for (Map.Entry<Integer, List<Node>> entry : treeMap.entrySet()) {
            List<Node> nodeList = entry.getValue();
            for (Node node: nodeList) {
                res.add(node.data);
            }
        }

        return res;
    }

    private void processBFSQueue(
            Queue<VerticalTraversalNode> q1,
            Queue<VerticalTraversalNode> q2,
            Map<Integer, List<Node>> treeMap) {
        while (!q1.isEmpty()) {
            VerticalTraversalNode verticalTraversalNode = q1.remove();

            if (treeMap.containsKey(verticalTraversalNode.rank)) {
                treeMap.get(verticalTraversalNode.rank).add(verticalTraversalNode.treeNode);
            } else {
                List<Node> treeNodeList = new ArrayList<>();
                treeNodeList.add(verticalTraversalNode.treeNode);
                treeMap.put(verticalTraversalNode.rank, treeNodeList);
            }

            if (verticalTraversalNode.treeNode.left != null) {
                q2.add(new VerticalTraversalNode(verticalTraversalNode.treeNode.left, verticalTraversalNode.rank -1));
            }

            if (verticalTraversalNode.treeNode.right != null) {
                q2.add(new VerticalTraversalNode(verticalTraversalNode.treeNode.right, verticalTraversalNode.rank +1));
            }
        }
    }
}

class VerticalTraversalNode {
    public int rank;
    public Node treeNode;

    public VerticalTraversalNode(Node node, int r) {
        treeNode = node;
        rank = r;
    }
}
