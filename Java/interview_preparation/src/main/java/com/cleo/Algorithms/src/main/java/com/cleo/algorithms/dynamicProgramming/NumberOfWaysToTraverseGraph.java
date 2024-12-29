package com.cleo.algorithms.dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOfWaysToTraverseGraph {
    public int numberOfWaysToTraverseGraph(int m, int n) {
        /*
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0&&j>0)
                    dp[i][j]=1;
                else if(i>0&&j==0)
                    dp[i][j]=1;
                else if(i>0)
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];

            }

        }

        return dp[m-1][n-1];

         */
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0],1);//First Row

        //First Column
        for (int i = 0; i < m; i++) {
            dp[i][0]=1;
        }
        //Rest Cells
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];




    }
   private int uniquePathsRecursive(int x, int y, int m, int n, int[][] memo) {
        // If we reach the destination (bottom-right corner), return 1
        if (x == m - 1 && y == n - 1) {
            return 1;
        }

        // If we have already computed the result for this cell, return it from the memo table
        if (memo[x][y] != -1) {
            return memo[x][y];
        }

        // Calculate the number of unique paths by moving right and down
        int rightPaths = 0;
        int downPaths = 0;

        // Check if it's valid to move right
        if (x < m - 1) {
            rightPaths = uniquePathsRecursive(x + 1, y, m, n, memo);
        }

        // Check if it's valid to move down
        if (y < n - 1) {
            downPaths = uniquePathsRecursive(x, y + 1, m, n, memo);
        }

        // Store the result in the memo table and return it
        memo[x][y] = rightPaths + downPaths;
        return memo[x][y];
    }
    public int numberOfWaysToTraverseGraphV2(int m, int n) {
        /*if(m==1||n==1)
            return 1;//First Row or First Column
        else
            //Remaining Cells
            return numberOfWaysToTraverseGraphV2(m-1,n)+numberOfWaysToTraverseGraphV2(m,n-1);

         */
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return uniquePathsRecursive(0,0,m,n,memo);

    }

        public static void main(String[] args) {
        System.out.println(new NumberOfWaysToTraverseGraph().numberOfWaysToTraverseGraph(3,7));
            System.out.println(new NumberOfWaysToTraverseGraph().numberOfWaysToTraverseGraphV2(3,7));
    }
}