package com.cleo.algorithms.trees;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConstructBST{
    static class BST {
        public int val;
        public BST left;
        public BST right;

        public BST(int val) {
            this.val = val;
        }


        public BST insert(int val) {
            // Write your code here.
            // Do not edit the return statement of this method.
            insertHelper(this ,val);
            return this;
        }
        public BST insertHelper(BST root, int val){
            if(root==null)
                return new BST(val);
            if(val<root.val)
                root.left = insertHelper(root.left,val);
            else
                root.right = insertHelper(root.right,val);
            return root;
        }

        public boolean contains(int val) {
            // Write your code here.

            return containsHelper(this,val);
        }
        public boolean containsHelper(BST root, int val){
            if(root==null)
                return false;
            if(root.val==val)
                return true;
           else if(val< root.val)
              return   containsHelper(root.left,val);
            else
                return containsHelper(root.right,val);
         }

        public BST remove(int val) {
            // Write your code here.
            // Do not edit the return statement of this method.

            removeHelper(this,val);
            return this;
        }
        public BST removeHelper(BST root, int val){
            if(root==null)
                return root;
            if(val< root.val)
                root.left = removeHelper(root.left, val);
            else if (val > root.val)
                    root.right = removeHelper(root.right, val);

            else{
                if(root.left==null&&root.right==null)
                    return null;
                if(root.left!=null&&root.right==null){
                    root.val=root.left.val;
                    root.right = root.left.right;
                    root.left=root.left.left;
                    return root;
                }
                if(root.left==null&&root.right!=null){
                    root.val=root.right.val;
                    root.left=root.right.left;
                    root.right=root.right.right;
                    return root;

                }
                if(root.right!=null&&root.left!=null){
                        int smallest = smallestHelper(root.right);
                        root.val=smallest;
                        root.right=removeHelper(root.right,smallest);
                        return root;
                }
            }
            return root;
        }
        public int smallestHelper(BST root){
            return (root.left==null)?root.val:smallestHelper(root.left);
        }
    }

}
