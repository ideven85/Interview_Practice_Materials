package com.cleo.algorithms.trees;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {
    public static void topView(TreeNode root) {
        Map<Integer,Integer> map = new TreeMap<>();
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
        for(Map.Entry<Integer,Integer> m: map.entrySet()){
            System.out.print(m.getKey()+":"+m.getValue() + " ");
        }
        System.out.println();
    }
}
