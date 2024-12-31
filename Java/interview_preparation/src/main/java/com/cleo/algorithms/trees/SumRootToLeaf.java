package com.cleo.algorithms.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SumRootToLeaf {

    public void sumRootToLeafNumbers(TreeNode root, int[] sum){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        List<Integer> numbers = new ArrayList<>();
        int depth=0;
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();

            if(current!=null){

                int value = current.val;


            }

        }
    }
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
       return root.val + sumNumbers(root.left)+sumNumbers(root.right);

    }
}
