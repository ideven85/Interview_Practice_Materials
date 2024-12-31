package com.cleo.algorithms.backTracking;

public class PrintRatMazePaths {
    static void ratInAMaze(int[][] maze, int n) {
        int[][] paths = new int[n][n];
        solveAndPrintMaze(maze,0,0,paths,n);


    }
    static boolean solveAndPrintMaze(int[][] maze, int row, int column, int[][] paths, int n){
        if(row<0||row>=n||column<0||column>=n||maze[row][column]==0||paths[row][column]==1)
            return false;
        paths[row][column]=1;
        boolean pathPossible=false;
        if(row==n-1&&column==n-1){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(paths[i][j]+" ");
                }
            }
            System.out.println();
            paths[row][column]=0;
            return true;
        }
        if(solveAndPrintMaze(maze,row+1,column,paths,n))
            pathPossible=true;
        if(solveAndPrintMaze(maze,row,column+1,paths,n))
            pathPossible=true;
        if(solveAndPrintMaze(maze,row-1,column,paths,n))
            pathPossible=true;
        if(solveAndPrintMaze(maze,row,column-1,paths,n))
            pathPossible=true;
        paths[row][column]=0;
        return pathPossible;
    }

    public static void main(String[] args) {
        int[][] board={
                {1,1,0},
                {1,1,0},
                {1,1,1}

        };
        int N = board.length;
        ratInAMaze(board,N);
    }
}
