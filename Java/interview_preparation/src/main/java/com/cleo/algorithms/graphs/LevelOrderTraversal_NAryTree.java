package com.cleo.algorithms.graphs;

import java.util.*;

public class LevelOrderTraversal_NAryTree {
  private static   class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<List<Integer>> levelOrder(Node root) {
      List<List<Integer>> output = new ArrayList<>();
      if(root==null)
          return output;

        Queue<List<Node>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(root));


        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> curr = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                List<Node> temp = queue.poll();
               assert temp!=null;
                for(Node node:temp){
                    curr.add(node.val);
                    if(node.children!=null)
                        queue.offer(node.children);



                }




            }
            if(!curr.isEmpty())
                output.add(new ArrayList<>(curr));

        }
        return output;


    }
    public List<List<Integer>> levelOrderV1(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        dfs(root,0,res);
        return res;
    }
    private void dfs(Node root, int level, List<List<Integer>> res){
        if(root==null) return;
        if(res.size()==level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        for(Node child:root.children){
            dfs(child, level+1, res);
        }
    }
}
