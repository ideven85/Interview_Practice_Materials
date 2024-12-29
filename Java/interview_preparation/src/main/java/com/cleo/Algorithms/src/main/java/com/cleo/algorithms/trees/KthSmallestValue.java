package com.cleo.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestValue {
    int answer =0;
    List<Integer> output = new ArrayList<>();
    public int inOrder(TreeNode root,int k,int answer){
        if(root!=null){
            inOrder(root.left,k,answer++);

            output.add(root.val);
          //  System.out.println(output.size());
            if(output.size()==k)
                answer=root.val;
            inOrder(root.right,k,answer++);


        }
        return -1;
    }
    public int kthSmallest(TreeNode root,int k){
        inOrder(root,k,0);
        return output.get(k-1);
        //   return answer;
    }
}
