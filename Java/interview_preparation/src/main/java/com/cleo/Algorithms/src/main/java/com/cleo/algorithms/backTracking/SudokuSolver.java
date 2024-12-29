package com.cleo.algorithms.backTracking;

import java.util.ArrayList;

public class SudokuSolver {

    public boolean isSafe(ArrayList<ArrayList<Integer>> board, int row, int col, int n, int N){
        for (int i = 0; i < N; i++) {
            if(board.get(row).get(i)==n||board.get(i).get(col)==n)
                return false;
        }
        int grid1= (int)(Math.sqrt(N));
        int rs = row - row % grid1;
        int cs = col - col % grid1;
        for (int i = 0; i < grid1; i++) {
            for (int j = 0; j < grid1; j++) {
                if (board.get(i + rs).get(j + cs) == n)
                    return false;
            }

        }
        return true;


    }

    public boolean solve(ArrayList<ArrayList<Integer>> board, int N){
        int row=0,col=0;
        boolean isEmpty=false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board.get(i).get(j)==0){
                    row=i;col=j;
                    isEmpty=true;
                    break;
                }
            }
            if(isEmpty)
                break;
        }
        if(!isEmpty)
            return true;

        for (int i = 1; i <= N; i++) {
            if(isSafe(board,row,col,i,N)){
                board.get(row).set(col,i);
                if(solve(board,N))
                    return true;
                else
                    board.get(row).set(col,0);
            }
        }
            return false;
    }

    public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
        // Write your code here.
       solve(board,board.size());
       return board;
    }

    public static void main(String[] args) {

    }
}
