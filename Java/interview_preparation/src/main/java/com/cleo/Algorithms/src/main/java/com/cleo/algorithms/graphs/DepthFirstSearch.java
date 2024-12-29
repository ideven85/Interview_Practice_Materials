package com.cleo.algorithms.graphs;

import java.util.*;

public class DepthFirstSearch {
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }




        public List<String> dfs(List<String> array){
            array.add(name);
            children.forEach(c->c.dfs(array));
            return array;
        }


    }


    public static void main(String[] args) {
        Node root = new Node("A");
        root=root.addChild("B");


    }
}
