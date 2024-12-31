package com.cleo.algorithms.backTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * List all boards with non-attacking queen positions for a given board size
 *
 */
public class NQueens {
    int output;
    List<List<String>> boards = new ArrayList<>();

    public void initializeBoard(String[][] board, int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]=".";
            }
        }
    }


    public int totalNQueens(int n) {
        Set<Integer> diagonal = new HashSet<>();
        Set<Integer> antiDiagonal = new HashSet<>();
        Set<Integer> vertical = new HashSet<>();
        Set<Integer> horizontal = new HashSet<>();
        fndAllQueenPositions(n, 0, diagonal, antiDiagonal, vertical, horizontal);
        return output;
    }

    public boolean fndAllQueenPositions(int n, int queenRow,
                                        Set<Integer> diagonal, Set<Integer> antiDiagonal,
                                        Set<Integer> vertical, Set<Integer> horizontal) {
        if (queenRow == n) {
            return true;
        }

        for (int column = 0; column < n; column++) {

            //queen is in danger
            if (diagonal.contains(queenRow - column) ||
                    antiDiagonal.contains(queenRow + column) ||
                    vertical.contains(column) || horizontal.contains(queenRow)) {

                continue;
            }

            //place the queen by marking diagonals, vertical and horizontal row into danger list
            vertical.add(column);
            horizontal.add(queenRow);
            diagonal.add(queenRow - column);
            antiDiagonal.add(queenRow + column);

            boolean foundPath = fndAllQueenPositions(n, queenRow + 1, diagonal, antiDiagonal,
                    vertical, horizontal);

            if(foundPath){
                output = output+1;
            }

            vertical.remove(column);
            horizontal.remove(queenRow);
            diagonal.remove(queenRow - column);
            antiDiagonal.remove(queenRow + column);
        }

        return false;
    }


    public boolean isSafe(String[][] board, int row, int col, int n){
        for (int i = 0; i < n; i++) {
            if(board[row][i].equals("Q"))
                return false;
            if(board[i][col].equals("Q"))
                return false;
        }
        return true;
    }
//todo
    public boolean solve(String[][] board, int n){
        int row=0,col=0;
        boolean solved = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j].equals(".")){
                    row=i;
                    col=j;
                    solved=false;
                    break;
                }
            }
            if(!solved)
                break;
        }
        if(solved)
            return true;
        for (int i = 0; i < n; i++) {
            if(isSafe(board,row,col,n)){
                board[row][col]="Q";
                if(solve(board,n))
                    return true;
                board[row][col]=".";
            }
        }
        return true;
    }

    public List<List<String>> solveNQueens(int n) {

        solveNQueens(n);
        String[][] board = new String[n][n];
        initializeBoard(board,n);
        solve(board, n);
        return boards;

    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(4));

    }

}
