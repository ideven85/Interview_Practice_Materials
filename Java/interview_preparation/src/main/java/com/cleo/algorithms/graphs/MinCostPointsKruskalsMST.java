package com.cleo.algorithms.graphs;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class MinCostPointsKruskalsMST {

    static class Edge{
        int source;
        int destination;

        int distance;

        public Edge(int source, int destination, int distance) {
            this.source = source;
            this.destination = destination;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return source + " " + destination + " " + distance;
        }
    }

    static class UnionFind{
        private final int[] root;
        private final int[] rank;

        public UnionFind(int size) {
            this.root = IntStream.range(0,size).toArray();
            this.rank = new int[size];
            Arrays.fill(rank,1);
        }

        public int find(int x){
            if(root[x]==x)
                return x;
            return root[x]=find(root[x]);

        }
        public void union(int x, int y){
            if(root[x]==root[y])
                return;
            int rootX = find(x);
            int rootY = find(y);
            if(rank[rootX]>rank[rootY]){
                root[rootY]=rootX;
            }else if(rank[rootX]<rank[rootY])
                root[rootX]=rootY;
            else{
                root[rootY]=rootX;
                rank[rootX]+=1;
            }


        }

        public boolean connected(int x, int y){
            return find(x)==find(y);
        }
    }



    public int minCostConnectPoints(int[][] points) {
        Queue<Edge> queue = new PriorityQueue<>((point1,point2)->point1.distance-point2.distance);
        int size=points.length;
        UnionFind uf = new UnionFind(size);
        for (int i = 0; i < size; i++) {
            int[] coordinate1 = points[i];
            for (int j = i+1; j < size; j++) {
                int[] coordinate2 = points[j];
                int distance = Math.abs(coordinate1[0]-coordinate2[0])+Math.abs(coordinate1[1]-coordinate2[1]);
                Edge edge = new Edge(i,j,distance);
                queue.add(edge);

            }
        }
        System.out.println(queue);
        int distance=0;
        int count=size-1;
        while(!queue.isEmpty()&&count>0){
            Edge current = queue.poll();
            if(!uf.connected(current.source, current.destination)){
                uf.union(current.source,current.destination);
                distance+= current.distance;
                count--;
            }
            System.out.print(distance+ " ");
        }

        System.out.println();
        System.out.println(queue);

        System.out.println(Arrays.toString(uf.root));
        System.out.println(Arrays.toString(uf.rank));
        return distance;


    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {0, 2}, {3, 10}, {5, 2}, {7, 0}};
        MinCostPointsKruskalsMST mst = new MinCostPointsKruskalsMST();
        System.out.println(mst.minCostConnectPoints(points));

    }
}
