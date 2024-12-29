package com.cleo.algorithms.arrays;

import java.util.Arrays;

public class RotateArray {
    public static void rotate(int[] nums, int k) {

        int n = nums.length-1;
        if(n==0)
            return;
        int rotations = k%(n+1);







    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums,8);
        System.out.println(Arrays.toString(nums));
    }
}
