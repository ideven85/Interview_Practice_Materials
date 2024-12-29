package com.cleo.algorithms.trees;


public class BST {
    public int val;
    public BST left;
    public BST right;

    public BST(int val) {
        this.val = val;
        this.left=null;
        this.right=null;
    }

    public void insert(int val) {
        if (val < this.val) {
            if (left == null) {
                left = new BST(val);
            } else {
                left.insert(val);
            }
        } else {
            if (right == null) {
                right = new BST(val);
            } else {
                right.insert(val);
            }
        }
    }
    public static void inOrder(BST root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.val+ " ");
            inOrder(root.right);
        }

    }
}
