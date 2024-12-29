package com.cleo.algorithms.trees;

import java.util.List;

public class MinHeightBST {

    public static void minHeightBST(List<Integer> array, BST root, int low, int high){
        if(low>=high)
            return ;
        int mid = (low+high)/2;
        root.insert(array.get(mid));
        minHeightBST(array,root,low,mid);



        minHeightBST(array,root,mid+1,high);

    }
    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        int n = array.size();
        //   root.insert(val);
        int low=0,high=n;
        int mid = (low+high)/2;
        BST root = new BST(array.get(mid));
        minHeightBST(array,root,low,mid);
        minHeightBST(array,root,mid+1,high);
        return root;

    }

}
