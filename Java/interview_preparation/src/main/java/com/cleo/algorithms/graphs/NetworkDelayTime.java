package com.cleo.algorithms.graphs;


import java.util.*;

class NetworkDelayTimeDFS {

    Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();

    private void DFS(int[] signalReceivedAt, int currNode, int currTime) {
        // If the current time is greater than or equal to the fastest signal received
        // Then no need to iterate over adjacent nodes
        if (currTime >= signalReceivedAt[currNode]) {
            return;
        }

        // Fastest signal time for currNode so far
        signalReceivedAt[currNode] = currTime;

        if (!adj.containsKey(currNode)) {
            return;
        }

        // Broadcast the signal to adjacent nodes
        for (Pair<Integer, Integer> edge : adj.get(currNode)) {
            int travelTime = edge.getKey();
            int neighborNode = edge.getValue();

            // currTime + time : time when signal reaches neighborNode
            DFS(signalReceivedAt, neighborNode, currTime + travelTime);
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        // Build the adjacency list
        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];

            adj.putIfAbsent(source, new ArrayList<>());
            adj.get(source).add(new Pair(travelTime, dest));
        }

        // Sort the edges connecting to every node
        for (int node : adj.keySet()) {
            Collections.sort(adj.get(node), (a, b) -> a.getKey() - b.getKey());
        }

        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

        DFS(signalReceivedAt, k, 0);

        int answer = Integer.MIN_VALUE;
        for (int node = 1; node <= n; node++) {
            answer = Math.max(answer, signalReceivedAt[node]);
        }

        // Integer.MAX_VALUE signifies atleat one node is unreachable
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
class NetworkDelayTimeBFS{
    // Adjacency list
    Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();

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
            for (Pair<Integer, Integer> edge : adj.get(currNode)) {
                int time = edge.getKey();
                int neighborNode = edge.getValue();

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

    public int networkDelayTime(int[][] times, int n, int k) {
        // Build the adjacency list
        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];

            adj.putIfAbsent(source, new ArrayList<>());
            adj.get(source).add(new Pair<>(travelTime, dest));
        }

        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

        BFS(signalReceivedAt, k);

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, signalReceivedAt[i]);
        }

        // INT_MAX signifies atleat one node is unreachable
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}


public class NetworkDelayTime {

    private static class Edge{


        int destination;

        int weight;

        public Edge( int destination, int weight) {

            this.destination = destination;
            this.weight = weight;
        }
    }

    static class EdgeComparator implements Comparator<Edge>{
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    private final Map<Integer, List<Edge>> table = new HashMap<>();
    public int networkDelayTime(int[][] times, int n, int k) {
        for(var time: times){
            List<Edge> connections;
            if(table.get(time[0])==null){
                connections = new ArrayList<>();
                connections.add(new Edge(time[1],time[2]));

            }else{
                connections=table.get(time[0]);
                connections.add(new Edge(time[1],time[2]));

            }
            table.put(time[0],connections);


        }

        table.forEach((key,value)-> value.sort(new EdgeComparator()));
        int count = n-1;

        Queue<Integer> queue = new LinkedList<>();
        int[] delays = new int[n+1];
        for (int i = 0; i < n; i++) {
            delays[i]=Integer.MAX_VALUE;
        }
        delays[k]=0;
        queue.add(k);

        while(!queue.isEmpty()){
            int current = queue.poll();



        //    System.out.println(visited);
                List<Edge> adjacent = table.get(current);
                if(adjacent!=null) {
                    for (Edge edge : adjacent) {


                        int destination = edge.destination;
                        int weight = edge.weight;
                        // System.out.println(weight);
                        if (delays[destination] > delays[current] + weight) {
                            delays[destination] = delays[current] + weight;
                            //    System.out.println(delays[destination]);
                            queue.add(destination);
                        }


                    }
                }

            }

        delays[0]=0;
        int sum = Arrays.stream(delays).sum();
        System.out.println(Arrays.toString(delays));
        if(!(sum==Integer.MAX_VALUE||sum<0))
            return Arrays.stream(delays).sum();
        else
            return -1;


    }

    public static void main(String[] args) {
        int[][] times = new int[][]{{1,2,1}};
        int n=2,k=1;
        NetworkDelayTime delayTime = new NetworkDelayTime();
        System.out.println(delayTime.networkDelayTime(times,n,k));
    }
}
