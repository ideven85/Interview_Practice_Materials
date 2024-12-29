package com.cleo.algorithms.graphs.dfs;


import java.util.ArrayList;
import java.util.List;

// TODO: 11/08/23 Not used Depth First Search Correctly
public class RiverSizes  {
    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        List<Integer> output = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if(visited[row][col])
                    continue;
                if(matrix[row][col]==1) {
                    int con = dfsOfConnectedCells(matrix, row, col, visited, 0);
                    if(con!=0)
                        output.add(con);
                }

            }
        }


        return output;
    }

    // TODO: 05/08/23  Correct the code
    public static int dfsOfConnectedCells(int[][] matrix, int row, int col, boolean[][] visited,int count){
        Point p = new Point(row,col);
        visited[row][col]=true;
        List<Point> connections = new ArrayList<>();
        if(row-1>0&&!visited[row-1][col])
            connections.add(new Point(row-1,col));
        if(col-1>0&&!visited[row][col-1])
            connections.add(new Point(row,col-1));
        if(row+1< matrix.length&&!visited[row+1][col])
            connections.add(new Point(row+1,col));
        if(col+1<matrix[row].length&&!visited[row][col+1])
            connections.add(new Point(row,col+1));
        for(Point connection:connections){
            int connectedRow=connection.x;
            int connectedCol=connection.y;
            if(visited[connectedRow][connectedCol])
                continue;
            visited[connectedRow][connectedCol]=true;
            if(matrix[connectedRow][connectedCol]==1)
                return 1+dfsOfConnectedCells(matrix, connectedRow, connectedCol, visited, ++count);
        }
        return count;


    }

    public static void main(String[] args) {

int[][]   matrix = new int[][]{
        {1, 0, 0, 1, 0},
        {1, 0, 1, 0, 0},
            {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                    {1, 0, 1, 1, 0}
                    };
        System.out.println(riverSizes(matrix));

    }
}
