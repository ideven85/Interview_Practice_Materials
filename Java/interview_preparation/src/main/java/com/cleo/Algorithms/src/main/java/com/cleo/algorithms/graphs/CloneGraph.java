package com.cleo.algorithms.graphs;

import java.util.*;

class Node {
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
public class CloneGraph {

    public Node cloneGraph(Node node) {


        if(node==null)
            return node;
        Map<Node, Node> visited = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.put(node,new Node(node.val,new ArrayList<>()));
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            for(Node neigbours: current.neighbors){
                if(!visited.containsKey(neigbours)){
                    visited.put(neigbours,new Node(neigbours.val,new ArrayList<>()));
                    queue.add(neigbours);
                }
                visited.get(current).neighbors.add(visited.get(neigbours));

            }
        }
        return visited.get(node);
    }


    private Map<Node,Node> visited= new HashMap<>();

   //DFS Approach
    public Node cloneGraphV2(Node node){
        if(node == null)
            return node;
        if(visited.containsKey(node))
            return visited.get(node);
        Node cloneNode = new Node(node.val, new ArrayList<>());
        visited.put(node,cloneNode);
        for(Node neighbours:node.neighbors)
            cloneNode.neighbors.add(cloneGraphV2(node));

        return cloneNode;

    }
}
