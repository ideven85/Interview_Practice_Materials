package com.cleo.algorithms.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CompareLeafTraversal {

    static class BinaryTree {
        public int val;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int val) {
            this.val = val;
        }
    }

    public List<Integer> findLeaves(BinaryTree root, List<Integer> leaves){
        temp = new ArrayList<>();
        if(root==null)
            return temp;
        findTreeLeaves(root,new ArrayList<Integer>());
        return temp;
    }
    List<Integer> temp = new ArrayList<>();
    public void findTreeLeaves(BinaryTree root,List<Integer> current){
        if(root==null){
           return;
        }else{
            current.add(root.val);
            if(root.left==null && root.right==null){
                temp.add(current.get(current.size()-1));
            }
            if(root.left!=null){
                findTreeLeaves(root.left,current);
            }
            if(root.right!=null)
                findTreeLeaves(root.right,current);

        }

    }

    public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
        // Write your code here.
     List<Integer> tree1Leaves = new ArrayList<>(),tree2Leaves = new ArrayList<>();

       tree1Leaves = findLeaves(tree1,tree1Leaves);
        System.out.println(tree1Leaves);
       tree2Leaves = findLeaves(tree2,tree2Leaves);
        if(tree1Leaves.size()!=tree2Leaves.size())
            return false;
        for (int i = 0; i < tree1Leaves.size(); i++) {
            if(!Objects.equals(tree1Leaves.get(i), tree2Leaves.get(i)))
                return false;
        }
        return true;
    }
}
