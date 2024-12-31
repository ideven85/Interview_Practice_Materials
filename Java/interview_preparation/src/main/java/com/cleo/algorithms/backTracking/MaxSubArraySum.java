package com.cleo.algorithms.backTracking;

public class MaxSubArraySum {
  static   long maxSubarraySum(int arr[], int n){

        // Your code here
        long curr=0,max=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            curr+=arr[i];
            if(max<=curr)
                max=curr;
            if(curr<0)
                curr=0;
        }
        return max;

    }

    public static void main(String[] args) {
        int[] arr = {-10,-4,-2,-3};
        System.out.println(maxSubarraySum(arr,arr.length));
    }
}
