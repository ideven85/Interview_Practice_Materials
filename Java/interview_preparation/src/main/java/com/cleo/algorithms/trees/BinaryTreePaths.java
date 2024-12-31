package com.cleo.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public void findPaths(TreeNode root, String s, List<String> paths){
        if(root==null)
            return;
        if(root.left==null&&root.right==null){
           StringBuilder s1 = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                s1.append(s.charAt(i));
                s1.append("->");
            }
            s1.append(root.val);
            paths.add(s1.toString());
            //paths.add(s);
            s = "";
        }
        findPaths(root.left,s+root.val,paths);
        findPaths(root.right,s+root.val,paths);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        String s="";
        findPaths(root,s,paths);
        return paths;

    }
}
