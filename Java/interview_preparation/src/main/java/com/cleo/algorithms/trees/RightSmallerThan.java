package com.cleo.algorithms.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class RightSmallerThan {


    static class BinaryTree {
        int val;
        BinaryTree left;
        BinaryTree right;


        public BinaryTree(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static BinaryTree insert(BinaryTree root, int data) {
            if (root == null)
                root = new BinaryTree(data);

            else {
                if (data < root.val)
                    root.left = insert(root.left, data);
                else if(data==root.val)
                    root.right = insert(root.right,data);
                else
                    root.right = insert(root.right, data);
            }
            return root;
        }

        public static void inOrder(BinaryTree root, List<Integer> vals) {
            if (root != null) {
                inOrder(root.left, vals);
                vals.add(root.val);
                inOrder(root.right, vals);
            }
        }

        static class SpecialBST{
        int val;
        int leftSubTreeSize;
        SpecialBST left;
        SpecialBST right;

            public SpecialBST(int val) {
                this.val = val;
            }

            public void insert(int val, int index, List<Integer> rightSmallerCounts){
                insertHelper(val,index,rightSmallerCounts,0);
        }
        public void insertHelper( int val, int index, List<Integer> rightSmallerCounts,int numberOfvalsSmallerAtInsertTime){
            if(val<this.val){
                leftSubTreeSize++;
                if(left==null){
                    left = new SpecialBST(val);
                    rightSmallerCounts.set(index,numberOfvalsSmallerAtInsertTime);
                }else{
                    left.insertHelper(val,index,rightSmallerCounts,numberOfvalsSmallerAtInsertTime);
                }
            }else{
                numberOfvalsSmallerAtInsertTime+=leftSubTreeSize;
                if(val>this.val)numberOfvalsSmallerAtInsertTime++;

                    if(right==null) {
                    right = new SpecialBST(val);
                    rightSmallerCounts.set(index,numberOfvalsSmallerAtInsertTime);
                }else{
                    right.insertHelper(val,index,rightSmallerCounts,numberOfvalsSmallerAtInsertTime);
                }

            }



        }

        }


    public static List<Integer> rightSmallerThan(List<Integer> array) {
        // Write your code here.
        List<Integer> output = new ArrayList<>();


        for (int i = 0; i < array.size(); i++) {
            BinaryTree bt = new BinaryTree(array.get(i));

            for (int j = i+1; j < array.size(); j++) {
                insert(bt,array.get(j));



            }
            List<Integer> vals = new ArrayList<>();
            inOrder(bt,vals);
          //  System.out.println(vals);
            output.add(vals.indexOf(array.get(i)));
        }




        return output;
    }
    public static List<Integer> rightSmallerThanV2(List<Integer> array){
        if(array.size()==0) return new ArrayList<>();
        List<Integer> rightSmallerCounts = new ArrayList<>(array);
        int size = array.size();
        rightSmallerCounts.set(size-1,0);
        SpecialBST bst = new SpecialBST(array.get(size-1));
        for (int i = size-2; i >=0 ; i--) {//Starting from right index...

            bst.insert(array.get(i),i,rightSmallerCounts);
            System.out.println(rightSmallerCounts);


        }
        return rightSmallerCounts;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(8,5,11,-1,3,4,2,2,5);
        System.out.println(rightSmallerThanV2(arr));
    }
}
