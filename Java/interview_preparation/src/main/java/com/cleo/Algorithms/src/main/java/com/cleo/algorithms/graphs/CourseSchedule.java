package com.cleo.algorithms.graphs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites){
        int V = numCourses-1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);

        }
        int[] in_degree = new int[numCourses];
        for (int u = 0; u < numCourses; u++) {
            for(int adjacent:adj.get(u))
                in_degree[adjacent]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(in_degree[i]==0)
                queue.add(i);
        }
        int count = 0;
       // boolean[] visited = new boolean[numCourses];
        while(!queue.isEmpty()){
            int current = queue.poll();

            count++;
            for(var adjacent:adj.get(current)){
                if(--in_degree[adjacent]==0)
                    queue.add(adjacent);
            }


        }
        System.out.println(count);
        return count == numCourses;
    }

    public static void main(String[] args) {
        //numCourses = 2, prerequisites = [[1,0]]
        int numCourses = 2;
        int[][] preRequisites = {{1,0}};
        System.out.println(canFinish(numCourses,preRequisites));
    }
}
