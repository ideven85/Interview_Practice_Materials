package com.cleo.algorithms.strings;

import java.util.PriorityQueue;
import java.util.Queue;

public class ContainsDuplicate {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {

           int j=0;
        if(k==0)
            return false;
        if(nums.length==1)
            return false;
        j = Math.abs(nums.length-k);
        for (int i = 0; i <j ; i++) {
            int num = nums[i];
        //    System.out.print(num + "\t");
            for (int l = i+1; l <=i+k; l++) {
          //      System.out.print("l = " + nums[l]+ "\t");
                if(num==nums[l])
                    return true;
            }
        }
        if((nums.length-k)>0){
            for (int i = nums.length-k; i < nums.length; i++) {
                int num = nums[i];
                for (int l = i+1; l < nums.length; l++) {
                    if(num==nums[l])
                        return true;
                }
            }
        }
        return false;

    }

    public static boolean containsNearByDuplicateV2(int[] nums, int k){
        int n = nums.length;
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            queue.offer(nums[i]);

                for (int j = i+1; j<i+k; j++) {
                    if (j < n) {
                        if (queue.contains(nums[j]))
                            return false;

                            queue.offer(nums[j]);

                    }
                }
            }
            return true;

    }

    public static void main(String[] args) {
        int[] nums = {2,2};
        int k = 3;
        int[] nums1 = {1,0,1,1};
        int k1 = 1;
        int[] nums2 = {1,2,3,1,2,3,3};
        int k2 = 2;

        System.out.println(containsNearByDuplicateV2(nums,k));
        System.out.println(containsNearByDuplicateV2(nums1,k1));
        System.out.println(containsNearbyDuplicate(nums2,k2));
    }
}
