package Algos.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSOfGraph {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[V];

        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            res.add(node);

            for(Integer adjacent: adj.get(node)) {
                if (!visited[adjacent]) {
                    visited[adjacent] = true;
                    queue.add(adjacent);
                }
            }
        }

        return res;
    }
}
