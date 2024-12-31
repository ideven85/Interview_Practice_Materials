package com.cleo.algorithms.trees;

public class ClosestValueBinarySearchTree{

    public static int findClosestElement(TreeNode root, int target) {
        // Write your code here.
        int result = target<0?Integer.MAX_VALUE:Integer.MIN_VALUE;
        return closestvalUtil(root,target,result);
    }

    public static int closestvalUtil(TreeNode root, int target, int result){
        if(root==null)
            return result;
        if(root.val==target)
            return root.val;
        if(Math.abs(root.val-target)<Math.abs(result-target)) {
            if(result!=Integer.MAX_VALUE&&result>root.val-target)
                result = root.val;
        }
        if(target<root.val)
            return closestvalUtil(root.left,target,result);
        else if(target>= root.val)
            return closestvalUtil(root.right,target,result);
        return result;
    }



}
