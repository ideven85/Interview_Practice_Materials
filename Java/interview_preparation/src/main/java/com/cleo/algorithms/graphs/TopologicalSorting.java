package com.cleo.algorithms.graphs;

import java.util.*;

public class TopologicalSorting {

    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        // Write your code here.
        int V = jobs.size();
        Map<Integer,List<Integer>> map = new HashMap<>();

        int[] in_degree;
        if(jobs.get(0)!=0)
         in_degree=new int[V+1];
        else
            in_degree = new int[V];
        List<Integer> result = new ArrayList<>();
        for(var row:deps){
            map.computeIfAbsent(row[1],x->new ArrayList<>()).add(row[0]);
            in_degree[row[0]]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < in_degree.length; i++) {
            if(jobs.get(0)!=0&&i==0)
                continue;
            if (in_degree[i] == 0)
                q.add(i);
        }

        int i=0;
        while (!q.isEmpty()) {
            int u = q.poll();
            result.add(u);
            i++;
            for(var next:map.getOrDefault(u,new ArrayList<>())){
                if(--in_degree[next]==0)
                    q.add(next);
            }

        }
        System.out.println(i);
        System.out.println(result);
        Collections.reverse(result);
       return i==jobs.size()?result:new ArrayList<>();

    }

    public static List<Integer> scheduleJobs(List<Integer> jobs, List<Integer[]> deps){
        List<List<Integer>> adj = new ArrayList<>();

        int V = jobs.size();
        if(jobs.get(0)!=0)
            V+=1;

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for(var row: deps){
            adj.get(row[1]).add(row[0]);
        }

        int[] in_degree;
        if(jobs.get(0)!=0)
            in_degree=new int[jobs.size()+1];
        else
            in_degree = new int[jobs.size()];
        List<Integer> result = new ArrayList<>();
        for (int u = 0; u < in_degree.length; u++) {

            for (int x:adj.get(u))
                in_degree[x]++;
        }
        int visited = 0;
        Queue<Integer> q=new LinkedList<>();
        for (int i=0; i < jobs.size(); i++) {
            if (jobs.get(0) != 0 && i == 0)
                continue;
            if (in_degree[i] == 0)
                q.add(i);
        }


        while (!q.isEmpty()) {
            int u = q.poll();
            result.add(u);
            visited++;
            for (int x: adj.get(u))
                if (--in_degree[x] == 0)
                    q.add(x);
        }
        System.out.println(visited);
        Collections.reverse(result);
        return visited==jobs.size()?result:new ArrayList<>();
    }

    public static List<Integer> scheduleJobsV2(List<Integer> jobs, List<Integer[]> deps) {
        int n = jobs.size();

        Map<Integer,List<Integer>> bitMap = new HashMap<>();
        int[] in_degree = new int[n+1];
        for(var dep:deps){
            bitMap.putIfAbsent(dep[1],new ArrayList<>());
            bitMap.get(dep[1]).add(dep[0]);
            in_degree[dep[0]]++;
        }
        List<Integer> result = new ArrayList<>();
        int start=0;
        for (int i = 0; i <= n; i++) {
            if(jobs.get(0)!=0&&i==0)
                continue;
            if(in_degree[i]==0) {
                start = i;
                break;
            }
        }
        result.add(start);
        Set<Integer> seen = new HashSet<>();
        if(dfsUtil(bitMap,start,result,1,seen,n)){
            Collections.reverse(result);
            return result;
        }

        return new ArrayList<>();


    }
    public static boolean dfsUtil(Map<Integer,List<Integer>> bitMap, int start,List<Integer> result,int count,Set<Integer> seen,int V){

        System.out.println(result+" "+count);

        if(!seen.contains(start)){
            List<Integer> adjacent=bitMap.get(start);
            if(adjacent!=null){
                for(int node:adjacent){
                    if(seen.contains(node))
                        continue;
                    seen.add(node);
                    count++;
                    result.add(node);
                    dfsUtil(bitMap,node,result,count,seen,V);
                }
            }
        }
        return count==V;


    }

        public static void main(String[] args) {
        List<Integer> jobs = Arrays.asList(1,2,3,4);
        List<Integer[]> deps = new ArrayList<>(jobs.size());
        deps.add(new Integer[]{1,2});
        deps.add(new Integer[]{1,3});
        deps.add(new Integer[]{3,2});
        deps.add(new Integer[]{4,2});
        deps.add(new Integer[]{4,3});
        System.out.println(topologicalSort(jobs,deps));
        System.out.println(scheduleJobsV2(jobs,deps));

    }
}
