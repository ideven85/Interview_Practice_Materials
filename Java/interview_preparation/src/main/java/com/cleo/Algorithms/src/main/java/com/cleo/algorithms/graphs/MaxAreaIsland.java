package com.cleo.algorithms.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxAreaIsland {

 private    static class Point{
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    int[][] grid;
    int rows,columns,max_size;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid=grid;
        int m = grid.length;
        int n = grid[0].length;
        this.rows=m;
        this.columns=n;
        int size=0;

        boolean[][] visited = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if(visited[row][col])
                    continue;
                if(grid[row][col]==1){
                   int curr_size=getArea(row,col,visited);
                   // if(curr_size!=0)
                  //      System.out.println(curr_size);
                    if(max_size<=curr_size)
                        max_size=curr_size;
                }
            }
        }
        return max_size;

    }
    private int getArea(int row, int col,boolean[][] visited){
        int size=0;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(row,col));
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            int currentRow = p.row;
            int currentCol = p.col;
            if (visited[currentRow][currentCol])
                continue;
            if(grid[currentRow][currentCol]==0)
                continue;
            visited[currentRow][currentCol] = true;

                size++;
                List<Point> connections = getAdjacents(currentRow, currentCol, visited);
                if(!connections.isEmpty())
                    for(Point connection:connections)
                        queue.offer(connection);


                }



        return size;
    }
    private List<Point> getAdjacents(int row,int col,boolean[][] visited){
        List<Point> connections = new ArrayList<>();
        if(row+1<rows&&!visited[row+1][col])
            connections.add(new Point(row+1,col));
        if(col+1<columns&&!visited[row][col+1])
            connections.add(new Point(row,col+1));
        if(row>0&&!visited[row-1][col])
            connections.add(new Point(row-1,col));
        if(col>0&&!visited[row][col-1])
            connections.add(new Point(row,col-1));
        return connections;
    }

    private int n, m;

    /**
     *
     *DFS Approach
     */
    public int maxAreaOfIslandV1(int[][] grid) {
        int ans = 0;
        n = grid.length;
        m = grid[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] > 0) ans = Math.max(ans, trav(i, j, grid));
        return ans;
    }
    /**
     * Less Space and Time Complexity
     * I should also use my head to solve these problems
     */

    private int trav(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] < 1) return 0;
        grid[i][j] = 0;//Author marked it as visited with very less space complexity
        return 1 + trav(i-1, j, grid) + trav(i, j-1, grid) + trav(i+1, j, grid) + trav(i, j+1, grid);
    }
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        MaxAreaIsland maxAreaIsland = new MaxAreaIsland();
        System.out.println(maxAreaIsland.maxAreaOfIsland(grid));

    }
}
