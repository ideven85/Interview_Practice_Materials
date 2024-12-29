package com.cleo.algorithms.graphs;

import java.util.*;

class Solution {
    public void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int V){
        int[] in_degree = new int[V];
        for (int u = 0; u < V; u++) {
            for (int x:adj.get(u))
                in_degree[x]++;
        }
        Map<Integer, Integer> parent = new HashMap<>();
        parent.put(0, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbour : adj.get(node)) {
                if (parent.get(node) == neighbour) {
                    continue;
                }
                if (parent.containsKey(neighbour)) {
                    //Same as my Union Find's Number of Edges Code
                    return false;
                }
                queue.offer(neighbour);
                parent.put(neighbour, node);
            }
        }

        return parent.size() == V;
    }


    public boolean validTree(int n, int[][] edges) {

        var list = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            addEdge(list,edge[0],edge[1]);
        }
        System.out.println(list);

        return detectCycle(list,n);


    }
}
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        int V = edges.length;
        UnionFindTree uf = new UnionFindTree(n);
        for(int[] edge:edges){
            int source = edge[0];
            int destination = edge[1];
            uf.union(source,destination);
        }
        return uf.isFlag();
    }

    public static void main(String[] args) {
        // n = 5, edges = [[0,1],[0,2],[0,3],[1,4]][[0,1],[1,2],[2,3],[1,3],[1,4]]
        int n=5;
        int[][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}};
        GraphValidTree graphValidTree = new GraphValidTree();
        boolean result = graphValidTree.validTree(n,edges);
        Solution solution = new Solution();
        System.out.println(solution.validTree(n,edges));
        System.out.println(result);
    }
}
class UnionFindTree{

    private final int[] root;
    private final int[] rank;

    private int numberOfEdges,previous;
    private boolean flag=true;
    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public UnionFindTree(int V) {
        root = new int[V];
        rank = new int[V];
        numberOfEdges=V;
        for (int i = 0; i < V; i++) {
            root[i]=i;
            rank[i]=1;
        }
    }
    public int find(int node){
        if(root[node]==node)
            return node;
        else return  root[node]=find(root[node]);
    }

    public boolean isFlag() {
        return flag;
    }

    public void union(int node1, int node2){
        previous=numberOfEdges;
        int rootNode1 = find(node1);
        int rootNode2 =  find(node2);
        if(rootNode1!=rootNode2){
            root[rootNode2]=rootNode1;
            numberOfEdges--;
        }
        if(previous==numberOfEdges)
            flag=false;

        System.out.println(numberOfEdges);
    }
    public boolean connected(int node1,int node2){
        return find(node1)==find(node2);
    }
}
