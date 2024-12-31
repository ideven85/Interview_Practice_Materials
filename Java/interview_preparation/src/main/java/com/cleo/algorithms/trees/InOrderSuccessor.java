package com.cleo.algorithms.trees;
class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class InOrderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null)
            return null;
        if(root.val<=p.val)
            return inorderSuccessor(root.right,p);
        else{
            TreeNode left = inorderSuccessor(root.left,p);
            return left!=null?left:root;
        }
    }
    public static BinaryTreeNode<Integer> inorderSuccesor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node) {
        // Write you code here.
        if(root==null)
            return null;
        if(root.data<=node.data)
            return inorderSuccesor(root.right,node);
        else{
            BinaryTreeNode<Integer> left = inorderSuccesor(root.left,node);
            return left!=null?left:root;
        }
    }
}