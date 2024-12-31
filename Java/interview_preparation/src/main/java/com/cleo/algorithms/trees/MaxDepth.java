package com.cleo.algorithms.trees;

public class MaxDepth {

    public int height(TreeNode root){
        if(root==null)
            return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }


    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int left= height(root.left);
        int right = height(root.right);
        return 1+Math.max(left,right);

    }
}
