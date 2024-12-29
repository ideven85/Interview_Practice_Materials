package com.cleo.algorithms.graphs;

import java.util.Arrays;


public class MinCostPath {
    /**
     * //grid = [[1,3,1],[1,5,1],[4,2,1]]
     * @param cost Given a graph, where we can move down or right
     * @return the path with minimum sum from source to destination
     */
    public int minPathSum(int[][] cost) {
        int[][] T = new int[ cost.length][cost[0].length];
        int sum=0,max_sum=0;

        int M = cost.length,N = cost[0].length;
        int min=0;
        // fill the matrix in a bottom-up manner
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                T[i][j] = cost[i][j];

                // fill the first row (there is only one way to reach any cell
                // in the first row from its adjacent left cell)
                if (i == 0 && j > 0) {
                    T[0][j] += cost[0][j - 1];
                }

                // fill the first column (there is only one way to reach any cell
                // in the first column from its adjacent top cell)
                else if (j == 0 && i > 0) {
                    T[i][0] += cost[i - 1][0];
                }

                // fill the rest with the matrix (there are two ways to reach any
                // cell in the rest of the matrix, from its adjacent
                // left cell or adjacent top cell)
                else if (i > 0 && j > 0) {
                    T[i][j] += Integer.max(T[i - 1][j], T[i][j - 1]);
                }
                if(min>T[i][j])
                    min=T[i][j];
            }
        }
        for(var row:T)
            System.out.println(Arrays.toString(row));

        return Math.abs(T[M-1][N-1]);
    }
    public static void main(String[] args) {
        //0 -2 -3 1
        //-1 4 0 -2
        //1 -2 -3 0
        int[][] grid = {{9,4,9,9},{6,7,6,4},
                {8,3,3,7},{7,4,9,10}};
        MinCostPath minCostPath = new MinCostPath();
        System.out.println(minCostPath.minPathSum(grid));
    }
    
}
