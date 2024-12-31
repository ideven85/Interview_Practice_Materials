package com.cleo.algorithms.graphs;

import java.util.*;

/*
class AdjListNode {
    private int v;
    private int weight;

    AdjListNode(int _v, int _w) {
        v = _v;
        weight = _w;
    }

    int getV() {
        return v;
    }

    int getWeight() {
        return weight;
    }
}

class Graph1 {
    private int V;
    private LinkedList<AdjListNode> adj[];

    Graph1(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<AdjListNode>();
    }

    void addEdge(int u, int v, int weight) {
        AdjListNode node = new AdjListNode(v, weight);
        adj[u].add(node);
    }

    void topologicalSortUtil(int v, Boolean visited[], Stack stack) {

        visited[v] = true;
        Integer i;

        Iterator<AdjListNode> it = adj[v].iterator();
        while (it.hasNext()) {
            AdjListNode node = it.next();
            if (!visited[node.getV()])
                topologicalSortUtil(node.getV(), visited, stack);
        }

        stack.add(v);
    }


    int[] shortestPath(int s) {
        Stack<Integer> stack = new Stack<>();
        int dist[] = new int[V];

        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);

        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[s] = 0;

        while (stack.empty() == false) {
            int u = (int) stack.pop();

            Iterator<AdjListNode> it;
            if (dist[u] != Integer.MAX_VALUE) {
                it = adj[u].iterator();
                while (it.hasNext()) {
                    AdjListNode i = it.next();
                    if (dist[i.getV()] > dist[u] + i.getWeight())
                        dist[i.getV()] = dist[u] + i.getWeight();
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            if(dist[i]<0||dist[i]==Integer.MAX_VALUE)
                dist[i]=-1;
        }

       return dist;
    }


}

 */

public class Djiskstra {

    static class Item{

        int vertex;
        int totalDistance;


        int distance;

        public Item(int vertex, int totalDistance, int distance) {
            this.vertex = vertex;
            this.totalDistance = totalDistance;
            this.distance = distance;
        }
    }



    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        // Write your code here.
        int V = edges.length;
        PriorityQueue<Item> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.totalDistance));
       // PriorityQueue<Item> pq = new PriorityQueue<>((x,y)->x.totalDistance-y.totalDistance);


        Set<Integer> visited = new HashSet<>();
        int[] result = new int[V];
        for(int[] edge:edges[start]){
            pq.offer(new Item(edge[0],edge[1],edge[1]));
        }
        Arrays.fill(result,-1);
        result[start]=0;
        visited.add(start);
        while(visited.size()<V&&!pq.isEmpty()){
            Item current = pq.poll();
            if(visited.contains(current.vertex))
                continue;
            visited.add(current.vertex);

            result[current.vertex]= current.totalDistance;
            for(int[] edge:edges[current.vertex]){
                if(visited.contains(edge[0]))
                    continue;
                pq.offer(new Item(edge[0],edge[1]+ current.totalDistance,edge[1]));
            }

        }
        return result;








    }

    public static void main(String args[]) {


    }
}
