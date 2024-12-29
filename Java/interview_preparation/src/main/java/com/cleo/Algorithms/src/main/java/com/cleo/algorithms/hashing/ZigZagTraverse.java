package com.cleo.algorithms.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigZagTraverse {
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        // Write your code here.
        int last_row = array.size();
        int last_col = array.get(0).size();
        int row = 0,col=0;
        List<Integer> output = new ArrayList<>();
        boolean next = true;
        while(row<last_row&&col<last_col){
            output.add(array.get(row).get(col));
            if(next){
                if(row==last_row-1){
                    col+=1;
                    next=false;
                }
                else if(col==0){
                    row+=1;
                    next=false;
                }else{
                    row+=1;
                    col-=1;
                }
            }
            else{
                if(col==last_col-1){
                    row+=1;
                    next=true;
                }else if(row==0){
                    col+=1;
                    next=true;
                }else{
                    row-=1;
                    col+=1;
                }
            }
        }


        return output;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int last_row=matrix.length;
        int last_col=matrix[0].length;
        int row = 0,col=0;
        List<Integer> output = new ArrayList<>();
        boolean next = true;
        while(row<last_row&&col<last_col){
            output.add(matrix[row][col]);
            if(next){
                if(row==last_row-1){
                    col+=1;
                    next=false;
                }
                else if(col==0){
                    row+=1;
                    next=false;
                }else{
                    row+=1;
                    col-=1;
                }
            }
            else{
                if(col==last_col-1){
                    row+=1;
                    next=true;
                }else if(row==0){
                    col+=1;
                    next=true;
                }else{
                    row-=1;
                    col+=1;
                }
            }
        }


        return output;

    }


    public static void main(String[] args) {
        List<List<Integer>> matrix = List.of(
                Arrays.asList(1,3,4,10),
                Arrays.asList(2,5,9,11),
                Arrays.asList(6,8,12,15),
                Arrays.asList(7,13,14,16)
        );
        System.out.println(zigzagTraverse(matrix));
    }
}
