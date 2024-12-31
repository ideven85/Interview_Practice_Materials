package com.cleo.algorithms.backTracking;

public class MazeProblem {
    public static boolean ratInAMaze(int[][] maze){
        int N = maze.length;
        int[][] visited = new int[N][N];
        return solveMaze(maze,0,0,visited,N);
    }

    private static boolean isSafe(int[][] board, int row, int column){
        return row<board.length&&column<board.length&&board[row][column]==1;
    }
    private static boolean solveMaze(int[][] maze, int row, int column, int[][] visited,int N){
        if(row==N-1&&column==N-1&&maze[row][column]==1){
            visited[row][column]=1;
            return true;
        }
        if(isSafe(maze,row,column)){
            visited[row][column]=1;
            if(solveMaze(maze,row+1,column,visited,N))
                return true;
            if(solveMaze(maze,row,column+1,visited,N))
                return true;
            if(row>0&&solveMaze(maze,row-1,column,visited,N))
                return true;
            visited[row][column]=0;
        }

        return false;

    }
}
