package com.cleo.algorithms.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructBST {
    static class BST {
        public int val;
        public BST left = null;
        public BST right = null;

        public BST(int val) {
            this.val = val;
        }
    }
    BST root;
    public BST insert(BST root, int val){
        if(root==null)
           return new BST(val);

        if(val<root.val)
            root.left=insert(root.left,val);

        else
            root.right= insert(root.right,val);
        return root;
    }

    public void inOrder(BST root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    public BST reconstructBst(ArrayList<Integer> preOrderTraversalvals) {
        // Write your code here.
        BST root = new BST(preOrderTraversalvals.get(0));
        for (int i = 1; i < preOrderTraversalvals.size(); i++) {
            insert(root,preOrderTraversalvals.get(i));
        }
        return root;

    }

    public static void main(String[] args) {
        ArrayList<Integer> vals = new ArrayList<>();
        vals.add(10);
        vals.add(4);
        vals.add(2);
        vals.add(1);vals.add(5);vals.add(1);vals.add(19);vals.add(18);
        ReconstructBST bst = new ReconstructBST();
        BST root = bst.reconstructBst((ArrayList<Integer>) vals);
        bst.inOrder(root);
    }
}
