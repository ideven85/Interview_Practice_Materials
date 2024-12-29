package com.cleo.algorithms.graphs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LatestSolution {


    private  int[] root;
    private  int[] rank;

    private int find(int x){
        if(root[x]==x)
            return x;
        return root[x]=find(root[x]);
    }
  /*  int minimumSpanningTree(int[][] graph, int V){
        boolean[] mSet = new boolean[V];
        int[] key = new int[V];
        Arrays.fill(key,Integer.MAX_VALUE);
        int sum = 0;
        key[0]=0;
        for (int count = 0; count < V; count++) {
            int u = -1;
            for (int i = 0; i < V; i++) {
                if (!mSet[i] && (u==-1|| key[i] < key[u]))
                    u = i;
            }
            mSet[u]=true;
            sum+=key[u];
            for (int v = 0; v < V; v++) {
                if(!mSet[v]&&graph[u][v]!=0&&graph[u][v]<key[u])
                    key[v]=graph[u][v];
            }
        }
        return sum;
    }

   */


    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] isInMST = new boolean[n];
        int[] vertices = IntStream.range(0,n).toArray();
        int cost=0,edgesUsed=0;
        int[] edgeCost = new int[n];
        Arrays.fill(edgeCost,Integer.MAX_VALUE);
        edgeCost[0]=0;
        for (edgesUsed = 0; edgesUsed < n; edgesUsed++) {
            int currentNode=-1;
            int currentMinEdge=Integer.MAX_VALUE;


            for (int node = 0; node < n; ++node) {
                if (!isInMST[node] && currentMinEdge > edgeCost[node]) {
                    currentMinEdge = edgeCost[node];
                    currentNode = node;
                }
            }
            isInMST[currentNode]=true;//Starting with Node 0
            cost+=currentMinEdge;//Starting with cost 0
          //  System.out.println(currentNode + ":" + cost);
            for (int i = 0; i < n; ++i) {
                int length=Math.abs(points[currentNode][0]-points[i][0])
                        +Math.abs(points[currentNode][1]-points[i][1]);
                if(!isInMST[i]&&edgeCost[i]>length)
                    edgeCost[i]=length;//Now we are picking i with least distance from first node
            }

        }
       // System.out.println(Arrays.toString(edgeCost));
        return cost;




        //Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
    }

    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        int[][] points1 = {{3,12},{-2,5},{-4,1}};
        System.out.println(minCostConnectPoints(points));
       // System.out.println(minCostConnectPoints(points1));
    }
}
class Solution2 {
    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int mstCost = 0;
        int edgesUsed = 0;

        // Track nodes which are visited.
        boolean[] inMST = new boolean[n];

        int[] minDist = new int[n];
        minDist[0] = 0;

        for (int i = 1; i < n; ++i) {
            minDist[i] = Integer.MAX_VALUE;
        }

        while (edgesUsed < n) {
            int currMinEdge = Integer.MAX_VALUE;
            int currNode = -1;

            // Pick least weight node which is not in MST.
            for (int node = 0; node < n; ++node) {
                if (!inMST[node] && currMinEdge > minDist[node]) {
                    currMinEdge = minDist[node];
                    currNode = node;
                }
            }

            mstCost += currMinEdge;
            edgesUsed++;
            inMST[currNode] = true;

            // Update adjacent nodes of current node.
            for (int nextNode = 0; nextNode < n; ++nextNode) {
                int weight = Math.abs(points[currNode][0] - points[nextNode][0]) +
                        Math.abs(points[currNode][1] - points[nextNode][1]);

                if (!inMST[nextNode] && minDist[nextNode] > weight) {
                    minDist[nextNode] = weight;
                }
            }
        }

