package com.cleo.algorithms.graphs;

public class PathCompression {

    private final int[] root;

    public PathCompression(int V) {
        root = new int[V];
        for (int i = 0; i < V; i++) {
            root[i]=i;
        }
    }

    /**
     *
     * @param node given a node we are compressing the path by making the find function
     *             optimal
     * @return we are using recursion to find the highest parent thereby reducing the
     * height of the graph
     */
    public int find(int node){
        if(root[node]==node)
            return node;
        else
            return root[node]=find(root[node]);
    }
    public void union(int node1, int node2){
        int rootNode1=find(node1);
        int rootNode2=find(node2);
        if(rootNode1!=rootNode2)
            root[rootNode2]=rootNode1;

    }
    public boolean connected(int node1, int node2){
        return find(node1)==find(node2);
    }

    public static void main(String[] args) {
        PathCompression uf = new PathCompression(10);
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
        System.out.println(uf.root[6]);

    }
}
