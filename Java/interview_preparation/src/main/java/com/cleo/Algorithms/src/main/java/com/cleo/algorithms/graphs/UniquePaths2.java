package com.cleo.algorithms.graphs;

public class UniquePaths2 {
    /**
     *
     * @param obstacleGrid obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]] 1 denotes the obstacle
     * @return number of ways in which robot can move to the right bottom avoiding the paths with obstacles
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1)
            return 0;
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            if(dp[i][0]!=1)
                dp[i][0]=1;

        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(obstacleGrid[i][j]!=1)
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[n-1][m-1];
    }
}