        return mstCost;
    }
    public static void main(String[] args) {
        int[][] points = {{0,0},{2,0},{3,10},{5,2},{7,0}};
        System.out.println(minCostConnectPoints(points));
    }
}
/*
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        // Min-heap to store minimum weight edge at top.
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> (a.getKey() - b.getKey()));;

        // Track nodes which are included in MST.
        boolean[] inMST = new boolean[n];

        heap.add(new Pair(0, 0));
        int mstCost = 0;
        int edgesUsed = 0;

        while (edgesUsed < n) {
            Pair<Integer, Integer> topElement = heap.poll();

            int weight = topElement.getKey();
            int currNode = topElement.getValue();

            // If node was already included in MST we will discard this edge.
            if (inMST[currNode]) {
                continue;
            }

            inMST[currNode] = true;
            mstCost += weight;
            edgesUsed++;

            for (int nextNode = 0; nextNode < n; ++nextNode) {
                // If next node is not in MST, then edge from curr node
                // to next node can be pushed in the priority queue.
                if (!inMST[nextNode]) {
                    int nextWeight = Math.abs(points[currNode][0] - points[nextNode][0]) +
                            Math.abs(points[currNode][1] - points[nextNode][1]);

                    heap.add(new Pair(nextWeight, nextNode));
                }
            }
        }

        return mstCost;
    }
}

 */

class SolutionKruskals {
    // Kruskal's Algorithm
    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int size = points.length;
        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> x.cost - y.cost);
        UnionFind uf = new UnionFind(size);

        for (int i = 0; i < size; i++) {
            int[] coordinate1 = points[i];
            for (int j = i+1; j < size; j++) {
                int[] coordinate2 = points[j];
                // Calculate the distance between two coordinates.
                int cost = Math.abs(coordinate1[0] - coordinate2[0]) +
                        Math.abs(coordinate1[1] - coordinate2[1]);
                Edge edge = new Edge(i, j, cost);
                pq.add(edge);
            }
        }

        int result = 0;
        int count = size - 1;
        while (!pq.isEmpty() && count > 0) {
            Edge edge = pq.poll();
            if (!uf.connected(edge.point1, edge.point2)) {
                uf.union(edge.point1, edge.point2);
                result += edge.cost;
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

    class UnionFind {
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



    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        SolutionKruskals solution = new SolutionKruskals();
        System.out.print("Minimum Cost to Connect Points = ");
        System.out.println(solution.minCostConnectPoints(points));
    }
}


public class MinCostToConnectAllPoints {


    static class Point{
        int id;
        int x_coOrdinate,y_coOrdinate;


        public Point(int id,int x_coOrdinate, int y_coOrdinate) {
            this.id = id;
            this.x_coOrdinate = x_coOrdinate;
            this.y_coOrdinate = y_coOrdinate;
        }

        @Override
        public String toString() {
            return x_coOrdinate + " " + y_coOrdinate;
        }
    }

    static class PointComparator implements Comparator<Point>{

        @Override
        public int compare(Point p1, Point p2){
            int x1 = p1.x_coOrdinate,y1=p1.y_coOrdinate,x2=p2.x_coOrdinate,y2= p2.y_coOrdinate;
            return (int) Math.abs(x2-x1)-Math.abs(y2-y1);
        }
    }

    public int weight(Point p1, Point p2){
        int x1 = p1.x_coOrdinate,y1=p1.y_coOrdinate,x2=p2.x_coOrdinate,y2= p2.y_coOrdinate;
        return (int) Math.abs(x2-x1)+Math.abs(y2-y1);
    }







    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        int[] distances = new int[V];
        List<Point> pointGraph = new ArrayList<>();
       // Queue<Point> queue = new PriorityQueue<>();

        createPointGraph(points,pointGraph);
        pointGraph=pointGraph.stream()
                .sorted(new PointComparator()).collect(Collectors.toList());

        System.out.println(pointGraph);



        Point first = pointGraph.get(0);
        System.out.println(first);
        int distance=0;
        for (int i = 1; i < pointGraph.size(); i++) {
            Point p = pointGraph.get(i);
            distance+=weight(p,first);
            first=p;


        }
        return (int) distance;









    }

    public void createPointGraph(int[][] points,List<Point> pointGraph){
        for (int i = 0; i < points.length; i++) {
            Point p = new Point(i,points[i][0],points[i][1]);
            pointGraph.add(p);
        }
    }

    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        MinCostToConnectAllPoints minCost = new MinCostToConnectAllPoints();
        System.out.println(minCost.minCostConnectPoints(points));
    }
}
