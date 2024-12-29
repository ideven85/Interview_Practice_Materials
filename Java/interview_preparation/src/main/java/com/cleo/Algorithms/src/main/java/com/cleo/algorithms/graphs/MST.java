package com.cleo.algorithms.graphs;

import java.util.Arrays;

public class MST {
    /**
     * Prim's Algorithm for finding the minimum weight so that all edges are connected
     * in the graph
     */
    int minimumSpanningTree(int[][] graph, int V){
        boolean[] mSet = new boolean[V];
        int[] key = new int[V];
        Arrays.fill(key,Integer.MAX_VALUE);
        int sum = 0;
        key[0]=0;
        for (int count = 0; count < V; count++) {
            int u = -1;
            for (int i = 0; i < V; i++) {
                if (!mSet[i] && (u==-1|| key[i] < key[u]))
                    u = i;
            }
            mSet[u]=true;
            sum+=key[u];
            for (int v = 0; v < V; v++) {
                if(!mSet[v]&&graph[u][v]!=0&&graph[u][v]<key[u])
                    key[v]=graph[u][v];
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }

}
