package com.cleo.algorithms.hashing;

public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    int balanceFactor;

    public TreeNode(int data) {
        this.val = data;
        this.left=null;
        this.right=null;
    }



    public int height(TreeNode root){
        if(root==null)
            return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }

    public boolean isHeightBalanced(TreeNode root){
        int answer=0;
        if(root==null)
            return true;
        int left=height(root.left);
        int right=height(root.right);
        return Math.abs(right-left)<=1 && isHeightBalanced(root.left) && isHeightBalanced(root.right);
    }
}
