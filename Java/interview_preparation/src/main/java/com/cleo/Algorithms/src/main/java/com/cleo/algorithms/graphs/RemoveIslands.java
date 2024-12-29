package com.cleo.algorithms.graphs;

import java.util.*;

public class RemoveIslands {

    public int[][] removeIslands(int[][] matrix) {
        // Write your code here.
        System.out.println(matrix[1][4]);
        int n = matrix.length;
        int m = matrix[0].length;
        int row=0,col=0;
        boolean[][] seen = new boolean[n][m];

        for (row = 0; row < n; row++) {
            for  (col = 0; col < m; col++) {
                boolean rowIsBorder=row==0||row==n-1;
                boolean colIsBorder=col==0||col==m-1;

                if(rowIsBorder||colIsBorder){
                    if(matrix[row][col]==1){

                       // seen[row][col]=true;
                        dfsOfNeighbours(matrix,row,col,seen);
                    }

                }
            }
            for (int i = 1; i < matrix.length-1; i++) {
                for (int j = 1; j < matrix[i].length-1; j++) {
                    if(seen[i][j])
                        continue;
                    matrix[i][j]=0;
                }
            }

        }
        for(var r:seen)
            System.out.println(Arrays.toString(r));
        return matrix;
    }
    public void dfsOfNeighbours(int[][] matrix, int row, int col,boolean[][] seen){

        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{row,col});
        while(!queue.isEmpty()){
            var current = queue.poll();
            int curRow = current[0];
            int curCol = current[1];
            if(seen[curRow][curCol])
                continue;

         //   System.out.println(curRow+":"+curCol);

            seen[curRow][curCol]=true;
            List<Integer[]> adjacent = getAdjacent(matrix,curRow,curCol,seen);
            for(var adj:adjacent){
                int r=adj[0],c=adj[1];
                System.out.println(r+":"+c+"->"+matrix[r][c]);
                //System.out.println(r+":"+c);

                if(matrix[r][c]==1) {

                    queue.add(new Integer[]{r, c});
                }
            }
        }

    }
    public List<Integer[]> getAdjacent(int[][] matrix, int row, int col, boolean[][] seen){
        List<Integer[]> adjacents = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[row].length;
        if(row+1<n)
            adjacents.add(new Integer[]{row+1,col});
        if(row>0)
            adjacents.add(new Integer[]{row-1,col});
        if(col+1<m)
            adjacents.add(new Integer[]{row,col+1});
        if(col>0)
            adjacents.add(new Integer[]{row,col-1});
        return adjacents;
    }

    public static void main(String[] args) {
        //[
        //  [1, 0, 0, 0, 0, 0],
        //  [0, 1, 0, 1, 1, 1],
        //  [0, 0, 1, 0, 1, 0],
        //  [1, 1, 0, 0, 1, 0],
        //  [1, 0, 1, 1, 0, 0],
        //  [1, 0, 0, 0, 0, 1]
        //]
        int[][] matrix = new int[][]{
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1}
        };
        System.out.println(matrix[1][4]);
        matrix=new RemoveIslands().removeIslands(matrix);
        for(var row:matrix)
            System.out.println(Arrays.toString(row));
    }
}
