package com.cleo.algorithms.graphs;

import java.util.*;

public class AlternatingColors {

    //Example 1:
    //
    //Input: n = 3, redEdges = [[0,1]], blueEdges = [[1,2]]
    //Output: [0,1,2]
    //Example 2:
    //
    //Input: n = 3, redEdges = [[0,1]], blueEdges = [[2,1]]
    //Output: [0,1,-1]

    private static final int COLOR_NONE = 0;
    private static final int COLOR_RED = 1;
    private static final int COLOR_BLUE = 2;


    private static final int RED=0,BLUE=1;
    static class Edge{
        int destination;

        int color;

        public Edge(int destination, int color) {
            this.destination = destination;
            this.color = color;
        }
    }
    private static final Map<Integer, List<Edge>> colorMap = new HashMap<>();
    private final Map<Integer,List<Integer>> redMap = new HashMap<>();
    private final Map<Integer,List<Integer>> blueMap = new HashMap<>();

    private int[][] redEdges,blueEdges;
    //To do->Find the length of the shortest path from 0 to all other edges
    // with alternating colors
    //My mind is sleeping

    /**
     *
     * @param n Number of vertices
     * @param redEdges Edges of color red
     * @param blueEdges Edges of color blue
     * @return array with lengths of shortest paths from 0 to all oll
     * other vertices such that no two adjacent edges are of same color
     * i.e if you pick a red edge next edge should be picked from the blue set and repeat the same
     * and edges should picked such that the length overall is shortest
     *
     */
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {


        for (int i = 0; i < n; i++) {
            colorMap.put(i,new ArrayList<>());
        }
        for (int i = 0; i < redEdges.length; i++) {
            if(redEdges[i].length==2) {
                int source = redEdges[i][0];
                int destination = redEdges[i][1];
                colorMap.get(source).add(new Edge(destination, COLOR_RED));
            }
        }
        for (int i = 0; i < blueEdges.length; i++) {
            if(blueEdges[i].length==2) {
                int source = blueEdges[i][0];
                int destination = blueEdges[i][1];
                colorMap.get(source).add(new Edge(destination, COLOR_BLUE));
            }
        }
        int source=0;
        int[] cache = new int[n * 10 + 3];
        Arrays.fill(cache,Integer.MAX_VALUE);
        int[] output = new int[n];
        Arrays.fill(output,-1);
        dfsShortestPathWithAlternatingColors(source,COLOR_NONE,0,cache,output);


        return output;



    }

    private void dfsShortestPathWithAlternatingColors(int source, int previous_color,int length,int[] cache,int[] output){
        int key = source * 10 + previous_color;

        if (length >= cache[key]) {
            System.out.println("Hi");
            return;
        }

        cache[key] = length;
        output[source] = output[source] == -1 ? length : Math.min(output[source], length);
        System.out.println(source+":" +output[source]);

         List<Edge> connections = colorMap.get(source);
        for(Edge connection:connections){
            int dest=connection.destination;
            int color=connection.color;

            if(previous_color==color)
                continue;
            System.out.println(dest);

            dfsShortestPathWithAlternatingColors(dest,color,length+1,cache,output);

        }


    }

    public static void main(String[] args) {
        int n = 3;//I am sleeping
        int[][] redEdges = {{0,1},{0,2}}, blueEdges ={{}};//Shortest path from 0 to 4 is through 1
        AlternatingColors alternatingColors = new AlternatingColors();
        System.out.println(Arrays.toString(alternatingColors.shortestAlternatingPaths(n,redEdges,blueEdges)));
    }
}
class SolutionAlternatingColorsBFS {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for (int[] redEdge : redEdges) {
            adj.computeIfAbsent(redEdge[0], k -> new ArrayList<List<Integer>>()).add(
                    Arrays.asList(redEdge[1], 0));
        }

        for (int[] blueEdge : blueEdges) {
            adj.computeIfAbsent(blueEdge[0], k -> new ArrayList<List<Integer>>()).add(
                    Arrays.asList(blueEdge[1], 1));
        }

        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        boolean[][] visit = new boolean[n][2];
        Queue<int[]> q = new LinkedList<>();

        // Start with node 0, with number of steps as 0 and undefined color -1.
        q.offer(new int[] { 0, 0, -1 });
        answer[0] = 0;
        visit[0][1] = visit[0][0] = true;

        while (!q.isEmpty()) {
            int[] element = q.poll();
            int node = element[0], steps = element[1], prevColor = element[2];

            if (!adj.containsKey(node)) {
                continue;
            }

            for (List<Integer> nei : adj.get(node)) {
                int neighbor = nei.get(0);
                int color = nei.get(1);
                if (!visit[neighbor][color] && color != prevColor) {
                    if (answer[neighbor] == -1)
                        answer[neighbor] = 1 + steps;
                    visit[neighbor][color] = true;
                    q.offer(new int[] { neighbor, 1 + steps, color });
                }
            }
        }
        return answer;
    }
}