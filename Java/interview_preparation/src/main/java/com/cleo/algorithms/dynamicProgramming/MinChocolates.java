package com.cleo.algorithms.dynamicProgramming;

import java.util.Arrays;
//Do again
public class MinChocolates {
    public static int getMin(int arr[], int N) {
        int[] dp = new int[N];
        boolean first = true;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                if (first) {
                    dp[i] = 1;
                    first = false;
                }
                dp[i + 1] = dp[i] + 1;
            } else first = true;
           // System.out.println(Arrays.toString(dp));

        }
      //  System.out.println(Arrays.stream(dp).sum());
        first = true;

        for (int i = N - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                if (first) {
                    dp[i] = 1;
                    first = false;
                }
                if (dp[i - 1] != 0)
                    dp[i - 1] = Math.max(dp[i - 1], 1 + dp[i]);
                else
                    dp[i - 1] = 1 + dp[i];
            }
          //  System.out.println(Arrays.toString(dp));

        }
       // System.out.println(Arrays.toString(dp));

        return Arrays.stream(dp).sum();
    }

    public static void main(String[] args) {
        int[] chocolates = {1,4,4,6};
        int N = 4;
        System.out.println(getMin(chocolates,N));
    }
}
