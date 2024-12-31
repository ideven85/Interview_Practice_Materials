package com.cleo.algorithms.dynamicProgramming;

import java.util.Arrays;

public class MinCostPath {
    public static int minCostPath(int[][] input) {
        //Your code goes here
        int n=input.length;
        int m=input[0].length;
        int[][] dp = new int[n][m];
        dp[0][0]=input[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i==0&&j>0)
                    dp[i][j]=input[i][j]+dp[i][j-1];
                else if(i>0&&j==0)
                    dp[i][j]=input[i][j]+dp[i-1][j];
                else if(i>0)

                    dp[i][j]=input[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
       /* for(var row:dp)
            System.out.println(Arrays.toString(row));*/
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        //3 4
        //3 4 1 2
        //2 1 8 9
        //4 7 8 1
        int[][] grid ={{0,-2,-3,1},{-1,4,0,-2},{1,-2,-3,0}};
        System.out.println(minCostPath(grid));
    }
}
