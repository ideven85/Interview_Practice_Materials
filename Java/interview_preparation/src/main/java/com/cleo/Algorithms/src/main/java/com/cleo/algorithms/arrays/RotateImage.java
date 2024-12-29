package com.cleo.algorithms.arrays;

import java.util.Arrays;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int rows = matrix.length,columns=matrix[0].length;
        for (int i = 0; i < rows; i++) {
            //int temp = matrix[i][0];
            for (int j = i; j < columns; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }


        }

        //Reversing Rows Now
        for (int i = 0; i < rows; i++) {
            int li = 0;
            int rt = matrix[i].length-1;
            while(li<rt){
                int temp = matrix[i][li];
                matrix[i][li] = matrix[i][rt];
                matrix[i][rt]=temp;
                li++;
                rt--;

            }

        }


    }

    //Doubt To see

    /**
     *
     * Solution given in Cracking the Coding  Interview
     */
    public void rotateV2(int[][] matrix){
        int n = matrix.length;
        for (int layer = 0; layer <= n/2; layer++) {
            int first = layer,last = n-1-layer;
            for (int i = first; i < last; i++) {
                int offset = i-first;
                int top = matrix[first][i];
                matrix[first][i]=matrix[last-offset][first];
                matrix[last-offset][first]=matrix[last][last-offset];
                matrix[last][last-offset]=matrix[i][last];
                matrix[i][last]=top;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {       {1,2,3},
                        {4,5,6},
                        {7,8,9}
                };
        RotateImage image = new RotateImage();
        image.rotateV2(matrix);
        for(var row: matrix){
            System.out.println(Arrays.toString(row));
        }
    }
}
