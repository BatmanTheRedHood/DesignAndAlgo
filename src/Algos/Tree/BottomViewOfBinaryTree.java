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

    public ArrayList<Integer> bottomViewBFS2(Node root) {
        if (root == null)
            return null;

        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Node> treeMap = new TreeMap<>();
        Queue<BottomViewNode> queue = new LinkedList<>();

        queue.add(new BottomViewNode(root, 0));
        while (!queue.isEmpty()) {
            int levelNodeCount = queue.size(); // Used to process nodes at a level

            for (int i=0; i<levelNodeCount; i++) {
                BottomViewNode currentNode = queue.remove();
                treeMap.put(currentNode.distance, currentNode.treeNode);

                if (currentNode.treeNode.left != null)
                    queue.add(new BottomViewNode(currentNode.treeNode.left, currentNode.distance -1));

                if (currentNode.treeNode.right != null)
                    queue.add(new BottomViewNode(currentNode.treeNode.right, currentNode.distance + 1));
            }
        }

        for (Map.Entry<Integer, Node> entry: treeMap.entrySet()) {
            result.add(entry.getValue().data);
        }

        return result;
    }

    public ArrayList<Integer> bottomViewDFS(Node root) {
        Map<Integer, BottomViewNode> treeMap = new TreeMap<>();
        bottomViewDFSProcess(root, 0, 0, treeMap);

        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, BottomViewNode> entry: treeMap.entrySet()) {
            list.add(entry.getValue().treeNode.data);
        }

        return list;
    }

    private void bottomViewDFSProcess(Node root, int distance, int level, Map<Integer, BottomViewNode> treeMap) {
        if (root == null)
            return;

        if (treeMap.containsKey(distance)) {
            BottomViewNode prevNode = treeMap.get(distance);
            if (prevNode.distance <= level)
                treeMap.put(distance, new BottomViewNode(root, level));
        } else {
            treeMap.put(distance, new BottomViewNode(root, level));
        }

        bottomViewDFSProcess(root.left, distance-1, level + 1, treeMap);
        bottomViewDFSProcess(root.right, distance+1, level+1, treeMap);
    }

    private void processQueue(Queue<BottomViewNode> q1, Queue<BottomViewNode> q2, Map<Integer, Node> treeMap) {
        while (!q1.isEmpty()) {
            BottomViewNode bottomViewNode = q1.remove();
            treeMap.put(bottomViewNode.distance, bottomViewNode.treeNode);

            if (bottomViewNode.treeNode.left != null) {
                q2.add(new BottomViewNode(bottomViewNode.treeNode.left, bottomViewNode.distance - 1));
            }

            if (bottomViewNode.treeNode.right != null) {
                q2.add(new BottomViewNode(bottomViewNode.treeNode.right, bottomViewNode.distance + 1));
            }
        }
    }
}

class BottomViewNode {
    public Node treeNode;
    public int distance;

    public BottomViewNode(Node node, int d) {
        treeNode = node;
        distance = d;
    }
}
