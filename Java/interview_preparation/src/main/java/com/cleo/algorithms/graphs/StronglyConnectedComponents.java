package com.cleo.algorithms.graphs;

public class StronglyConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        UnionFindSCC uf = new UnionFindSCC(n);
        for(int[] edge:edges){
            uf.union(edge[0],edge[1]);
        }
        return uf.getCount();
    }

    public static void main(String[] args) {
        //n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
        int n=5;
        int[][] edges = {{0,1},{1,2},{3,4}};
        StronglyConnectedComponents scc = new StronglyConnectedComponents();
        System.out.println(scc.countComponents(n,edges));
    }
}
class UnionFindSCC{

    private final int[] root;
    private int count;

    public int getCount() {
        return count;
    }

    public UnionFindSCC(int V) {
        root = new int[V];
        for (int i = 0; i < V; i++) {
            root[i]=i;
        }
        count=V;
    }
    public int find(int node){
        if(root[node]==node)
            return node;
        return root[node]=find(root[node]);
    }
    public void union(int node1, int node2){
        int rootNode1=find(node1);
        int rootNode2=find(node2);
        if(rootNode1!=rootNode2){
            root[rootNode2]=rootNode1;
            count--;
        }
    }
    public boolean connected(int node1, int node2){
        return find(node1)==find(node2);
    }
}
