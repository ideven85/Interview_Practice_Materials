package com.cleo.algorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
 *
 * An island is a "4-directionally connected group of 1's" not connected to any other 1's. There are exactly two islands in grid.
 *
 * You may change 0's to 1's to connect the two islands to form one island.
 *
 * Return the smallest number of 0's you must flip to connect the two islands.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[0,1],[1,0]]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * Example 3:
 *
 * Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 */
public class ShortestBridge {

    static class Point{
        int row,column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
    private int[][] grid;
    private int rows,columns;
    List<Point> island1 = new ArrayList<>();
    List<Point> island2 = new ArrayList<>();
    public int shortestBridge(int[][] grid) {

        this.grid=grid;
        int n = grid.length,m=grid[0].length;
        rows=n;columns=m;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]==1) {
                    if(island1.isEmpty()) {
                        //island1.add(new Point(i, j));
                        findIsland(i, j, visited,island1);
                    }else
                        findIsland(i,j,visited,island2);
                }
            }

        }
        //Finding Shortest Number of points which are 0

        for(var row:visited)
            System.out.println(Arrays.toString(row));
        return -1;

    }
    private void findIsland(int row, int column,boolean[][] visited,List<Point> island1){
        if(visited[row][column])
            return;
        visited[row][column]=true;
        island1.add(new Point(row,column));
        if(row+1<rows&&grid[row+1][column]==1){
            findIsland(row+1,column,visited,island1);
        }
        if(column+1<columns&&grid[row][column+1]==1)
            findIsland(row,column+1,visited,island1);
        if(row>0&&grid[row-1][column]==1)
            findIsland(row-1,column,visited,island1);
        if(column>0&&grid[row][column-1]==1)
            findIsland(row,column-1,visited,island1);


    }

    public static void main(String[] args) {
        int[][] island={{0,1},{1,0}};
        ShortestBridge bridge = new ShortestBridge();
        System.out.println(bridge.shortestBridge(island));
    }
}
