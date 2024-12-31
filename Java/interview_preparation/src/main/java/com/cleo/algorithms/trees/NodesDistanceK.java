package com.cleo.algorithms.trees;

import java.util.*;
import java.util.*;

class Program {
    // This is an input class. Do not edit.
    static class BinaryTreeNode {
        public int data;
        public BinaryTreeNode left = null;
        public BinaryTreeNode right = null;

        public BinaryTreeNode(int data) {
            this.data = data;
        }

    }
    public static BinaryTreeNode insert(BinaryTreeNode root,int data){
        if(root==null)
            root = new BinaryTreeNode(data);
        if(data<root.data)
            root.left=insert(root.left,data);
        else if(data> root.data)
            root.right=insert(root.right,data);
        return root;
    }

    static class Pair{
        int data;
        BinaryTreeNode node;

        public Pair() {
        }

        public Pair(int data, BinaryTreeNode node) {
            this.data = data;
            this.node = node;
        }
    }


   static Map<Integer,BinaryTreeNode> parents = new HashMap<>();

    public static void populateParents(BinaryTreeNode root, BinaryTreeNode current,int k,int target){
        if(root==null)
            return;
        if(k==target)
            parents.put(current.data,root);
        if(current.data<root.data)
            populateParents(root.left,current,k,target+1);
        else
            populateParents(root.right,current,k,target-k-1);

    }
    public  static BinaryTreeNode getTargetNode(BinaryTreeNode root,int target){
            if(target<root.data)
               return getTargetNode(root.left,target);
            else if(target==root.data)
                return root;
            else
              return   getTargetNode(root.right,target);


    }

    public static ArrayList<Integer> findNodesDistanceK(BinaryTreeNode root, int target, int k) {
        // Write your code here.
        BinaryTreeNode targetNode = getTargetNode(root,target);

        populateParents(root,targetNode,k,0);
        
        if(targetNode.left!=null&&targetNode.data>target)
            targetNode=targetNode.left;
        else if(target>targetNode.data&&targetNode.right!=null)
            targetNode=targetNode.right;

      //  System.out.println(targetNode.data);
        ArrayList<Integer> output = new ArrayList<>();
        Set<BinaryTreeNode> seen = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0,targetNode));

        while(!queue.isEmpty()){
            int current_distance=0;
            Pair p  = queue.poll();


            if(p!=null){
                BinaryTreeNode current = p.node;
              //  System.out.println(current.data);

                for (int i = 0; i < queue.size(); i++) {


                    if(seen.contains(current))
                        continue;
                    seen.add(current);
                   // System.out.println(current_distance);

                    if(current_distance==k) {
                        output.add(current.data);

                    }
                    if(current_distance>k)
                        break;

                   // System.out.println(current_distance);
                    queue.offer(new Pair(current_distance+1,parents.get(current.data)));


                }
            }

        }

        return output;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        insert(root,8);
        insert(root,12);
        insert(root,7);
        insert(root,13);
       // BinaryTreeNode node = getTargetNode(root,7);
        //System.out.println(node.data);
        List<Integer> output= findNodesDistanceK(root,8,1);
        System.out.println(output);
    }

}

public class NodesDistanceK {

    public void getTargetNode(TreeNode root,TreeNode targetNode,int target){

    }
    ArrayList<Integer> nodesAtDistanceK = new ArrayList<>();

    public void dfsUtil(TreeNode targetNode,int k){

    }
    public ArrayList<Integer> findNodesDistanceK(TreeNode root,int target, int k){
        TreeNode targetNode = new TreeNode(0);
        getTargetNode(root,targetNode,target);
        return null;

    }
}
