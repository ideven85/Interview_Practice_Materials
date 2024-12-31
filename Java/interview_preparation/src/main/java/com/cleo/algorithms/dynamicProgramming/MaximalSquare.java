package com.cleo.algorithms.dynamicProgramming;

import java.util.Arrays;

public class MaximalSquare {

    private char[][] matrix;
    private int[][] max_square;
    int m,n;
    private int dp(int row,int column){
        if(row==0&&column==0)
            return max_square[0][0];
        int value1=0,value2=0,value3=0;
        if(row>0&&column>0) {
            value1 = max_square[row - 1][column];
            value2 = max_square[row][column - 1];
            value3 = max_square[row - 1][column - 1];

            if (value3 == 1 && value1 == 1 && value2 == 1)//2*2+2*2+1=9
                max_square[row][column] = 3 + dp(row - 1, column - 1);
        }

        return -1;


    }
    public int maximalSquare(char[][] matrix) {
       int m=matrix.length;
       int n=matrix[0].length;
       int[][] max_square=new int[m+1][n+1];
       int max=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]=='1') {
                    max_square[i + 1][j + 1] = Math.min(max_square[i][j],
                            Math.min(max_square[i + 1][j], max_square[i][j + 1])) + 1;
                    max=Math.max(max,max_square[i+1][j+1]);
                }

            }
        }
        /*for (int row = m-1; row >=0 ; row--) {
            for (int col = n-1; col >=0 ; col--) {
                if(max_square[row][col]==0)
                    continue;
                if(row>0&&col>0)
                    if(max_square[row-1][col-1]==1&&max_square[row][col-1]==1&&max_square[row-1][col]==1)
                            max_square[row-1][col-1]=3+max_square[row][col];
                    else
                        max_square[row-1][col-1]=Math.max(max_square[row][col],
                            Math.max(max_square[row-1][col],max_square[row][col-1]));

            }
        }
*/

       /* for(var row:max_square) {
            System.out.println(Arrays.toString(row));

        }*/
        return max*max;

    }

    public static void main(String[] args) {
       char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
       char[][] m1 = {{'1','0'},{'1','0'}};
       MaximalSquare maximalSquare = new MaximalSquare();
        System.out.println(maximalSquare.maximalSquare(matrix));
        System.out.println(maximalSquare.maximalSquare(m1));

    }
}
class SolutionMaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int maxsqlen = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    int sqlen = 1;
                    boolean flag = true;
                    while (sqlen + i < rows && sqlen + j < cols && flag) {
                        for (int k = j; k <= sqlen + j; k++) {
                            if (matrix[i + sqlen][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = i; k <= sqlen + i; k++) {
                            if (matrix[k][j + sqlen] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag)
                            sqlen++;
                    }
                    if (maxsqlen < sqlen) {
                        maxsqlen = sqlen;
                    }
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
}