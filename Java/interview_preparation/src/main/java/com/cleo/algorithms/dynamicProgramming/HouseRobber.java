package com.cleo.algorithms.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * Learning DP=> Robber must loot maximum sum except he cannot rob adjacent houses
 */
public class HouseRobber {
 private     int[] nums;
    private final Map<Integer,Integer> memo = new HashMap<>();
    private  int dp( int n){
        if(n==0)
            return nums[0];
        else if(n==1)
            return Math.max(nums[0],nums[1]);
        else if(!memo.containsKey(n))
            memo.put(n,Math.max(dp(n-1),nums[n-2]+dp(n-2)));
        return memo.get(n);
    }
    public  int rob(int[] nums) {
        /*int previous=0,current=0;
        for(int num:nums){
            int temp=current;

            current=Math.max(current,previous+num);
            previous=temp;
        }
        return current;*/
        this.nums=nums;
        return dp(nums.length-1);

    }

    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        System.out.println(new HouseRobber().rob(nums));
    }
}