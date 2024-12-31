package com.cleo.algorithms.graphs;

import java.util.*;
import java.util.stream.IntStream;
class Pair1{
    int node;
    int weight;

    public Pair1(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public int getNode() {
        return node;
    }

    public int getWeight() {
        return weight;
    }


}
class PairComparator implements Comparator<Pair1>{
    @Override
    public int compare(Pair1 o1, Pair1 o2) {
        return o2.getWeight()-o1.getWeight();
    }
}
class UnionFind1{

    private final int[] root;
    private final int[] rank;

    public UnionFind1(int V){
        root= IntStream.range(0,V).toArray();
        rank=new int[V];
        Arrays.fill(rank,1);
    }

    public int find(int vertex){
        if(root[vertex]==vertex)
            return vertex;
        return root[vertex]=find(root[vertex]);
    }
    public void union(int vertex1, int vertex2){
        int rootV1 = find(vertex1);
        int rootV2 = find(vertex2);
        if(rootV1!=rootV2){
            if(rank[rootV1]<rank[rootV2])
                root[rootV2]=root[rootV1];
            else if(rank[rootV1]>rank[rootV2])
                root[rootV1]=root[rootV2];
            else{
                root[rootV2]=root[rootV1];
                rank[rootV2]+=1;
            }
        }
    }
    public boolean connected(int v1, int v2){
        return find(v1)==find(v2);
    }

}
public class ShortestPathKruskals {




    private final Map<Integer, List<Pair1>> map = new HashMap<>();
    public int[][][] kruskalsAlgorithm(int[][][] edges) {
        // Write your code here.
        //[
        //  [
        //    [1, 1]
        //  ],
        //  [
        //    [0, 1]
        //  ]
        //]
        int V = edges.length;
        for (int i = 0; i < V; i++) {
            map.put(i,new ArrayList<>());
        }
       /* List<List<Integer>> sortedEdges = new ArrayList<>();
        for (int source = 0; source < edges.length; source++) {
            for (int[] edge : edges[source]) {
                if (edge[0] > source)
                    sortedEdges.add( Arrays.asList(source, edge[0], edge[1]));
            }
        }
        sortedEdges.sort((e1, e2) -> e1.get(2) - e2.get(2));*/

        for(var edge:edges){
            for (int i = 0; i < edge.length; i++) {
                map.get(i).add(new Pair1(edge[i][0],edge[i][1]));
            }
        }
        map.forEach((key,value)-> value.sort(new PairComparator()));
        UnionFind1 uf = new UnionFind1(V);

        //Queue<Pair> queue = new PriorityQueue<>((x,y)->x.weight- y.weight);
        List<List<Integer>> answer = new ArrayList<>();
        for(var m:map.entrySet()){
            int currentNode=m.getKey();
            List<Pair1> connections = m.getValue();
            for(Pair1 p:connections){
                int node=p.node;
                int weight= p.weight;
                if(!uf.connected(currentNode,node)){
                    uf.union(currentNode,node);
                    answer.add(new ArrayList<>(Arrays.asList(currentNode,node,weight)));
                }

            }


        }
        int[][][] output = new int[edges.length][][];
        for (int i = 0; i < answer.size(); i++) {
            output[i]=new int[answer.get(i).size()][];
            for (int j = 0; j < answer.size(); j++) {
                List<Integer> curr = answer.get(i);
                for (int k = 0; k < curr.size(); k++) {
                    output[i][j][k]=curr.get(k);
                }
            }
        }




        return output;
    }

    public static void main(String[] args) {

    }
}
