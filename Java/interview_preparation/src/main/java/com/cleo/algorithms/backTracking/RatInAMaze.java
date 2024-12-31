package com.cleo.algorithms.backTracking;

import java.util.ArrayList;

public class RatInAMaze {
    private static final ArrayList<String> path = new ArrayList<>();
    public static boolean ratCanReachDestination(int[][] board, int N){
        int[][] sol= new int[N][N];


        if(solveMaze(board,0,0,sol,N)) {
            //  printMaze(sol,N);
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean solveMaze(int maze[][], int i, int j, int path[][]){
        int n = maze.length;
        // Check if i,j cell is valid or not
        if(i  < 0 || i >= n || j < 0 || j >= n  || maze[i][j] == 0
                || 	path[i][j] == 1){
            return false;
        }
        // Include the cell in current path
        path[i][j] = 1;
        // Destination cell
        if(i == n - 1 && j == n - 1){
            path[i][j] = 0;
            return true;
        }

        // Explore further in all directions
        boolean pathPossible = false;
        // top
        if(solveMaze(maze, i - 1, j, path)){
            pathPossible = true;
        }
        // right
        else if(solveMaze(maze, i, j + 1, path)){
            pathPossible = true;
        }
        // Down
        else if(solveMaze(maze, i + 1 , j, path)){
            pathPossible = true;
        }
        // Left
        else if(solveMaze(maze, i, j - 1, path)){
            pathPossible = true;
        }
        return pathPossible;
    }
    public static boolean ratInAMaze(int[][] maze){
        int N = maze.length;
        int[][] visited= new int[N][N];

        return solveMaze(maze,0,0,visited,N);
    }
   /* private static boolean solveMazeV1(int[][] maze, int row, int col,int[][] visited,int N){
        if(row==N-1&&col==N-1&&maze[row][col]==N-1){
            visited[row][col]=1;
            return true;
        }
        if(row+1<N){
            if(visited[row+1][col]==0)
        }

    }*/
    static boolean isSafe(int[][] board, int i, int j, int N){
        boolean first=(i<N && j<N && board[i][j]==1);
        return first;
    }

    static boolean flag1 = false,flag2=false,flag3=false,flag4=false;

    static boolean solveMaze(int[][] board, int i, int j, int[][] sol, int N){
        if(i==N-1 && j==N-1 && board[i][j]==1) {
            sol[i][j]=1;

            return true;
        }



        if(isSafe(board,i,j,N)) {
            sol[i][j] = 1;

            if (i+1<N&&sol[i+1][j]==0&&solveMaze(board, i + 1, j, sol, N)) {
                flag1=true;
             //   path.add("R");
                return true;
            }
            if (j+1<N&&sol[i][j+1]==0&&solveMaze(board, i, j + 1, sol, N)) {
                flag2=true;
               // path.add("D");
                return true;
            }
            if(i>0&&sol[i-1][j]==0&&solveMaze(board,i-1,j,sol,N))
                return true;
            if(j>0&&sol[i][j-1]==0&&solveMaze(board,i,j-1,sol,N))
                return true;

            sol[i][j] = 0;
        }
        return false;
    }
    static void printMaze(int[][] board, int N){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] board={
                {1,0,0},
                {1,1,1},
                {1,0,1}

        };
        int N = board.length;
        System.out.println(ratCanReachDestination(board,N));
       // System.out.println(path);

    }
}
