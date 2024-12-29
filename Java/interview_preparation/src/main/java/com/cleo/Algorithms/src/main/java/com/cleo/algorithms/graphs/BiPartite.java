package com.cleo.algorithms.graphs;

import java.util.*;

public class BiPartite {


    public int getMinimumArrivalTime(int startVertex,int[][] edges, int parent, int arrivalTime,int[] arrivalTimes){
        arrivalTimes[startVertex]=arrivalTime;
        int minimumArrivalTime = arrivalTime;
        System.out.println(Arrays.toString(arrivalTimes));
        for(int destination:edges[startVertex]){
            if(arrivalTimes[destination]==-1)
                minimumArrivalTime =
                        Math.min(minimumArrivalTime,getMinimumArrivalTime(destination,edges,startVertex,
                        arrivalTime+1,arrivalTimes));
            else if(destination!=parent)
                minimumArrivalTime = Math.min(minimumArrivalTime,arrivalTimes[destination]);


        }
        if(minimumArrivalTime == arrivalTime && parent!=-1)
            return -1;
        return minimumArrivalTime;
    }
    public boolean twoEdgeConnectedGraph(int[][] edges) {
        // Write your code here.
        int V = edges.length;
        if(V==0)
            return true;
        int[] arrivalTimes = new int[V];
        Arrays.fill(arrivalTimes,-1);
        if(getMinimumArrivalTime(0,edges,-1,0,arrivalTimes)==-1)
            return false;

        for(int arrivalTime:arrivalTimes)
            if(arrivalTime==-1)
                return false;
        return true;

    }

    public static void main(String[] args) {
        /*
        [
  [1, 2, 5],
  [0, 2],
  [0, 1, 3],
  [2, 4, 5],
  [3, 5],
  [0, 3, 4]
]
         */
        int[][] edges = new int[][]{
                {1,2,5},
                {0,2},
                {0,1,3},
                {2,4,5},
                {3,5},
                {0,3,4}
        };
        BiPartite biPartite = new BiPartite();
        System.out.println(biPartite.twoEdgeConnectedGraph(edges));
    }
}
