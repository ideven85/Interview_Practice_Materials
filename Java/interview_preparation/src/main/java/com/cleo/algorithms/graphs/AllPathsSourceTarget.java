package com.cleo.algorithms.graphs;

import java.util.*;
class SolutionAllPathsLeadsToDestination {

    // We don't use the state WHITE as such anywhere. Instead, the "null" value in the states array below is a substitute for WHITE.
    enum Color { GRAY, BLACK };

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {

        List<Integer>[] graph = buildDigraph(n, edges);
        return leadsToDest(graph, source, destination, new Color[n]);
    }

    /**
     *
     *
     *We have three states here null black gray
     *
    */
     private boolean leadsToDest(List<Integer>[] graph, int node, int dest, Color[] states) {

        // If the state is GRAY, this is a backward edge and hence, it creates a loop.
        if (states[node] != null) {
            return states[node] == Color.BLACK;
        }

        // If this is a leaf node, it should be equal to the destination.
        if (graph[node].isEmpty()) {
            return node == dest;
        }

        // Now, we are processing this node. So we mark it as GRAY
        states[node] = Color.GRAY;

        for (int next : graph[node]) {

            // If we get a `false` from any recursive call on the neighbors, we short circuit and return from there.
            if (!leadsToDest(graph, next, dest, states)) {
                return false;
            }
        }

        // Recursive processing done for the node. We mark it BLACK
        states[node] = Color.BLACK;
        return true;
    }

    private List<Integer>[] buildDigraph(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }

        return graph;
    }
}
/*
class Solution {
    private int target;
    private int[][] graph;
    private List<List<Integer>> results;

    protected void backtrack(int currNode, LinkedList<Integer> path) {
        if (currNode == this.target) {
            // Note: one should make a deep copy of the path
            this.results.add(new ArrayList<Integer>(path));
            return;
        }
        // explore the neighbor nodes one after another.
        for (int nextNode : this.graph[currNode]) {
            // mark the choice, before backtracking.
            path.addLast(nextNode);
            this.backtrack(nextNode, path);
            // remove the previous choice, to try the next choice
            path.removeLast();
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        this.target = graph.length - 1;
        this.graph = graph;
        this.results = new ArrayList<List<Integer>>();
        // adopt the LinkedList for fast access to the tail element.
        LinkedList<Integer> path = new LinkedList<Integer>();
        path.addLast(0);
        // kick of the backtracking, starting from the source (node 0)
        this.backtrack(0, path);
        return this.results;
    }
}

 */
