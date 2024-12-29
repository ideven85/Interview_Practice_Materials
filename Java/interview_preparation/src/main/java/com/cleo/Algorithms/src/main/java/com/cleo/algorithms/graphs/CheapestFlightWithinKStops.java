package com.cleo.algorithms.graphs;


import java.util.*;

public class CheapestFlightWithinKStops {

    static class Pair{
        int destination;
        int weight;

        public Pair(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        public int getDestination() {
            return destination;
        }

        public void setDestination(int destination) {
            this.destination = destination;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
    Map<Integer,List<Pair>> flightMap = new HashMap<>();

    // TODO: 31/08/23 "Incorrect Algorithm"
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        for (int[] flight : flights) {
          //  List<Pair> destinations;
           flightMap.putIfAbsent(flight[0],new ArrayList<>());
           flightMap.get(flight[0]).add(new Pair(flight[1],flight[2]));
        }
        int length = flights.length;
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(src,0));
        boolean[] visited = new boolean[n+1];
        int[] costs = new int[n+1];

        costs[src]=0;
        for(int node: flightMap.keySet()){
            flightMap.get(node).sort((a, b) -> a.weight - b.weight);
        }

        int stops = 0,total_weight=0;
        while(!queue.isEmpty()){
            Pair current = queue.poll();
            int destination = current.destination;
            int weight = current.weight;

            visited[destination]=true;

            costs[destination]+=weight;
            stops+=1;

            total_weight+=weight;
            System.out.println(Arrays.toString(costs));
            if(stops==k)
                break;



            List<Pair> connectedNodes = flightMap.get(destination);
            if(connectedNodes!=null)
                queue.addAll(connectedNodes);


            }
            return -1;

        }

        //Bellman Ford Algorithm
    public int findCheapestPriceV2(int n, int[][] flights, int src, int dst, int k) {
            if(src==dst)
                return 0;
            int[] previous = new int[n];
        int[] current = new int[n];
        Arrays.fill(previous,Integer.MAX_VALUE);
        Arrays.fill(current,Integer.MAX_VALUE);
        previous[src]=0;

        for (int i = 1; i < k+2; i++) {
            current[src]=0;
            for(int[] flight:flights){
                int origin = flight[0],destination=flight[1],cost=flight[2];
                if(previous[origin]<Integer.MAX_VALUE){
                    current[destination]=Math.min(current[destination],previous[origin]+cost);
                }

            }
            System.out.println(Arrays.toString(current));
            previous=current.clone();
        }
        return current[dst]==Integer.MAX_VALUE?-1:current[dst];

    }
    public static void main(String[] args) {
        //Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
        int n = 4;
        int[][] flights = new int[][]{
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };
        int src=0,dst=3,k=1;
        CheapestFlightWithinKStops cheapestFlights = new CheapestFlightWithinKStops();
        System.out.println(cheapestFlights.findCheapestPrice(n,flights,src,dst,k));
        System.out.println(cheapestFlights.findCheapestPriceV2(n,flights,src,dst,k));
    }



}
