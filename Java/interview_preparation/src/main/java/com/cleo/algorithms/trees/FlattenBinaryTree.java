package com.cleo.algorithms.trees;

import java.util.*;

public class FlattenBinaryTree {


    public static TreeNode flattenBinaryTree(TreeNode root) {
        // Write your code here.
        Map<Integer,Integer> map = new HashMap<>();
        Queue<Pair> current = new LinkedList<>();
        current.add(new Pair(root,0));
        map.put(0,root.val);
        while(!current.isEmpty()) {
            Pair u = current.poll();
            TreeNode node = u.node;
            int height = u.data;
            map.computeIfAbsent(height, k -> node.val);
            if(node.left!=null){
                current.add(new Pair(node.left,height-1));

            }
            if(node.right!=null)
                current.add(new Pair(node.right,height+1));
        }
        TreeNode temp=null,current1 = null,newRoot=null;
        int i=0;
        for(Map.Entry<Integer,Integer> m: map.entrySet()){
            if(i==0) {
                newRoot = new TreeNode(m.getValue());
                current1=newRoot;
                temp=newRoot;
                System.out.print(newRoot.val+" ");
                newRoot.left=null;
                i+=1;
            }else{
                current1.right = new TreeNode(m.getValue());
                current1.left=temp;
                temp=current1;
                current1=current1.right;
                System.out.print(current1.val+ " ");

            }


        }
        System.out.println();  System.out.println();
       return newRoot;
    }
}
