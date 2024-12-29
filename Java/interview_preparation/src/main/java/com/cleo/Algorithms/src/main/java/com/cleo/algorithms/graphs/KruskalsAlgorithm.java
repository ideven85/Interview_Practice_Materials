package com.cleo.algorithms.graphs;

import java.util.*;

public class KruskalsAlgorithm {

   static class UnionFind {
        int root[];
        int rank[];

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }


    static class Edge{
        int origin,destination,weight;

        public Edge(int origin, int destination, int weight) {
            this.origin = origin;
            this.destination = destination;
            this.weight = weight;
        }

        public Edge() {
        }
    }


    //Weighted Edges
    //Connect all edges with minimum possible total weight

    /*
    public int[][][] kruskalsAlgorithm(int[][][] edges) {
        // Write your code here.
         int V = edges.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int[][] ints : edges) {
            for (int[] edge : ints) {
                List<Integer> edgeList = new ArrayList<>();
                for (int vertex : edge)
                    edgeList.add(vertex);
                adj.add(edgeList);

            }

        }
        boolean[] seen = new boolean[V];
        int[] in_degree = new int[V];

        for(var edge: adj){
            for(int adjacent:edge){
                in_degree[adjacent]++;
            }
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if(in_degree[i]==0)
                queue.add(i);
        }
        while(!queue.isEmpty()){
            int current = queue.poll();
            if(seen[current])
                continue;
            seen[current]=true;
            count+=1;
            for(int adjacent:adj.get(current)){
                if(!seen[adjacent])
                    queue.add(adjacent);
            }
        }


        return new int[][][] {};
    }

     */

    public int[][][] kruskalsAlgorithm(int[][][] edges) {
        int V = edges.length;
        List<List<Integer>> sortedEdges = new ArrayList<>();
        for (int source = 0; source < edges.length; source++) {
            for (int[] edge : edges[source]) {
                if (edge[0] > source)
                    sortedEdges.add( Arrays.asList(source, edge[0], edge[1]));
            }
        }
        sortedEdges.sort((e1, e2) -> e1.get(2) - e2.get(2));

        List<List<int[]>> mst = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            mst.add(i, new ArrayList<>());
        }

        UnionFind uf = new UnionFind(V);
        for (var vertices : sortedEdges) {
            int vertex1Root = uf.find(vertices.get(0));
            int vertex2Root = uf.find(vertices.get(1));
            if (vertex1Root != vertex2Root) {
                mst.get(vertices.get(0)).add(new int[]{vertices.get(1), vertices.get(2)});
                mst.get(vertices.get(1)).add(new int[]{vertices.get(0), vertices.get(2)});
                uf.union(vertex1Root,vertex2Root);

            }
        }
        int[][][] result = new int[edges.length][][];
        for (int i = 0; i < mst.size(); i++) {
            result[i] = new int[mst.get(i).size()][];
            for (int j = 0; j < mst.get(i).size(); j++) {
                result[i][j] = mst.get(i).get(j);
            }
        }
        return result;
    }



}
