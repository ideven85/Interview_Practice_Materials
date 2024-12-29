package com.cleo.algorithms.dynamicProgramming;

import java.util.*;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < m; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }

        }
        return dp[m-1][n-1];

    }
    private static class Point{
        int row,column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public Point() {
        }
    }


    // TODO: 26/08/23 "Correct the algorithm" 
    //A Star Algorithm
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        List<Point> paths = new ArrayList<>();
        Set<Point> failedPaths = new HashSet<>();
        boolean[][] grid = new boolean[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if(obstacleGrid[i][j]==0)
                    grid[i][j]=true;
            }
        }
        if(getPath(grid,obstacleGrid.length-1,obstacleGrid[0].length-1,paths,failedPaths)){

            return paths.size()-1;
        }
        return -1;

    }
    public boolean getPath(boolean[][] obstacleGrid, int row, int column, List<Point> paths,Set<Point> failedPoints){
        if(row<0||column<0||!obstacleGrid[row][column])
            return false;
        Point p = new Point(row,column);

        if(failedPoints.contains(p))
            return false;



        boolean isAtOrigin = row == 0 && column == 0;

        if(isAtOrigin||getPath(obstacleGrid,row,column-1,paths,failedPoints)||getPath(obstacleGrid,row-1,column,paths,failedPoints) ) {
            paths.add(p);
            return true;
        }


        failedPoints.add(p);
        return false;

    }

    public static void main(String[] args) {
        int m=4,n=3;
        UniquePaths up = new UniquePaths();
        System.out.println(up.uniquePaths(m,n));
        int[][] obstacleGrid = new int[][]{
                {0,0,0},
                {0,1,0},
                {0,1,0}
        };
        int[][] obstacleGrid1 = new int[][]{
                {0,1},
                {0,0}
        };
        System.out.println(up.uniquePathsWithObstacles(obstacleGrid));
        System.out.println(up.uniquePathsWithObstacles(obstacleGrid1));
    }
}
