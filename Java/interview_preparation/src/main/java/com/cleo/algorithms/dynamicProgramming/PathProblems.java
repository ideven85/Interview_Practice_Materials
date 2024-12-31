package com.cleo.algorithms.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PathProblems {

    public static int uniquePaths(int m, int n) {
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

    }
    public static int minPathSum(int[][] grid) {
        /**
         * To Reach to the last block with minimum cost,
         * he has to choose minimum of either left or up
         */
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(i==0&&j>0)
                    dp[i][j]=grid[i][j]+dp[i][j-1];
                else if(i>0&&j==0)
                    dp[i][j]=grid[i][j]+dp[i-1][j];
                else if(i>0)
                    dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[grid.length-1][grid[0].length-1];

    }

    /**
     * //obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]] 2 ways
     * @param obstacleGrid robot located at top left has to reach bottom right 1 indicates obstacle
     * @return total number of ways
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows  = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        int[][] dp = new int[rows+1][columns+1];
        dp[rows-1][columns]=1;//Why this?
        for (int i = rows-1; i >=0 ; i--) {
            for (int j = columns-1; j >=0 ; j--) {
                dp[i][j]=obstacleGrid[i][j]==1?0:dp[i+1][j]+dp[i][j+1];
            }
        }
        for(var row:dp)
            System.out.println(Arrays.toString(row));

        return dp[0][0];

    }
    //Triangle->Next row has more than one element than previous
    public  static int minimumTotal(List<List<Integer>> triangle) {
    //    List<List<Integer>> dp = new ArrayList<List<Integer>>();
        int rows = triangle.size();
        if(rows==0)
            return 0;
        int sum=triangle.get(0).get(0);
        int position=0;
       /* for (int row = 1; row < rows; row++) {
            int first=triangle.get(row).get(position),second=triangle.get(row).get(position+1);
            if(first<second){
                sum+=first;
                dp.get(row).add(sum);
            }else{
                sum+=second;
                dp.get(row).add(sum);
                position+=1;

            }

        */
        int[][] grid = new int[rows][];
        int[][] dp = new int[rows][];
        for (int i = 1; i <= rows; i++) {
            grid[i-1]=new int[i];
            dp[i-1]=new int[i];
            for (int j = 0; j < i; j++) {
                grid[i-1][j]=triangle.get(i-1).get(j);
            }
        }

        for (int row = rows-1; row >0 ; row--) {
            int min=0;
            for (int col = 0; col < row-1; col++) {
                int first=grid[row][col]+grid[row-1][position];
                int second=grid[row][col]+grid[row-1][position+1];
                if(first<second){
                    min=first;
                    position=col;
                }else{
                    min=second;
                    position=col+1;
                }
                if(dp[row][col+1]+min<dp[row][col])
                    dp[row][col]=dp[row][col+1]+min;
                else
                    dp[row][col]=dp[row][col+1];
            }

        }












        return sum;


    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
        //grid = [[1,3,1],[1,5,1],[4,2,1]]
        int[][] grid = {{1,2,3},{4,5,6}};
        System.out.println(minPathSum(grid));
        //obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]] 2 ways
        int[][] obstacleGrid ={{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
        List<List<Integer>> triangle= Arrays.asList(Arrays.asList(2),Arrays.asList(3,4),Arrays.asList(6,5,7),Arrays.asList(4,1,8,3));



        System.out.println(minimumTotalV2(triangle));

    }
    public static int minimumTotalV2(List<List<Integer>> triangle) {
        for (int row = triangle.size() - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                int bestBelow = Math.min(
                        triangle.get(row + 1).get(col),
                        triangle.get(row + 1).get(col + 1));
                triangle.get(row).set(col, bestBelow + triangle.get(row).get(col));
            }
        }
        return triangle.get(0).get(0);
    }
    public int minimumTotalV3(List<List<Integer>> triangle) {
        List<Integer> belowRow = triangle.get(triangle.size() - 1);
        for (int row = triangle.size() - 2; row >= 0; row--) {
            List<Integer> currRow = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                int bestBelow = Math.min(belowRow.get(col), belowRow.get(col + 1));
                currRow.add(bestBelow + triangle.get(row).get(col));
            }
            belowRow = currRow;
        }
        return belowRow.get(0);
    }

}
class SolutionPath {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> prevRow = triangle.get(0);
        for (int row = 1; row < triangle.size(); row++) {
            List<Integer> currRow = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                int smallestAbove = Integer.MAX_VALUE;
                if (col > 0) {
                    smallestAbove = prevRow.get(col - 1);
                }
                if (col < row) {
                    smallestAbove = Math.min(smallestAbove, prevRow.get(col));
                }
                currRow.add(smallestAbove + triangle.get(row).get(col));
            }
            prevRow = currRow;
        }
        return Collections.min(prevRow);
    }
}