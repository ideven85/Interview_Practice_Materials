package com.cleo.algorithms.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloningGraph {
    private static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node==null)
            return node;
        if(visited.containsKey(node))
            return visited.get(node);
        Node clone = new Node(node.val,new ArrayList<>());
        visited.put(node,clone);
        if(node.neighbors!=null)
            for(Node adjacent:node.neighbors)
                clone.neighbors.add(cloneGraph(adjacent));
        return clone;

    }

}
