package com.cleo.algorithms.graphs;

import java.util.*;
class SolutionAllPathsSourceTarget {
    private int target;
    private int[][] graph;
    private HashMap<Integer, List<List<Integer>>> memo;

    protected List<List<Integer>> allPathsToTarget(int currNode) {
        // memoization. check the result in the cache first
        if (memo.containsKey(currNode))
            return memo.get(currNode);

        List<List<Integer>> results = new ArrayList<>();
        // base case
        if (currNode == this.target) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(target);
            results.add(path);
            return results;
        }

        // iterate through the paths starting from each neighbor.
        for (int nextNode : this.graph[currNode]) {
            for (List<Integer> path : allPathsToTarget(nextNode)) {
                ArrayList<Integer> newPath = new ArrayList<>();
                newPath.add(currNode);
                newPath.addAll(path);
                results.add(newPath);
            }
        }
        memo.put(currNode, results);
        return results;
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        this.target = graph.length - 1;
        this.graph = graph;
        this.memo = new HashMap<>();

        return this.allPathsToTarget(0);
    }
}
public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTargetV1(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return paths;
        }

        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        queue.add(path);
        int destination = graph.length-1;

        while (!queue.isEmpty()) {
            List<Integer> currentPath = queue.poll();
            int node = currentPath.get(currentPath.size() - 1);
            for (int nextNode: graph[node]) {
                List<Integer> tmpPath = new ArrayList<>(currentPath);
                tmpPath.add(nextNode);
                if (nextNode == destination) {
                    paths.add(new ArrayList<>(tmpPath));
                } else {
                    queue.add(new ArrayList<>(tmpPath));
                }
            }
        }
        return paths;
    }
    private final Map<Integer,List<Integer>> map = new HashMap<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        createGraph(graph);
        int source=0,destination=graph.length-1;

        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        path.add(source);

        queue.add(path);
        List<List<Integer>> output = new ArrayList<>();
        while(!queue.isEmpty()){
            List<Integer> currentPath=queue.poll();
            int node =currentPath.get(currentPath.size()-1);

            List<Integer> connections = map.get(node);
            for(int connection:connections){
                List<Integer> temp = new ArrayList<>(currentPath);
                temp.add(connection);
                if(connection==destination)

                    output.add(new ArrayList<>(temp));

                else
                    queue.add(temp);


            }


        }
        return output;

    }
    private void createGraph(int[][] graph){
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            map.put(i,new ArrayList<>());
        }
        int i=0;
        for(int[] next:graph){
            for(int node:next){
                map.get(i).add(node);
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        AllPathsFromSourceToTarget paths = new AllPathsFromSourceToTarget();
        System.out.println(paths.allPathsSourceTarget(graph));
    }
}
