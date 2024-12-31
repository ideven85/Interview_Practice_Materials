package com.cleo.algorithms.graphs;

import java.util.*;

public class ReachableNodes {

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, List<Integer>> nodeMap = new HashMap<>();
        for(int[] edge: edges){
            int source = edge[0];
            int destination = edge[1];
            nodeMap.putIfAbsent(source,new ArrayList<>());
            nodeMap.get(source).add(destination);
            nodeMap.putIfAbsent(destination,new ArrayList<>());
            nodeMap.get(destination).add(source);
        }
        int start=0;
        for(var m:nodeMap.entrySet()){
            System.out.println(m.getKey()+":"+m.getValue());
        }
        boolean[] visited = new boolean[n];
        Set<Integer> restrictions = new HashSet<>();
        for(int r: restricted)
            restrictions.add(r);
        dfsFromStart(nodeMap,start,visited,restrictions);
        return count;

    }
    int count=0;
    public void dfsFromStart(Map<Integer,List<Integer>> map,int start,boolean[] visited,Set<Integer> restricted){

        if(visited[start])
           return;
        if(restricted.contains(start))
            return;
        count+=1;

        visited[start]=true;
        List<Integer> connectedNodes = map.get(start);
        if(connectedNodes!=null) {
            for (int connection : connectedNodes) {


                dfsFromStart(map, connection, visited, restricted);
            }
        }

    }

    public static void main(String[] args) {
        ReachableNodes nodes = new ReachableNodes();
        int  n = 2;
        int[][] edges = {{0,1},{0,2},{0,5},{0,4},{3,2},{6,5}};
        int[] restricted = {4,2,1};
        System.out.println(nodes.reachableNodes(n,edges,restricted));
    }
}
