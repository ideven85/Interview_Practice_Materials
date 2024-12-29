package com.cleo.algorithms.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class SolveNQueens {
    public static void placeNQueens(int n){

        /* Your class should be named Solution.
         * Don't write main() function.
         * Don't read input, it is passed as function argument.
         * Print output as specified in the question
         */
        int[][] board = new int[n][n];
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        recurse(board,0,res);



    }
    private static void recurse(int[][] board, int colIndex,List<List<Integer>> res){
        if(colIndex==board.length){
            res=construct(board);
            for(List<Integer> row:res){
                for(int r:row){
                    System.out.print(r+" ");
                }
            }
            System.out.println();
            return;

        }
        for (int i = 0; i < board.length; i++) {
            if(validate(board,i,colIndex)){
                board[i][colIndex]=1;
                recurse(board,colIndex+1,res);
                board[i][colIndex]=0;
            }
        }

    }
    private static boolean validate(int[][] board, int x, int y){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                if(board[i][j]==1&&(x+j==y+i||x+y==i+j||x==i))
                    return false;
            }

        }
        return true;
    }
    private static List<List<Integer>> construct(int[][] board){
        List<List<Integer>> res = new LinkedList<>();
        for(int[] b:board){
            List<Integer> temp=new LinkedList<>();
            for(int x:b){
                temp.add(x);
            }
            res.add(temp);
        }
        return res;

    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(board, 0, res);
        return res;
    }

    private void dfs(char[][] board, int colIndex, List<List<String>> res) {
        if(colIndex == board.length) {
            res.add(construct(board));
            return;
        }

        for(int i = 0; i < board.length; i++) {
            if(validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, res);
                board[i][colIndex] = '.';
            }
        }
    }

    private boolean validate(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < y; j++) {
                if(board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for (char[] chars : board) {
            String s = new String(chars);
            res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        placeNQueens(5);
    }
}
