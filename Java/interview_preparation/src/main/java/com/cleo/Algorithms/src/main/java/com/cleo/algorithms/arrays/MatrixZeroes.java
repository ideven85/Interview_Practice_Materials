package com.cleo.algorithms.arrays;

import java.util.Arrays;

public class MatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] makeRowZero = new boolean[n];
        boolean[] makeColZero = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j]==0) {
                    makeRowZero[i] = true;
                    makeColZero[j]=true;
                }

            }
        }
        for (int i = 0; i < n; i++) {
            if(makeRowZero[i]) makeRowsZero(matrix,i);
        }
        for (int i = 0; i < m; i++) {
            if(makeColZero[i]) makeColsZero(matrix,i);
        }

    }
    public void  makeRowsZero(int[][] matrix, int row){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(i==row)
                    matrix[i][j]=0;
            }
        }
    }
    public void  makeColsZero(int[][] matrix, int col){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(j==col)
                    matrix[i][j]=0;
            }
        }
    }

    public static void main(String[] args) {
        MatrixZeroes matrix = new MatrixZeroes();
        int[][] mat = new int[][]{
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        matrix.setZeroes(mat);
        for(var row: mat){
            System.out.println(Arrays.toString(row));
        }

    }
}
