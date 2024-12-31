package com.cleo.algorithms.graphs;

import java.util.*;

public class ShortestTimeForSignalFromGivenNode {


    static class Point{
       int destination;
       int time;

        public Point(int destination, int time) {
            //this.source = source;
            this.destination = destination;
            this.time = time;
        }
    }
    private  final Map<Integer, List<Point>> graph = new HashMap<>();
 private    Map<Integer, List<Point>> adj = new HashMap<>();

    public  int networkDelayTime(int[][] times, int n, int k) {
        Queue<Point> queue = new PriorityQueue<>((a,b)->a.time-b.time);
        for(int[] time:times){
            int source=time[0];
            int destination=time[1];
            int timeForSignal=time[2];

          //  queue.add(new Point(destination,timeForSignal));
            graph.putIfAbsent(source,new ArrayList<>());
            graph.get(source).add(new Point(destination,timeForSignal));
        }
        adj=graph;
        int[] distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k]=0;
        distance[0]=0;
       // BFS(distance,k);
   //     int[] previous = new int[n];
     //   int total_time=0;
        Set<Integer> seen = new HashSet<>();
        queue.offer(new Point(k,0));
       while(!queue.isEmpty()){
            Point current = queue.remove();
            //int source=current.source;
            int currentNode = current.destination;
            if(!graph.containsKey(currentNode))
                continue;

           System.out.println(Arrays.toString(distance));




            List<Point> connections = graph.get(currentNode);
            if(connections!=null){
                for(Point p:connections){
                    int conn=p.destination;
                    int time=p.time;
                    int arrivalTime=distance[currentNode]+time;
                    if(distance[conn]>arrivalTime) {
                        distance[conn] = arrivalTime;
                        queue.offer(new Point(conn, distance[conn]));
                    }
                }
            }


        }
        System.out.println(Arrays.toString(distance));
        int distance1=Arrays.stream(distance).max().getAsInt();
        if(distance1<0||distance1==Integer.MAX_VALUE)
            return -1;
        else
            return distance1;
    }


    private void BFS(int[] signalReceivedAt, int sourceNode) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sourceNode);

        // Time for starting node is 0
        signalReceivedAt[sourceNode] = 0;

        while (!q.isEmpty()) {
            int currNode = q.remove();

            if (!adj.containsKey(currNode)) {
                continue;
            }

            // Broadcast the signal to adjacent nodes
            for (Point edge : adj.get(currNode)) {
                int time = edge.time;
                int neighborNode = edge.destination;

                // Fastest signal time for neighborNode so far
                // signalReceivedAt[currNode] + time :
                // time when signal reaches neighborNode
                int arrivalTime = signalReceivedAt[currNode] + time;
                if (signalReceivedAt[neighborNode] > arrivalTime) {
                    signalReceivedAt[neighborNode] = arrivalTime;
                    q.add(neighborNode);
                }
            }
        }
    }

    public static void main(String[] args) {
        //[[1,2,1],[2,3,2],[1,3,4]]
        //3
        //1
        int[][]times = {{1,2,1},{2,3,2},{1,3,4}};
        int n = 3, k = 1;
        ShortestTimeForSignalFromGivenNode shortestTime = new ShortestTimeForSignalFromGivenNode();
        System.out.println(shortestTime.networkDelayTime(times,n,k));
    }
}
