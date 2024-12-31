package com.cleo.algorithms.trees;

import java.util.*;

public class RightSideView {

    public List<Integer> rightSideView(TreeNode root){
        List<Integer> output = new ArrayList<>();
        if(root==null)
            return output;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode current=new TreeNode();
            for (int i = 0; i < queue.size(); i++) {


                current = queue.poll();
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
            if(current.val!=0)
                output.add(current.val);
        }

        return output;
    }
}
