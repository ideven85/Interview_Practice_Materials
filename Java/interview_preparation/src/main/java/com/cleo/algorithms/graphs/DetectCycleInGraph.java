package com.cleo.algorithms.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInGraph {

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int source, int destination){
        adj.get(source).add(destination);
    }


    public static boolean cycleInGraph(ArrayList<ArrayList<Integer>> edges, int V) {
        // Write your code here.

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int i=0;
        for(var row:edges){
            for(var c: row){
                addEdge(adj,i,c);
            }
                i++;
        }
        int[] in_degree = new int[V];
        for (int u = 0; u < V; u++) {
            for (int x:adj.get(u))
                in_degree[x]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (i = 0; i < V; i++) {
            if(in_degree[i]==0)
                queue.add(i);
        }
        int count = 0;
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int x:adj.get(u)){
                if(--in_degree[x]==0)
                    queue.add(x);
                count++;
            }
        }
        return count==V;


    }

    static boolean detectCycleV2(ArrayList<ArrayList<Integer>> adj, int V){
        int[] in_degree = new int[V];
        for (int u = 0; u < V; u++) {
            for (int x:adj.get(u))
                in_degree[x]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if(in_degree[i]==0)
                queue.add(i);
        }
        int count = 0;
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int x:adj.get(u)){
                if(--in_degree[x]==0)
                    queue.add(x);
                count++;
            }
        }
       return count==V;
    }



    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {1},
                {2},
                {3},
                {4},
                {5},
                {}

        };

    }
}
