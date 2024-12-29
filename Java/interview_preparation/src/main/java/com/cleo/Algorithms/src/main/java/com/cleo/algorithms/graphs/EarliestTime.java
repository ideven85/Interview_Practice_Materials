package com.cleo.algorithms.graphs;

import java.util.Arrays;
import java.util.Comparator;

public class EarliestTime {

    private int[] root;
    private int[] rank;
    private int count=0;
    public int find(int u){
       while(u!=root[u])
           u=root[u];
       return u;
    }

    public void union(int u,int v){
        int rootU=find(u);
        int rootV=find(v);
        if(rootV!=rootU){
            if(rank[rootU]>rank[rootV])
                root[rootV]=rootU;
            else if(rank[rootU]<rank[rootV])
                root[rootU]=rootV;
            else {
                root[rootV]=rootU;
                rank[rootV] += 1;
            }
            count+=1;
        }

    }

    public boolean connected(int u, int v) {
        return find(u)==find(v);
    }


    /**
     * Problem can be solved by using disjoint sets
     * Or when all vertices become connected E==n-1
     *
     * @param logs Timestamps at which friend a1 became friends with a2
     * @param n Number of friends
     * @return Earliest Time all became friends
     */

    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
              return o1[0]-o2[0];
            }
        });
        root= new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i]=i;
            rank[i]=1;
        }
        for (int[] log : logs) {
            union(log[1], log[2]);
            if(count==n-1)
                return log[0];


            // System.out.println(Arrays.toString(rank));
            // System.out.print(count+ " ");

        }


        return -1;

    }

    public static void main(String[] args) {
        EarliestTime time = new EarliestTime();
        int[][] logs = new int[][]{{8,2,0},{1,0,1},{3,0,3},{4,1,2},{7,3,1}};int  n = 4;
        System.out.println(time.earliestAcq(logs,n));
       // System.out.println(logs[0][1]);
    }
}
