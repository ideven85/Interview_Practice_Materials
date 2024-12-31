package com.cleo.algorithms.arrays;

import java.util.Arrays;
import java.util.List;

public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int[] startingAndEndingIndicesOfTarget = new int[2];
        boolean found = false;
        for (int i = 0; i < nums.length; i++) {
            if(target==nums[i]) {
                found=true;
                startingAndEndingIndicesOfTarget[0] = i;
                int j=i+1;
                for (j = i+1; j < nums.length; j++) {
                    if(target!=nums[j]) {
                        startingAndEndingIndicesOfTarget[1] = j-1;
                        break;
                    }
                }
                if(j==nums.length&&nums[j-1]==target)
                    startingAndEndingIndicesOfTarget[1]=nums.length-1;
                break;
            }



        }
        return found?startingAndEndingIndicesOfTarget:new int[]{-1,-1};

    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,8};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }
}
