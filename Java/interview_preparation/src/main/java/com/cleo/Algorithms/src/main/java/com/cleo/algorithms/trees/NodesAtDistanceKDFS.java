package com.cleo.algorithms.trees;

import java.util.*;

public class NodesAtDistanceKDFS {

    private static class Pair{
        int distance;
        TreeNode node;

        public Pair( TreeNode node,int distance) {
            this.distance = distance;
            this.node = node;
        }

        public Pair() {
        }
    }
    /*public TreeNode getTargetNode(TreeNode root, int target){
        if(root.val==target)
            return root;
        TreeNode nodeParent=map.get(target);
        if(nodeParent.left!=null&&nodeParent.left.val==target)
            return nodeParent.left;
        else
            return nodeParent.right;


    }

     */
   Map<Integer,TreeNode> map = new HashMap<>();

    public void populateParents(TreeNode root,TreeNode parent){
        if(root!=null){
            map.put(root.val,parent);
            populateParents(root.left,root);
            populateParents(root.right,root);
        }
    }

    ArrayList<Integer> output = new ArrayList<>();

    public void breadthFirstSearchForNodesDistanceK(TreeNode targetNode,int k){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(targetNode,0));
        Set<Integer> seen = new HashSet<>();
        seen.add(targetNode.val);

        while(!queue.isEmpty()){
            Pair current = queue.poll();
            TreeNode currentNode=current.node;
            int distanceFromTarget= current.distance;


            if(distanceFromTarget == k){
                int size=queue.size();
                for (int i = 0; i < size; i++) {
                    Pair currentNodes = queue.poll();
                    assert currentNodes!=null;
                    output.add(currentNodes.node.val);
                }
                output.add(currentNode.val);
                return;
            }


            List<TreeNode> connectedNodes = Arrays.asList(currentNode.left,currentNode.right,map.get(currentNode.val));
            for(TreeNode node:connectedNodes){
                if(node!=null){
                    if(seen.contains(node.val))
                        continue;
                    seen.add(node.val);
                    queue.add(new Pair(node,distanceFromTarget+1));
                }
            }

        }

    }

    public List<Integer> findNodesDistanceK(TreeNode root, TreeNode target, int k) {
        // Write your code here.
        populateParents(root,null);
      
        breadthFirstSearchForNodesDistanceK(target,k);



        return output;
    }


}
