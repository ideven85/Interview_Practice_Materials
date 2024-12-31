package com.cleo.algorithms.heaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
// Redo it with Heap
public class KFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        int[] answer = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
       // Queue<Integer> queue = new PriorityQueue<>();
        for(int num:nums){
            map.compute(num,(k1,v)->v==null?1:++v);
         //   queue.offer(num);
        }
       var list=map.entrySet().stream().sorted((a,b)->b.getValue()-a.getValue()).collect(Collectors.toList());
        //System.out.println(queue);
        int i=0;
       for(var m:list){
           if(i<k)
               answer[i++]=m.getKey();
       }
        return answer;



    }

    public static void main(String[] args) {
        int[] nums = {3,0,1,0};
        System.out.println(Arrays.toString(topKFrequent(nums,1)));
    }
}
