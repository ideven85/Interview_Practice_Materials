package com.cleo.algorithms.trees;

public class ClosestBinarySearchTreeValue {
    public int closestval(TreeNode root, double target) {
        int result = target>0?Integer.MIN_VALUE:Integer.MAX_VALUE;
        return closestval(root,target,result);

    }
    public int closestval(TreeNode root, double target, int result){
        if(root==null)
            return (int)result;
        if(root.val==target)
            return root.val;
        if(Math.abs(root.val-target)<Math.abs(target-result))
            result= root.val;
        if(target< root.val)
            return closestval(root.left,target,result);
        else
            return closestval(root.right,target,result);
    }
}
