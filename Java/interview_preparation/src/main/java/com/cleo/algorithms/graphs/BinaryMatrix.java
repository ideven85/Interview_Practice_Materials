package com.cleo.algorithms.graphs;

import java.util.*;

public class BinaryMatrix {

    private static class Point{
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return row+" "+col+" ";
        }

       @Override
        public boolean equals(Object obj) {
            if(obj==null)
                return false;
            return obj instanceof Point&& row == ((Point) obj).row && col == ((Point) obj).col;
        }

        @Override
        public int hashCode() {
            int value=row/11+col/11;
            return value;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1)
            return -1;
        int src = grid[0][0];
        int n = grid.length,m=grid[0].length;
        Point source = new Point(0,0);
        Point destination=new Point(n-1,m-1);
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        int pathLength=0,minPathLength=Integer.MAX_VALUE;
        boolean[][] seen=new boolean[n][m];
        while(!queue.isEmpty()){
            Point current=queue.remove();
            int row=current.row;
            int column=current.col;





            if(row==n-1&&column==m-1){
                return pathLength;





            }
            pathLength++;



            List<Point> connectedPoints = new ArrayList<>();
            if(row+1<n&&column+1<m&&grid[row+1][column+1]!=1)
                connectedPoints.add(new Point(row+1,column+1));
            if(row+1<n&&grid[row+1][column]!=1)
                connectedPoints.add(new Point(row+1,column));
             if(column+1<m&&grid[row][column+1]!=1)
                connectedPoints.add(new Point(row,column+1));
            if(row>0&&column>0&&grid[row-1][column-1]!=1)
                connectedPoints.add(new Point(row-1,column-1));


            if(row>0&&grid[row-1][column]!=1)
                connectedPoints.add(new Point(row-1,column));

            if(column>0&&grid[row][column-1]!=1)
                connectedPoints.add(new Point(row,column-1));
            if(row>0&&column+1<m&&grid[row-1][column+1]!=1)
                connectedPoints.add(new Point(row-1,column+1));
            if(column>0&&row+1<n&&grid[row+1][column-1]!=1)
                connectedPoints.add(new Point(row+1,column-1));


            queue.addAll(connectedPoints);

        }
        return -1;

    }

    public static void main(String[] args) {
        //grid = [[0,1],[1,0]]
        int[][] grid={{0,1},{1,0}};
        // grid = [[0,0,0],[1,1,0],[1,1,0]]
        int[][] grid1={{0,0,0},{1,1,0},{1,1,0}};

        BinaryMatrix binaryMatrix = new BinaryMatrix();
        System.out.println(binaryMatrix.shortestPathBinaryMatrix(grid));
        System.out.println(binaryMatrix.shortestPathBinaryMatrix(grid1));
        SolutionBinaryMatrix solutionBinaryMatrix = new SolutionBinaryMatrix();
        System.out.println(solutionBinaryMatrix.shortestPathBinaryMatrix(grid));
        System.out.println(solutionBinaryMatrix.shortestPathBinaryMatrix(grid1));
    }

}
class SolutionBinaryMatrix {

    private static final int[][] directions =
            new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {

        // Firstly, we need to check that the start and target cells are open.
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }

        // Set up the BFS.
        Queue<int[]> queue = new ArrayDeque<>();
        grid[0][0] = 1;
        queue.add(new int[]{0, 0});

        // Carry out the BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            int row = cell[0];
            int col = cell[1];
            int distance = grid[row][col];
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return distance;
            }
            for (int[] neighbour : getNeighbours(row, col, grid)) {
                int neighbourRow = neighbour[0];
                int neighbourCol = neighbour[1];
                queue.add(new int[]{neighbourRow, neighbourCol});
                grid[neighbourRow][neighbourCol] = distance + 1;
            }
        }

        // The target was unreachable.
        return -1;
    }

    private List<int[]> getNeighbours(int row, int col, int[][] grid) {
        List<int[]> neighbours = new ArrayList<>();
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow < 0 || newCol < 0 || newRow >= grid.length
                    || newCol >= grid[0].length
                    || grid[newRow][newCol] != 0) {
                continue;
            }
            neighbours.add(new int[]{newRow, newCol});
        }
        return neighbours;
    }

}
class SolutionAlmostMine {

    private static final int[][] directions =
            new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};


    public int shortestPathBinaryMatrix(int[][] grid) {

        // Firstly, we need to check that the start and target cells are open.
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }

        // Set up the BFS.
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 1}); // Put distance on the queue
        boolean[][] visited = new boolean[grid.length][grid[0].length]; // Used as visited set.
        visited[0][0] = true;

        // Carry out the BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            int row = cell[0];
            int col = cell[1];
            int distance = cell[2];
            // Check if this is the target cell.
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return distance;
            }
            for (int[] neighbour : getNeighbours(row, col, grid)) {
                int neighbourRow = neighbour[0];
                int neighbourCol = neighbour[1];
                if (visited[neighbourRow][neighbourCol]) {
                    continue;
                }
                visited[neighbourRow][neighbourCol] = true;
                queue.add(new int[]{neighbourRow, neighbourCol, distance + 1});
            }
        }

        // The target was unreachable.
        return -1;
    }

    private List<int[]> getNeighbours(int row, int col, int[][] grid) {
        List<int[]> neighbours = new ArrayList<>();
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow < 0 || newCol < 0 || newRow >= grid.length
                    || newCol >= grid[0].length
                    || grid[newRow][newCol] != 0) {
                continue;
            }
            neighbours.add(new int[]{newRow, newCol});
        }
        return neighbours;
    }

}