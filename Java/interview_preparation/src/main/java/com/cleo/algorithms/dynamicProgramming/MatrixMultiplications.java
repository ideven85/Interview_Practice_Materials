package com.cleo.algorithms.dynamicProgramming;

import java.util.*;
//LeetCode Hard Problem
//https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/
public class MatrixMultiplications {
    public static int maximumScore(int[] nums, int[] multipliers) {



        int n = nums.length;
        int m = multipliers.length;


        int score1=0,score2=0;
        int[][] dp = new int[m+1][m+1];

        for (int i = m-1; i >=0 ; i--) {
            for (int left = i; left >=0 ; left--) {
                int mult = multipliers[i];
                dp[i][left]=Math.max(nums[left]*mult+dp[i+1][left+1],
                        mult*nums[ n-1-(i-left)]+dp[i+1][left]);

            }

        }
        return dp[0][0];
    }

    private int[][] memo;
    private int[] nums,multipliers;
    private int n,m;


        private int dp(int i, int left){
        if(i==m)
            return 0;
        int mult=multipliers[i];
        int right= (n-1-(i-left));
        if(memo[i][left]==0)
            memo[i][left]=Math.max(mult*this.nums[left]+dp(i+1,left+1),
                    mult*nums[right]+dp(i+1,left));

        return memo[i][left];

    }
    public  int maximumScoreV2(int[] nums, int[] multipliers){
        int n = nums.length;
        int m = multipliers.length;
        this.n=n;
        this.m = m;
        this.nums=nums;
        this.multipliers=multipliers;
        this.memo = new int[m][m];
        return dp(0,0);


    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int[] multipliers = new int[]{3,2,1};
        System.out.println(maximumScore(nums,multipliers));
        MatrixMultiplications mm = new MatrixMultiplications();
        System.out.println(mm.maximumScoreV2(nums,multipliers));
    }

}
