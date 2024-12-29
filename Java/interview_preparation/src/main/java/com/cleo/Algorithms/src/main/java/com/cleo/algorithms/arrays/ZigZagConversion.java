package com.cleo.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        if(s.length()==0)
            return "";
        int n = s.length();
        int columns = n*numRows;
        char[][] matrix = new char[numRows][columns];
        for(var c: matrix){
            Arrays.fill(c,'a');
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < i+columns; j++) {
                matrix[i][j]=s.charAt(i+j);
            }
        }
        return sb.toString();


    }

    public static void main(String[] args) {
        System.out.println(convert("PaypalIsHiring",3));
    }

}
