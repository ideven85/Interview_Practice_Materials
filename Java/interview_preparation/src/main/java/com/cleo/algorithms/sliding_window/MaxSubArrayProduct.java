package com.cleo.algorithms.sliding_window;

public class MaxSubArrayProduct {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)
            return 0;
        int left=0,curr=1,ans=0;
        for (int right = 0; right < nums.length; right++) {
            curr*=nums[right];
            while(left<=right&&curr>=k){
                curr/=nums[left];
                left++;
            }
            ans+=right-left+1;
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        MaxSubArrayProduct product = new MaxSubArrayProduct();
        System.out.println(product.numSubarrayProductLessThanK(nums,k));
    }
}
