package com.cleo.algorithms.graphs.dfs;

import java.util.*;

public class ValidPath {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for(var m:adj.entrySet()){
            System.out.println(m.getKey()+":"+m.getValue());
        }
        Set<Integer> seen = new HashSet<>();
        boolean[] flag=new boolean[1];
       // flag[0]=false;
     dfsUtil(adj,source,destination,seen,n,flag);
        System.out.println(seen);
        return flag[0];

    }
    public void dfsUtil(Map<Integer,List<Integer>> graph, int source, int destination, Set<Integer> seen,int V,boolean[] flag){
        if(source==destination) {
            flag[0]=true;
            return;
        }

        List<Integer> connections = graph.get(source);
        for(int connection:connections){
            //System.out.print(connection+" ");
            if(destination==connection) {
              //  System.out.println("Hi");
               flag[0]=true;
               return;
            }
            if(seen.contains(connection))
                continue;
            seen.add(connection);
            dfsUtil(graph,connection,destination,seen,V,flag);
        }


    }

    public static void main(String[] args) {
        //n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
        int n=6;
        int[][] edges = {{0,1},{0,2},{1,3},{3,5},{5,4},{4,3}};
        int source=0,destination=5;
        ValidPath vp = new ValidPath();
        System.out.println(vp.validPath(n,edges,source,destination));
    }
}
