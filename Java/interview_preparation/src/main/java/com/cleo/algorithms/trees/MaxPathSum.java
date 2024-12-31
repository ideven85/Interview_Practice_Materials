package com.cleo.algorithms.trees;

public class MaxPathSum {
    static int maxPath;
    public static int maxPathSum(TreeNode root) {
        // Write your code here.
        maxPath=Integer.MIN_VALUE;
         findMaxPathSum(root);
         return maxPath;

    }
    public static int findMaxPathSum(TreeNode root){
        if(root==null)
            return 0;
        int left = Math.max(findMaxPathSum(root.left),0);
        int right = Math.max(findMaxPathSum(root.right),0);
        maxPath = Math.max(maxPath,root.val+left+right);
        return root.val+Math.max(left,right);
    }

}
