package com.cleo.algorithms.dynamicProgramming;

import java.util.Arrays;

public class MinCoinsForChange {

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Write your code here.
        int size= denoms.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        int toCompare=0;
        for(int denom:denoms){
            for (int i = 0; i < dp.length; i++) {
                if(denom<=i) {
                    if(dp[i-denom]==Integer.MAX_VALUE)
                        toCompare=Integer.MAX_VALUE;
                    else
                        toCompare=dp[i-denom]+1;
                    dp[i]=Math.min(dp[i],toCompare);
                    System.out.println(Arrays.toString(dp));

                }
            }

        }
        return dp[dp.length-1]==Integer.MAX_VALUE?-1:dp[dp.length-1];
    }


    public long minimumNumberOfCoins(int[] coins,int numberOfCoins,int value)
    {
        // your code here
        int[] dp = new int[value+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        int toCompare=0;
        for(int denom:coins){
            for (int i = 0; i < dp.length; i++) {
                if(denom<=i) {
                    if(dp[i-denom]==Integer.MAX_VALUE)
                        toCompare=Integer.MAX_VALUE;
                    else
                        toCompare=dp[i-denom]+1;
                    dp[i]=Math.min(dp[i],toCompare);
                 //   System.out.println(Arrays.toString(dp));

                }
            }

        }
        return dp[dp.length-1]==Integer.MAX_VALUE?-1:dp[dp.length-1];

    }

    public static void main(String[] args) {
        int[] demoms = {3,6,3};
        int n = 5;
        System.out.println(minNumberOfCoinsForChange(n,demoms));

    }
}
