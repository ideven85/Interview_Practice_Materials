package com.cleo.algorithms.graphs;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionUndirectedGraph {

    private boolean dfsUtilDetectCycle(int source, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent){
        visited[source]=true;
        List<Integer> connections=adj.get(source);
        for(int conn:connections){
            if(!visited[conn]) {
                if (dfsUtilDetectCycle(conn, adj, visited, source))
                    return true;
                else if(conn!=parent)
                    return true;
            }

        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!visited[i])
                if(dfsUtilDetectCycle(i,adj,visited,-1))
                    return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //Input:
        //V = 5, E = 5
        //adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}}
        int V=5;
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).addAll(List.of(0,2,4));
        graph.get(2).addAll(List.of(1,3));
        graph.get(3).addAll(List.of(2,4));
        graph.get(4).addAll(List.of(1,3));
        CycleDetectionUndirectedGraph cycle = new CycleDetectionUndirectedGraph();
        System.out.println(cycle.isCycle(V,graph));
    }
}
