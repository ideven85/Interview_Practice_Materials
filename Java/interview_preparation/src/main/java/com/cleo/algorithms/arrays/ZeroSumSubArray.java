package com.cleo.algorithms.arrays;

import java.util.LinkedHashSet;
import java.util.Set;

public class ZeroSumSubArray {
    public boolean zeroSumSubarray(int[] nums) {
        // Write your code here.
        Set<Integer> set = new LinkedHashSet<>();
        int curr = 0;
        set.add(0);
        for(int num:nums){
            curr+=num;
            System.out.println(set);
            if(!set.add(curr))
                return true;
            set.add(curr);

        }
        return false;
    }

    public static void main(String[] args) {
        ZeroSumSubArray zeroSum  = new ZeroSumSubArray();
        int[] nums = new int[]{2,2,-3,-1,-3};
        System.out.println(zeroSum.zeroSumSubarray(nums));
    }
}
