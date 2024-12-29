package com.cleo.algorithms.math;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public int pascalTriangle(int rows, int columns){
        if(rows==0)
            return 1;
        if(columns==0)
            return 1;
        return pascalTriangle(rows-1,columns)+pascalTriangle(rows,columns-1);


    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>();
        ArrayList<Integer> prev = new ArrayList<>();
        prev.add(1);
        output.add(prev);
        for(int i = 2; i <= numRows; i++)
        {
            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(1);
            for(int j = 0; j < prev.size()-1; j++)
            {
                curr.add(prev.get(j) + prev.get(j+1));
            }
            curr.add(1);
            output.add(curr);
            prev = curr;
        }
        return output;
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        for(int i = 1; i <=rowIndex; i++)
        {
            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(1);
            for(int j = 0; j < prev.size()-1; j++)
            {
                curr.add(prev.get(j) + prev.get(j+1));
            }
            curr.add(1);
            //output.add(curr);
            prev = curr;
        }
        return prev;


    }

    public static void main(String[] args) {
        PascalTriangle triangle = new PascalTriangle();
        System.out.println(triangle.generate(5));
        System.out.println(triangle.getRow(3));
    }
}
