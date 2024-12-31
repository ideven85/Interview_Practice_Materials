package com.cleo.algorithms.trees;

public class MaxDifferenceNodeAncestor {

    private int MAX_DIFF=0;

    public void maxAncestorDiffUtil(TreeNode parent, TreeNode child, int difference){
        if(parent==null&&child==null)
            return;
        if(child!=null&&parent!=null){
            difference=Math.max(Math.abs(parent.val- child.val),difference);
            if(MAX_DIFF<=difference)
                MAX_DIFF=difference;
        }
        if(parent!=null&&parent.left!=null)
            maxAncestorDiffUtil(parent.left,parent,difference);
        if(parent!=null&&parent.right!=null)
            maxAncestorDiffUtil(parent.right,parent,difference);






    }
    public int maxAncestorDiff(TreeNode root) {
        if(root==null)
            return 0;
        maxAncestorDiffUtil(root,null,0);
        return MAX_DIFF;

    }
}
