package com.cleo.algorithms.graphs;

public class Main {

    public boolean cycleInGraph(int[][] edges) {

        int V = edges.length;
        boolean[] visited = new boolean[V];
        boolean[] currentlyInStack = new boolean[V];
        for (int node = 0; node <V ; node++) {
            if(visited[node])
                continue;
            boolean containsCycle=hasCycle(node,edges,visited,currentlyInStack);
            if(containsCycle)
                return true;
        }
        return false;

    }
    public boolean hasCycle(int source, int[][] edges, boolean[] visited, boolean[] inStack){
        visited[source]=true;
        inStack[source]=true;
        boolean containsCycle=false;
        for(int neighbour:edges[source]){
            if(!visited[neighbour])
                containsCycle=hasCycle(neighbour,edges,visited,inStack);
            if(containsCycle)
                return true;
            else if(inStack[neighbour])
                return true;
        }
        inStack[source]=false;
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 3},{2, 3, 4},{0},{},{2,5},{}};
        Main m= new Main();
        System.out.println(m.cycleInGraph(edges));

    }
}
