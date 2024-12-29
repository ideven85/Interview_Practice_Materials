package com.cleo.algorithms.trees;


import java.util.ArrayList;
import java.util.List;

public class LeafNodes {

    List<Integer> leaves = new ArrayList<>();
    public List<Integer> findLeaves(TreeNode root) {
        if(root==null)
            return leaves;
        findLeaves(root, new ArrayList<>());
        System.out.println(leaves);
        return temp;

    }
    List<Integer> temp = new ArrayList<>();

    public void findLeaves(TreeNode root, List<Integer> current) {
        if (root == null) {


            return;

            //  temp = new ArrayList<>();
        } else {
            current.add(root.val);
            if (root.left == null && root.right == null) {
              // System.out.println(current.get(current.size()-1));
                temp.add(current.get(current.size() - 1));
                System.out.println("Temp:"+temp);

               // current.remove(current.get(current.size() - 1));

            }
                if (root.left != null)
                    findLeaves(root.left, current);
                if (root.right != null)
                    findLeaves(root.right, current);


        }
    }

}
