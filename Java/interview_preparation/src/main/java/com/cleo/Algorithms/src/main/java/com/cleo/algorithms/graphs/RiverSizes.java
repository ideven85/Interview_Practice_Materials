package com.cleo.algorithms.graphs;


import java.util.*;

public class RiverSizes {
    static class Pair{
        int row;
        int col;
        Pair(int num,int count){
            this.row = num;
            this.col = count;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }
    }


    /*
    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        List<Integer> answer = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;
        int size = 0;
        int[][] dp = new int[n + 1][m + 1];

        for (int k = 1; k < n; k++)
            for (int l = 1; l < m; l++)
                if (matrix[k - 1][l - 1] == 1){

                    if(matrix[k-1][l]==1||matrix[k][l-1]==1)
                        dp[k-1][l-1]=1+Math.max(dp[k-1][l],dp[k][l-1]);
                    else
                        dp[k-1][l-1]=1;
                }




        for (var row : dp) {
            for (var col : row)
                if (col != 0)
                    answer.add(col);
        }
        return answer;

    }

     */

    public static int dfsUtil(int row, int col,int[][] matrix, boolean[][] visited){
        int currentSize=0;
        int n = matrix.length;
        int m = matrix[row].length;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row,col));

            while(!queue.isEmpty()){
               Pair current = queue.poll();
               int i =current.getRow();
               int j = current.getCol();
               if(visited[i][j])
                   continue;
               if(matrix[i][j]==0)
                   continue;
               visited[i][j]=true;
               // System.out.print(currentSize+ "\t");

               currentSize+=1;
               if(i>0 && !visited[i-1][j])
                   queue.add(new Pair(i-1,j));
               if((i<n-1) && !visited[i+1][j])
                   queue.add(new Pair(i+1,j));
               if( j>0 && !visited[i][j-1])
                   queue.add(new Pair(i,j-1));
               if((j<m-1) && !visited[i][j+1])
                   queue.add(new Pair(i,j+1));

                }


        return currentSize;
        }

    public static List<Integer> lengthOfConnectedCells(int[][] matrix){
        int n = matrix.length,m=matrix[0].length;
        boolean[][] visited=new boolean[n][m];
        List<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                    if(!visited[i][j]) {
                        int size = dfsUtil(i, j, matrix, visited);
                        if(size!=0)
                            sizes.add(size);
                    }

            }
        }
        return sizes;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1,0,0,1,0},
                {1,0,1,0,0},
                {0,0,1,0,1},
                {1,0,1,0,1},
                {1,0,1,1,0}
        };
        System.out.println(lengthOfConnectedCells(matrix));
    }
}
