package com.cleo.algorithms.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsPossible {

    private Map<Integer, List<Integer>> graph;
    /**
     * @param paths You are presented with an undirected connected graph
     *      * consisting of n vertices and connections between them represented by an adjacency matrix.
     * @return Your objective is to determine whether it is possible to start traversing from a node, x,
     *   and return to it after traversing all the vertices at least once,
     *   using each edge exactly once.
     */
    //todo
    public int isPossible(int[][] paths) {
        // Code here
        graph = new HashMap<>();
        int n =paths.length;
        for (int i = 0; i < n; i++) {
            graph.put(i,new ArrayList<>());
        }

        createGraph(paths);

    return 0;

    }
    public void createGraph(int[][] paths){
        for(int[] row:paths){

        }
    }

}
