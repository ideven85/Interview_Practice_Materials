package com.cleo.algorithms.graphs;

import java.util.Arrays;

public class CheapestFlightBellmanFordAlgorithm {
    //Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
    //Output: 700
    //Explanation:
    //The graph is shown above.
    //The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
    //Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if(src==dst)
            return 0;
        int[] prev = new int[n];
        int[] current = new int[n];
        Arrays.fill(prev,Integer.MAX_VALUE);
        Arrays.fill(current,Integer.MAX_VALUE);
        prev[src]=0;
        for (int i = 0; i <= k; i++) {
            current[src]=0;
            for(int[] flight:flights){
                int source=flight[0];
                int destination=flight[1];
                int cost=flight[2];
                if(prev[source]<Integer.MAX_VALUE){
                    current[destination]=Math.min(current[destination],prev[source]+cost);
                }
            }
            System.out.println(Arrays.toString(current));
            //System.out.println(Arrays.toString(prev));

            prev=current.clone();
        }
        System.out.println(Arrays.toString(current));
        return current[dst]==-1?Integer.MAX_VALUE:current[dst];

    }

    public static void main(String[] args) {
        //Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]],
        // src = 0, dst = 3, k = 1
        int n=4;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src=0,dst=3,k=2;//1 stop means 2 flights
        System.out.println(findCheapestPrice(n,flights,src,dst,k));

    }
}
