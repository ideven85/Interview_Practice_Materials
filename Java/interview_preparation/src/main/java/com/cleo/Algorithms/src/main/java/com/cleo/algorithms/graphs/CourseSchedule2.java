package com.cleo.algorithms.graphs;

import java.util.*;

public class CourseSchedule2 {
    //Example 2:
    //
    //Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
    //Output: [0,2,1,3]
    //Explanation: There are a total of 4 courses to take.
    // To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
    //So one correct course order is [0,1,2,3].
    // Another correct ordering is [0,2,1,3].
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int V = numCourses-1;
        int[] reverse=new int[numCourses];

        if(numCourses==1)
            return reverse;
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        for (int i = 0; i <=V ; i++) {
            courseMap.put(i,new ArrayList<>());
        }
        for(int[] courses:prerequisites){
            int course=courses[0];
            int preRequisite=courses[1];
            courseMap.get(course).add(preRequisite);
        }
        int[] in_degree = new int[numCourses];
        for (int u = 0; u < numCourses; u++) {
            for(int adjacent:courseMap.get(u))
                in_degree[adjacent]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(in_degree[i]==0)
                queue.add(i);
        }
        int[] courseOrdering = new int[numCourses];
        int count=0;
        while(!queue.isEmpty()){
            int current=queue.poll();
            courseOrdering[count++]=current;
            for(int adj:courseMap.get(current)){
                if(--in_degree[adj]==0)
                    queue.offer(adj);
            }
        }
        int j=0;
        for (int i = courseOrdering.length-1; i >=0 ; i--) {
            reverse[j++]=courseOrdering[i];

        }
        return count==numCourses?reverse:new int[]{};

    }

    public static void main(String[] args) {
        //Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
        int n=1;
        int[][] preRequisites ={{}};
        System.out.println(Arrays.toString(findOrder(n,preRequisites)));

    }
}
