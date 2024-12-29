package com.cleo.algorithms.graphs;

import java.util.*;
class Solution3 {
    // Prim Algorithm
    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int size = points.length;
        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> x.cost - y.cost);
        boolean[] visited = new boolean[size];
        int result = 0;
        int count = size - 1;
        // Add all edges from points[0] vertexs
        int[] coordinate1 = points[0];
        for (int j = 1; j < size; j++) {
            // Calculate the distance between two coordinates.
            int[] coordinate2 = points[j];
            int cost = Math.abs(coordinate1[0] - coordinate2[0]) +
                    Math.abs(coordinate1[1] - coordinate2[1]);
            Edge edge = new Edge(0, j, cost);
            pq.add(edge);
        }
        visited[0] = true;

        while (!pq.isEmpty() && count > 0) {
            Edge edge = pq.poll();
            int point1 = edge.point1;
            int point2 = edge.point2;
            int cost = edge.cost;
            if (!visited[point2]) {
                result += cost;
                visited[point2] = true;
                for (int j = 0; j < size; j++) {
                    if (!visited[j]) {
                        int distance = Math.abs(points[point2][0] - points[j][0]) +
                                Math.abs(points[point2][1] - points[j][1]);
                        pq.add(new Edge(point2, j, distance));
                    }
                }
                count--;
            }
        }
        return result;
    }

    class Edge {
        int point1;
        int point2;
        int cost;

        Edge(int point1, int point2, int cost) {
            this.point1 = point1;
            this.point2 = point2;
            this.cost = cost;
        }
    }



        public static void main(String[] args) {
            int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
            Solution3 solution = new Solution3();
            System.out.print("Minimum Cost to Connect Points = ");
            System.out.println(solution.minCostConnectPoints(points));
        }

}

public class MinCostPrim {

    static class Edge{
        int point1;

        int point2;

        int weight;

        public Edge(int point1, int point2, int weight) {
            this.point1 = point1;
            this.point2 = point2;
            this.weight = weight;
        }

        public Edge() {
        }
    }

    static class UnionFind{

        private final int[] root;
        private final int[] rank;

        public UnionFind(int size){
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i]=i;
                rank[i]=1;
            }
        }
        public int find(int u){
            if(root[u]==u)
                return u;
            return root[u]=find(root[u]);
        }
        public void union(int u, int v){
            int rootU = find(u);
            int rootV = find(v);
            if(rootU!=rootV){
                if(rank[rootU]>rank[rootV])
                    root[rootV]=rootU;
                else if(rank[rootU]<rank[rootV])
                    root[rootU]=rootV;
                else{
                    root[rootV]=rootU;
                    rank[rootU]+=1;
                }
            }
        }
        public boolean connected(int u, int v){
            return find(u)==find(v);
        }


    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;


        PriorityQueue<Edge> pq = new PriorityQueue<>((x,y)->x.weight- y.weight);

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int[] point1 = points[i];
                int[] point2 = points[j];
                int weight = Math.abs(point1[0]-point2[0])+Math.abs(point1[1]-point2[1]);
                pq.add(new Edge(i,j,weight));

            }
        }
        UnionFind uf = new UnionFind(n);
        int cost = 0;
        while(!pq.isEmpty()&&n>1){
            Edge current = pq.poll();
            int vertex1 = current.point1;
            int vertex2 = current.point2;

            if(!uf.connected(vertex1,vertex2)){
                uf.union(vertex1,vertex2);
                cost += current.weight;
                n--;
            }


        }

        return cost;



    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        MinCostPrim minCost = new MinCostPrim();
        System.out.println(minCost.minCostConnectPoints(points));
    }
}
