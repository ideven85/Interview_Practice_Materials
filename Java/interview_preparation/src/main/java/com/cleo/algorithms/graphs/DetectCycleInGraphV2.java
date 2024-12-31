package com.cleo.algorithms.graphs;

import java.util.*;

public class DetectCycleInGraphV2 {


    public boolean dfsUtil(List<List<Integer>> adj,int source,int destination, boolean[] seen){
        if(source==destination)
            return true;
        if(!seen[source]){
            seen[source]=true;
            for(var adjacent:adj.get(source)){
                if(!seen[adjacent])
                    dfsUtil(adj,adjacent,destination,seen);
            }
        }
        return false;


    }

    public boolean cycleInGraph(int[][] edges) {
        // Write your code here.
        int V = edges.length+1;
        int[] in_degree = new int[V];
        for(var row:edges){
            for(int edge:row){
                in_degree[edge]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if(in_degree[i]==0)
                queue.add(i);
        }
        int count = 0;
        while(!queue.isEmpty()){
            int current = queue.poll();


        }
      return false;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {1,2},
                {0},
                {0}

        };
        DetectCycleInGraphV2 cycle = new DetectCycleInGraphV2();
        System.out.println(cycle.cycleInGraph(edges));
    }
}
