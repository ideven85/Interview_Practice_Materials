package com.cleo.algorithms.trees;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SymmetricalTree {

    static class Pair{
        TreeNode left;
        TreeNode right;

        public Pair(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }
    public boolean symmetricalTree(TreeNode root) {
        // Write your code here.
        if(root==null)
            return true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root.left,root.right));
        while (!queue.isEmpty()){
            Pair current = queue.poll();
            if(current!=null) {
                if (current.left == null && current.right == null)
                    continue;
                if (current.left == null || current.right == null)
                    return false;
                if (current.left.val != current.right.val)
                    return false;
                queue.add(new Pair(current.left, current.right));
                queue.add(new Pair(current.right, current.left));
            }
        }
        return true;

    }

}
