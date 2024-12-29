package com.cleo.algorithms.graphs;

import java.util.ArrayList;
class Solution1 {
    // Union Find
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }

        int n = isConnected.length;
        UnionFind2 uf = new UnionFind2(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.getCount();
    }

}
class SolutionUsingDFS {

    public static void dfs(int i,int[] vis,int[][]roads,int n,ArrayList<ArrayList<Integer>>adj){
        vis[i]=1;
        for(int it:adj.get(i)){
            if(vis[it]==0)
                dfs(it,vis,roads,n,adj);
        }

    }


    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int vis[]=new int[n];

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        ArrayList<Integer> al=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>(al));
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j]==1)
                    adj.get(i).add(j);
            }
        }



        for(int i=0;i<n;i++){

            vis[i]=0;

        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(i,vis,isConnected,n,adj);
                cnt++;
            }
        }
        return cnt;
    }
}
class UnionFind2 {
    private int[] root;
    private int[] rank;
    private int count;

    UnionFind2(int size) {
        root = new int[size];
        rank = new int[size];
        count = size;
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
            count--;
        }
    }

    int getCount() {
        return count;
    }
}

public class NumberOfProvinces {

    int[] root;
    int count;

    public void init(int V){
        root = new int[V+1];
        for (int i = 0; i <=V ; i++) {
            root[i]=i;
        }
        count=V;
    }

    public int find(int city){
        if(city==root[city])
            return city;
        return root[city]=find(root[city]);
    }
    public void union(int city1, int city2){
        int rootCity1 = find(city1);
        int rootCity2 = find(city2);
        if(rootCity1!=rootCity2) {
            root[rootCity2] = rootCity1;
            count--;
        }

    }
    public int findCircleNum(int[][] isConnected) {

        int V = isConnected.length;
        init(V);
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if(isConnected[i][j]==1)
                    union(i,j);
            }

        }
        return count;
    }

    public static void main(String[] args) {
        //isConnected = [[1,1,0],[1,1,0],[0,0,1]]
        int[][] isConnected ={{1,0,0},{0,1,0},{0,0,1}};
        NumberOfProvinces np = new NumberOfProvinces();
        System.out.println(np.findCircleNum(isConnected));
    }
}
