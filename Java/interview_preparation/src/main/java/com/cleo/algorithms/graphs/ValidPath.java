package com.cleo.algorithms.graphs;

import java.util.*;

public class ValidPath {
    
    private final Map<Integer, List<Integer>> graph = new HashMap<>();
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        createGraph(n,edges);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        queue.add(source);
        seen.add(source);
        while(!queue.isEmpty()){
            int current = queue.poll();
            if(current==destination)
                return true;
            
            List<Integer> connections = graph.get(current);
            for(int connection:connections){
                if(seen.contains(connection))
                    continue;
                seen.add(connection);
                queue.offer(connection);
            }
        }
        return false;

    }


    private void createGraph(int n,int[][] edges){
        for (int i = 0; i < n; i++) {
            graph.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            int source=edge[0];
            int destination=edge[1];
            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }
    }

    public static void main(String[] args) {
        int n=6;
        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        int source=0,destination=5;
        ValidPath vp = new ValidPath();
        System.out.println(vp.validPath(n,edges,source,destination));

    }
}
