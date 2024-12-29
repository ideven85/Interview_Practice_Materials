package com.cleo.algorithms.dynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0]=1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(nums[j]<nums[i]&&dp[i]<dp[j]+1)
                    dp[i]=dp[j]+1;
            }
          //  dp[i]++;
        }
        System.out.println(Arrays.toString(dp));
        return Arrays.stream(dp).max().getAsInt();



    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
