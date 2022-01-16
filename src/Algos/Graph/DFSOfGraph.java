package Algos.Graph;

import java.util.*;

public class DFSOfGraph {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        stack.push(0);
        visited[0] = true;
        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            int top = stack.pop();
            res.add(top);

            for (Integer node: adj.get(top)) {
                if (!visited[node]) {
                    visited[node] = true;
                    stack.push(node);
                }
            }
        }

        return res;
    }

    public ArrayList<Integer> caller(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();

        visited[0]=true;
        dfsRec(0, adj, visited, res);

        return res;
    }

    private void dfsRec(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> res) {
        res.add(v);
        for (Integer node: adj.get(v)) {
            if (!visited[node]) {
                visited[node] = true;
                dfsRec(node, adj, visited, res);
            }
        }
    }
}
