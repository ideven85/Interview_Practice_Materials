package com.cleo.algorithms.trees;

import java.util.function.Function;

public class IterativeInOrderBinaryTree {
    static class BinaryTree {
        public int val;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree parent;

        public BinaryTree(int val) {
            this.val = val;
        }

        public BinaryTree(int val, BinaryTree parent) {
            this.val = val;
            this.parent = parent;
        }
    }

    // TODO: 31/12/22  
    public static void iterativeInOrderTraversal(
            BinaryTree root, Function<BinaryTree, Void> callback) {
        // Write your code here.


    }

    public BinaryTree findSuccessor(BinaryTree root, BinaryTree node) {
        // Write your code here.
        if(root==null)
            return null;
        if(node.right!=null)
            return leftMostChild(node.right);
        else{
            BinaryTree q = node;
            BinaryTree x = node.parent;
            while(x!=null&&x.left!=q){
                q=x;
                x=x.parent;
            }
            return x;
        }

    }
    BinaryTree  leftMostChild(BinaryTree root){
        while(root.left!=null){

            root=root.left;
        }
        return root;
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(10);

    }
}
