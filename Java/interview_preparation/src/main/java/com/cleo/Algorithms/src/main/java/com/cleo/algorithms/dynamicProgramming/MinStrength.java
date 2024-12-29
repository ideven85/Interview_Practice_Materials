package com.cleo.algorithms.dynamicProgramming;

import java.util.Arrays;

public class MinStrength {
    public static int getMinimumStrength(int[][] grid) {

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        int n=grid.length,m=grid[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);
        dp[n-1][m-1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (dp[i][j] == Integer.MAX_VALUE) {
                    int right = Integer.MAX_VALUE, down = Integer.MAX_VALUE;
                    if (i + 1 < n)
                        right = dp[i + 1][j] - grid[i + 1][j];
                    if (j + 1 < m)
                        down = dp[i][j + 1] - grid[i][j + 1];
                    int ans = Math.min(right, down);
                    if (ans <= 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = ans;
                }
            }
        }
        for(var row:dp)
            System.out.println(Arrays.toString(row));
        return dp[0][0];

    }

    public static void main(String[] args) {
        //3 4
        //3 4 1 2
        //2 1 8 9
        //4 7 8 1
        int[][] grid1={{0,1,-3},{1,-2,0}};
        int[][] grid ={{0,-2,-3,1},{-1,4,0,-2},{1,-2,-3,0}};
        System.out.println(getMinimumStrength(grid));
        System.out.println(getMinimumStrength(grid1));
    }

}
