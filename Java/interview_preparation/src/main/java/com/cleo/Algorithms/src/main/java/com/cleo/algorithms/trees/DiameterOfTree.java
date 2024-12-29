package com.cleo.algorithms.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DiameterOfTree {

    public int binaryTreeDiameterV1(TreeNode root) {
        // Write your code here.
     //   List<Boolean> visited = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int maximum_length = 0;
        queue.offer(root);
        queue.offer(null);
        int level = 0,current_size=0;
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();

            if(current!=null){
                visited.add(current.val);
                if(current.left!=null && current.right!=null){
                    queue.offer(current.left);
                    queue.offer(current.right);
                    current_size+=2;
                }else if(current.left!=null){
                    queue.offer(current.left);
                    current_size+=1;
                }else if(current.right!=null){
                    queue.offer(current.right);
                    current_size+=1;
                }
                level+=1;

            }else{
                if(maximum_length<=current_size)
                    maximum_length=current_size;
                if(!queue.isEmpty()){
                    queue.offer(null);

                }
            }
        }
        return -1;
    }

    private static int diameter=0;
    public static int diameterOfTree(TreeNode root) {
        if (root == null)
            return 0;
        treeDiameterUtil(root);
        return diameter;
    }
    public static int treeDiameterUtil(TreeNode root){
        int left = 0;
        int right = 0;
        if(root.left==null&&root.right==null)
            return 0;
        if(root.left!=null)
            left = treeDiameterUtil(root.left);
        if(root.right!=null)
            right = treeDiameterUtil(root.right);
        if((left+right)>diameter)
            diameter = left+right;

        return 1+Math.max(left,right);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = new TreeNode(10);
        bt.insert(root, 8);
        bt.insert(root,12);
        bt.insert(root,14);
        bt.insert(root,7);
        bt.insert(root,6);
        bt.insert(root,5);
        bt.insert(root,15);
        System.out.println(diameterOfTree(root));
    }
}
