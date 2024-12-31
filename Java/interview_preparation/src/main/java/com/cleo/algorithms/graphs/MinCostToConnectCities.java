package com.cleo.algorithms.graphs;

import java.util.*;

public class MinCostToConnectCities {
    static class Node{
        int destination,weight;

        public Node( int destination, int weight) {
            //this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public Node() {
        }


    }


    public int minimumCost(int n, int[][] connections) {
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o->o.weight));

        Map<Integer, List<Node>> map = new HashMap<>();
        for (int i = 0; i <=n ; i++) {
            map.put(i,new ArrayList<>());

        }
        for(int[] connection:connections){
            int source=connection[0],destination=connection[1],weight=connection[2];
            map.get(source).add(new Node(destination,weight));
            map.get(destination).add(new Node(source,weight));

        }

        for(int node: map.keySet()){
            map.get(node).sort((a,b)->a.weight-b.weight);
        }
        int cost=0;
        // int[] result=new int[n+1];

        // Arrays.fill(result,Integer.MAX_VALUE);
        // result[0]=0;
        Set<Integer> seen = new HashSet<>();
        int connectionsToBeAdded=n;
        // queue.offer(new Node(1));
        queue.offer(new Node(connections[0][0],0));
        while(!queue.isEmpty()){
            Node current=queue.poll();


            int destination=current.destination;
            int weight= current.weight;

            if(seen.contains(destination))
                continue;
            seen.add(destination);
            // seen.add(destination);
            cost+=weight;
            connectionsToBeAdded-=1;
            if(connectionsToBeAdded==0) {
                //System.out.println("HI");
                break;
            }
            List<Node> connectedPaths=map.get(destination);
            if(connectedPaths!=null){
                queue.addAll(connectedPaths);
            }


            // queue.offer(new Node(destination,cost,source));

        }
        // System.out.println(seen);
        // System.out.println(connectionsToBeAdded);
        // System.out.println(cost);

        return connectionsToBeAdded==0?cost:-1;

    }
}
