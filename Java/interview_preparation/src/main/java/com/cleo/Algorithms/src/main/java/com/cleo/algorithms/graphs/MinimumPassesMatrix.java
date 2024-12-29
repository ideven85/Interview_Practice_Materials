package com.cleo.algorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MinimumPassesMatrix {
    private   static class Point{
        int row,column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public Point() {
        }

    }

    public int minimumPassesOfMatrix(int[][] matrix) {
        // Write your code here.
        boolean[][] visited = new boolean[matrix.length][];
        int rows = matrix.length;
        for (int i = 0; i < rows; i++) {
            visited[i]=new boolean[matrix[i].length];
        }
        int[] count=new int[1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if(matrix[i][j]>0) {
                    convertAdjacentPositives(matrix, i, j, visited,count);
                 //   System.out.println(count[0]);


                }



            }

        }
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt < 0)
                    return -1;
            }
        }
        System.out.println(Arrays.toString(count));
        return count[count.length-1];

    }
    public void convertAdjacentPositives(int[][] matrix, int row, int col, boolean[][] visited,int[] count){

        Point p = new Point(row,col);
        Stack<Point> stack = new Stack<>();
        stack.add(p);
        while(!stack.isEmpty()){
            Point current = stack.pop();
            int currentRow = current.row;
            int currentCol = current.column;
            if(visited[currentRow][currentCol])
                continue;
            visited[currentRow][currentCol]=true;


            List<Point> neighbours = getNeighbours(currentRow,currentCol,matrix.length,matrix[row].length);
            for(var neighbour:neighbours){

                if(matrix[neighbour.row][neighbour.column]<0) {
                    matrix[neighbour.row][neighbour.column] = -matrix[neighbour.row][neighbour.column];
                    count[0]+=1;
                    stack.add(new Point(neighbour.row, neighbour.column));
                }

            }



        }
      //  System.out.println(count);

    }
    public List<Point> getNeighbours(int currentRow, int currentCol, int rows, int columns){
        List<Point> list = new ArrayList<>();
        if(currentRow-1>=0)
            list.add(new Point(currentRow-1,currentCol));
        if(currentRow+1<rows)
            list.add(new Point(currentRow+1,currentCol));
        if(currentCol-1>=0)
            list.add(new Point(currentRow,currentCol-1));
        if(currentCol+1<columns)
            list.add(new Point(currentRow,currentCol+1));
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {
  {0, -1, -3, 2, 0},
  {1, -2, -5, -1, -3},
  {3, 0, 0, -4, -1}
};
        MinimumPassesMatrix mp = new MinimumPassesMatrix();
        System.out.println(mp.minimumPassesOfMatrix(matrix));

    }

}
