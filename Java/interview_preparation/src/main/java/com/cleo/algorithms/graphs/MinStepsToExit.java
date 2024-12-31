package com.cleo.algorithms.graphs;

import java.util.*;
public class MinStepsToExit{
    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public String toString(){
            return x+" " +y;
        }
    }
    List<Point> getAdjacentPoints(char[][] maze, Point p,Set<Point> seen,int rows, int columns){
        List<Point> points = new ArrayList<>();
        int x = p.x,y=p.y;
        if(x+1<=rows&&maze[x+1][y]!='+')
            points.add(new Point(x+1,y));
        if(x>0&&maze[x-1][y]!='+')
            points.add(new Point(x-1,y));
        if(y+1<=columns&&maze[x][y+1]!='+')
            points.add(new Point(x,y+1));
        if(y>0&&maze[x][y-1]!='+')
            points.add(new Point(x,y-1));
        return points;



    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length,n=maze[0].length;
        int rows=m-1,columns=n-1;
        int startRow=entrance[0];
        int startCol=entrance[1];

        int steps=0,min_steps=Integer.MAX_VALUE;
        Queue<Point> queue = new LinkedList<>();
        Point startingPoint = new Point(startRow,startCol);
        queue.offer(startingPoint);
        Set<Point> seen = new HashSet<>();
        while(!queue.isEmpty()&&seen.size()<=rows*columns){
            Point p = queue.poll();
            int x = p.x,y=p.y;
            steps+=1;

            if(p!=startingPoint){
                if(x==0||x==rows||y==0||y==columns) {
                    if (min_steps > steps)
                        min_steps = steps;
                    steps=0;
                }

            }
            // seen.add(p);

            List<Point> adjacent=getAdjacentPoints(maze,p,seen,rows,columns);
            if(adjacent!=null){
                for(Point adj:adjacent){


                    if(seen.contains(adj))
                        continue;
                    // steps+=1;
                    seen.add(adj);
                    queue.offer(adj);
                }
            }

        }
        System.out.println(seen);
        return min_steps==Integer.MAX_VALUE?-1:min_steps;



    }
    public int exit(char[][] maze,int[] entrance){ int rows = maze.length, cols = maze[0].length, queueSize;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int[] curr;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int x, y, steps = 0;

        queue.offer(entrance);
        visited[entrance[0]][entrance[1]] = true;

        while (!queue.isEmpty()) {
            queueSize = queue.size();
            steps++;

            for (int i=0;i<queueSize;i++) {
                curr = queue.poll();

                for (int[] dir: dirs) {
                    x = dir[0]+curr[0];
                    y = dir[1]+curr[1];

                    if (x<0||x>=rows||y<0||y>=cols) continue;
                    if (visited[x][y] || maze[x][y] == '+') continue;

                    // check if we have reached boundary
                    if (x==0||x==rows-1||y==0||y==cols-1) return steps;

                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }

        return -1;

    }
    public static void main(String[] args) {
        //maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
        char[][] maze= {{'+','+','+'},{'.','.','.'},{'+','+','+'}};
        int[] entrance = {1,0};
        MinStepsToExit steps = new MinStepsToExit();
        System.out.println(steps.exit(maze,entrance));
    }
}
