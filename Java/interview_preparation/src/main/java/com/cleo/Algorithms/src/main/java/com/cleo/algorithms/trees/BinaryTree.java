package com.cleo.algorithms.trees;

public class BinaryTree {







    public TreeNode insert(TreeNode root, int val){
        if(root==null)
            root = new TreeNode(val);
        else if(root.val==val)
            root.right = new TreeNode(val);
        else if(val< root.val)
            root.left = insert(root.left,val);
        else if(val>root.val)
            root.right = insert(root.right,val);
        return root;
    }
    public void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.val+ " ");
            inOrder(root.right);
        }

    }


}
