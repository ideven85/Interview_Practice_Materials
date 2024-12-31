package com.cleo.algorithms.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {


    public boolean isValidSudoku(int[][] board) {
        Set<String> seen = new HashSet<>();
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int ch = board[i][j];
                //System.out.println(seen);

                if (board[i][j] != 0)
                    if(!seen.add(ch + "r" + i) || !seen.add(ch + "c" + j) || !seen.add(ch + "box" + i / 3 + "-" + j / 3)) {
                    return false;
                }

            }
        }


        return true;

    }

    public static void main(String[] args) {
        int[][] board = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        char c= (char) ((9)+48) ;
        System.out.println(c);
        ValidSudoku isValiid = new ValidSudoku();
        System.out.println(isValiid.isValidSudoku(board));


    }
}







