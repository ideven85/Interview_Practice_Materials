package com.cleo.algorithms.graphs;

import java.util.*;


public class NextRightPointer {
    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    static class Pair{
        Node node;
        int depth;

        public Pair(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    public Node connect(Node root) {
        if(root==null)
            return null;
        List<Node> currentNodes = new ArrayList<>();
        currentNodes.add(root);
        Queue<List<Node>> queue = new LinkedList<>();
        queue.offer(currentNodes);


        while(!queue.isEmpty()){
            List<Node> nodes = queue.poll();
            if(nodes.isEmpty())
                continue;
            List<Node> children = new ArrayList<>();
            if(nodes.size()>1) {
                for (int i = 0; i < nodes.size() - 1; i++) {
                    Node first = nodes.get(i);
                    Node second = nodes.get(i+1);
                    if(second!=null)
                        first.next=second;
                    if (first.left != null && first.right != null) {
                        children.add(first.left);
                        children.add(first.right);
                    }


                }
                Node last= nodes.get(nodes.size()-1);
                if(last.left!=null&&last.right!=null){
                    children.add(last.left);
                    children.add(last.right);
                }
                queue.offer(children);
            }else{
                Node node =nodes.get(0);
                if(node!=null) {
                    Node first = node.left;
                    children.add(first);
                    Node second = node.right;
                    if (second != null) {
                        first.next = second;
                        children.add(second);
                    }

                    queue.offer(children);
                }
            }



        }
        return root;

    }
}
