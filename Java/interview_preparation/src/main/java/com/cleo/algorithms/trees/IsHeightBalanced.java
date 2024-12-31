package com.cleo.algorithms.trees;

public class IsHeightBalanced {

    public static int height(TreeNode root){
        if(root==null)
            return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }


    public  static boolean heightBalancedBinaryTree(TreeNode root) {
        // Write your code here.
        if(root==null)
            return true;
        boolean[] balanced = new boolean[1];
        balanced[0]=true;
        isHeightBalancedUtil(root,balanced);
        return balanced[0];
    }
    public static int isHeightBalancedUtil(TreeNode root,boolean[] balanced){
        if(root==null)
            return 0;
        int left = isHeightBalancedUtil(root.left,balanced);
        int right = isHeightBalancedUtil(root.right,balanced);
        if(Math.abs(left-right)>1)
            balanced[0]=false;
        return 1+Math.max(left,right);

    }

}
