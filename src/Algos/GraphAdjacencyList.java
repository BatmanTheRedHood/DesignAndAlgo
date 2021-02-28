package Algos;

import models.Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GraphAdjacencyList extends Algorithm {
    // Adjacency List for Directional & Bidirectional non-weighted graph
    private List<List<Integer>> adj;

    @Override
    protected void init() {
        this.adj = new ArrayList<>();

        for (int i = 0; i < 5; i++)
            adj.add(new ArrayList<>());

        // Adding edges one by one
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        // addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        // addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
    }

    @Override
    protected void run() {
        List<Boolean> visitedNodes = new ArrayList<>();
        for (int i=0; i<this.adj.size(); i++){
            visitedNodes.add(i, false);
        }

        //this.dfs(0, visitedNodes);

        for (int i=0; i<visitedNodes.size(); i++) {
            this.dfsWithStack(i, visitedNodes);
        }
    }

    // This doesn't traverse all nodes if graph is disconnected
    private void dfsWithStack(int node, List<Boolean> visitedNodes){
        if (visitedNodes.get(node)){
            return;
        }

        // Initialize
        Stack<Integer> stack = new Stack<>();
        stack.push(node);

        while (!stack.empty()){
            node = stack.pop();
            if (visitedNodes.get(node)){
                continue;
            }

            System.out.print(String.format("%s ", node));
            visitedNodes.set(node, true);

            for(Integer i: this.adj.get(node)){
                stack.push(i);
            }
        }
    }

    // Uses system stack. This doesn't traverse all nodes if graph is disconnected
    private void dfs(int node, List<Boolean> visitedNodes) {
        // Return if visited
        if (visitedNodes.get(node)){
            return;
        }

        // Print and mark visited
        System.out.print(String.format("%s ", node));
        visitedNodes.set(node, true);

        // Visit neighbours
        for (Integer neighbour: this.adj.get(node)){
            dfs(neighbour, visitedNodes);
        }
    }

    private void addEdge(List<List<Integer>> adj, int nodeA, int nodeB){
        this.adj.get(nodeA).add(nodeB);
        this.adj.get(nodeB).add(nodeA);
    }
}
