package com.cleo.algorithms.n_aryTree;

import java.util.ArrayList;

public class TreeNode<T>{
    T data;
    ArrayList<TreeNode<T>> children;

    public TreeNode(T data){
        this.data= data;
        this.children= new ArrayList<>();
    }
}
