package com.cleo.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeBranchSums {
    public static List<Integer> branchSums(TreeNode root) {

        List<Integer> temp = new ArrayList<>();
        calculateSums(root,temp,0);
        int[] total = new int[1];
        totalSum(root,0,total);
        //   System.out.println(total[0]);

        return temp;
    }
    public static void calculateSums(TreeNode root, List<Integer> sums, int current){
        if(root==null)
            return;
        current+= root.val;
        if(root.left==null&&root.right==null){
            sums.add(current);
            current=0;
        }
        calculateSums(root.left,sums,current);
        calculateSums(root.right,sums,current);
    }
    public static void totalSum(TreeNode root, int current, int[] total){
        if(root==null)
            return ;
        current=current*10+ root.val;
        if(root.left==null&&root.right==null) {
            total[0] += current;

        }
        totalSum(root.left,current,total);
        totalSum(root.right,current,total);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        BinaryTree tree = new BinaryTree();
        tree.insert(root,3);
        tree.insert(root,6);
        tree.insert(root,4);
        tree.insert(root,2);
        tree.insert(root,7);
        System.out.println(branchSums(root));
    }

}
