package com.cleo.algorithms.trees;

public class InvertBinaryTree {



    public void  invertTree(TreeNode root) {
        if(root!=null){
            invertTree(root.left);
            invertTree(root.right);
            TreeNode temp = root.left;
            root.left=root.right;
            root.right=temp;
        }


    }


}
