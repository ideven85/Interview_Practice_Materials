package com.cleo.algorithms.sliding_window;

public class MaxSubArray {

    public int findLength(int[] nums, int k) {
        int left=0,right=0,ans=0,curr=0;
        for (right = 0; right < nums.length; right++) {
            curr+=nums[right];
            while(curr>k){
                curr-=nums[left];
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 7, 4, 2, 1, 1, 5};
        int target = 8;
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.findLength(nums,target));
    }
}