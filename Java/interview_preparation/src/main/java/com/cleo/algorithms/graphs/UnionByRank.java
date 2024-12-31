package com.cleo.algorithms.graphs;
/**
 * To be specific, the “rank” refers to the height of each vertex.
 * When we union two vertices, instead of always picking the root of x (or y,
 * it doesn't matter as long as we're consistent) as the new root node,
 * we choose the root node of the vertex with a larger “rank”.
 * We will merge the shorter tree under the taller tree
 * and assign the root node of the taller tree as the root node for both vertices.
 * In this way, we effectively avoid the possibility of connecting all vertices into a straight line.
 * This optimization is called the “disjoint set” with union by rank.

 */
public class UnionByRank {

    private final int[] root,rank;

    public UnionByRank(int size) {
       root = new int[size];rank=new int[size];
        for (int i = 0; i < size; i++) {
            root[i]=i;
            rank[i]=1;
        }
    }
    public int find(int node){
        if(root[node]==node)
            return node;
        else
            while(node!=root[node])
                node=root[node];
       return node;
    }
    public void union(int node1, int node2){
        int rootNode1=find(node1);
        int rootNode2=find(node2);
        if(rootNode1!=rootNode2){
            if(rank[rootNode1]<rank[rootNode2])
                root[rootNode1]=rootNode2;
            else if(rank[rootNode1]>rank[rootNode2])
                root[rootNode2]=rootNode1;
            else{
                root[rootNode2]=rootNode1;
                rank[rootNode1]+=1;
            }
        }
    }
    public boolean connected(int node1, int node2){
        return find(node1)==find(node2);
    }

    public static void main(String[] args) {
        UnionByRank uf = new UnionByRank(10);
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1,5));
        System.out.println(uf.connected(4,9));
        uf.union(9,4);
        System.out.println(uf.connected(3,4));
        System.out.println(uf.root[2]);

    }
}