class LeadsToDestination{
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            int v1=edge[0];
            int v2=edge[1];
            if(v1==v2)
                return false;
            graph.get(v1).add(v2);
            if(graph.get(v2).contains(v1))
                return false;
        }

        Set<Integer> seen = new HashSet<>();
        Boolean[] flag=new Boolean[n];

        //Stack<Integer> visited = new Stack<>();
        List<Integer> vertices = graph.get(source);
        return dfsUtil(graph,source,destination,flag);

      //  visited.add(source);

        //System.out.println(visited);


    }
    private boolean dfsUtil(Map<Integer,List<Integer>> graph,int source, int destination, Boolean[] state) {
            if(state[source]!=null)
                return state[source];

            List<Integer> connections = graph.get(source);
            if(connections.isEmpty())
                return source==destination;
            state[source]=false;
            // System.out.println(connections + " " + connections.size());

        for (int connection : connections)
            if (!dfsUtil(graph, connection, destination, state))
                return false;


        state[source]=true;
        System.out.print(source+ " ");

            return true;

            //visited.remove(source);
            // flag[0]=false;
            //visited.remove(source);
            // return false;

        }



}
public class AllPathsSourceTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i,new ArrayList<>());
        }
        int vertex=0;

        for(int[] edges:graph){
            for (int edge : edges) {
                map.get(vertex).add(edge);

            }
            vertex++;
        }
        List<List<Integer>> paths = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        List<Integer> subList = new ArrayList<>();
        subList.add(0);
        //Queue<List<Integer>> queue = new LinkedList<>();
        //List<Integer> path = new ArrayList<>();
        //path.add(0);
       // queue.add(path);

        /*while (!queue.isEmpty()) {
            List<Integer> currentPath = queue.poll();
            int node = currentPath.get(currentPath.size() - 1);
            for (int nextNode: graph[node]) {
                List<Integer> tmpPath = new ArrayList<>(currentPath);
                tmpPath.add(nextNode);
                if (nextNode == graph.length - 1) {
                    paths.add(new ArrayList<>(tmpPath));
                } else {
                    queue.add(new ArrayList<>(tmpPath));
                }
            }
        }

         */
        dfsUtil(map,0,n-1,subList,paths);
        return paths;

       // dfsUtil(map,0,n-1,seen,subList,paths);
       // return paths;
    }

    /**
     *
     *
     */

    private void dfsUtil(Map<Integer,List<Integer>> graph,int source, int destination,List<Integer>subList,List<List<Integer>> paths){
        if(source==destination){
          //  subList.add(destination);
            paths.add(new ArrayList<>(subList));
            return;

        }
        List<Integer> connections = graph.get(source);
        for(int connection:connections){

            subList.add(connection);

          //  seen.add(connection);
            dfsUtil(graph,connection,destination,subList,paths);
            subList.remove(subList.size()-1);
        }
    }

    public static void main(String[] args) {
        AllPathsSourceTarget paths = new AllPathsSourceTarget();
        //graph = [[1,2],[3],[3],[]]
        int[][] graph = {{1,2},{3},{3},{}};
        System.out.println(paths.allPathsSourceTarget(graph));
        // n = 3, edges = [[0,1],[0,2]], source = 0, destination = 2
        LeadsToDestination leadsToDestination = new LeadsToDestination();
        int n=3;
        int[][] edges = {{0,1},{0,2}};
        int source=0,destination=1;
        //Input: n = 4, edges = [[0,1],[0,3],[1,2],[2,1]], source = 0, destination = 3
        //[[5,15],[38,34],[29,5],[6,32],[46,2],[34,22],[2,25],[1,18],[10,10],[26,46],[40,46],[36,19],[16,13],[46,6],[19,32],[7,41],[14,32],[20,13],[0,43],[17,14],[42,41],[40,12],[28,7],[36,35],[18,2],[28,11],[14,32],[4,9],[26,6],[7,17],[49,41],[17,2],[36,34],[18,0],[26,15],[27,10],[26,46],[41,14],[47,19],[19,14],[6,3],[16,14],[21,43],[4,15],[5,2],[31,2],[5,30],[7,33],[18,2],[9,33],[21,44],[1,43],[37,17],[8,24],[21,33],[46,45],[29,14],[22,32],[14,14],[22,32],[42,6],[7,14],[35,13],[36,35],[5,25],[2,3],[23,22],[44,33],[24,13],[35,19],[20,14],[14,32],[35,5],[44,13],[32,32],[32,32],[28,46],[32,32],[37,10],[38,46],[30,30],[0,3],[15,9],[39,15],[42,44],[2,20],[47,0],[49,44],[45,4],[36,22],[13,13],[14,30],[13,14],[31,31],[45,3],[45,5],[34,14],[44,9],[30,30],[40,12],[13,30],[25,20],[34,14],[41,22],[12,34],[5,33],[20,22],[48,5],[48,7],[46,0],[14,32],[32,30],[38,46],[30,30],[35,15],[37,20],[42,2],[26,13],[8,48],[20,30],[37,33],[28,18],[32,30],[10,10],[48,44],[24,14],[8,9],[0,14],[1,43],[14,14],[20,22],[31,10],[1,0],[4,7],[27,41],[41,22],[0,22],[17,19],[8,16],[18,38],[37,23],[5,22],[35,23],[14,30],[30,30],[13,32],[28,23],[24,25],[45,2],[25,22]]
        //source=15,destination=33
        System.out.println(leadsToDestination.leadsToDestination(n,edges,source,destination));
    }
}
