package com.cleo.algorithms.arrays;

import java.util.Arrays;

public class MaximiseProfit {
    public static int maxProfit(int[] prices) {
        int current_minimum = Integer.MAX_VALUE;
        int max = 0;
        int difference = 0;

        for (int price : prices) {
            if (price < current_minimum) {
                current_minimum= price;
            }
            difference = price -current_minimum;
            if (max < difference) {
                max = difference;
            }
        }
        return max;
    }
    public int maxProfitV2(int[] prices) {
        int min = prices[0];
        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i=1;i<n;i++){
            min = Math.min(min, prices[i]);
            int profit = Math.max(dp[i-1], prices[i] - min);
            dp[i] = profit;
        }
        return dp[n-1];
    }


    //todo
    public int maxProfitLevel2(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        return 0;

    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
