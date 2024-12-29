package com.cleo.algorithms.trees;

public class ValidateThreeNodes {

    public boolean validateThreeNodes(TreeNode node,TreeNode node1, TreeNode node2){
        return (isChild(node,node1)&&isChild(node1,node2)||isChild(node2,node1)&&isChild(node1,node));
    }
    public boolean isChild(TreeNode root,TreeNode child){
        while(root!=null&&root!=child) {
            if (root.val < child.val)
                root = root.left;
            else root = root.right;
        }
        return root==child;

    }
}
