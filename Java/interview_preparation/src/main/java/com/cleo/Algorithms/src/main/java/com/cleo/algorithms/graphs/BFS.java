package com.cleo.algorithms.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * In Graph theory, the primary use cases of the “breadth-first search”
 * (“BFS”) algorithm are:
 *
 * Traversing all vertices in the “graph”;
 * Finding the shortest path between two vertices in a graph
 * where all edges have equal and positive weights.
 *
 * DFS uses stack as its integral data structure
 * BFS uses queue to perform its operations
 */
public class BFS {
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            // Write your code here.
           Queue<Node> queue = new LinkedList<>();
           queue.add(this);
           while(!queue.isEmpty()){
               Node current = queue.poll();
               array.add(current.name);
               queue.addAll(current.children);
           }
           return array;

        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
