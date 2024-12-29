package com.cleo.algorithms.arrays;

import java.util.List;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.stream.Collectors;

public class KthLargest {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:nums){
            pq.add(num);
        }
      //  System.out.println(pq);
        List<Integer> answer = pq.stream().sorted().collect(Collectors.toList());
       // System.out.println(answer);
        return answer.get(nums.length-k);

    }

    public static void main(String[] args) {
        int[] el = new int[]{3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(el,k));
    }
}