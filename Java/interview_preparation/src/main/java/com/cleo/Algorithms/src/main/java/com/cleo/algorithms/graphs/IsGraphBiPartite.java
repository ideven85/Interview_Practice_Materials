package com.cleo.algorithms.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A graph is bipartite if the nodes can be partitioned into two independent sets A and B
 * such that every edge in the graph connects a node in set A and a node in set B.
 */
public class IsGraphBiPartite {

        private final static int colorA = 1;
        private final static int colorB = 2;
        private final static int noColor = 0;

        public boolean isBipartite(int[][] graph) {

            int[] twoColorArray = new int[graph.length];
            Queue<Integer> queue = new LinkedList<>();

            while(anyNodeLeftForWhichColorIsNotSet(twoColorArray))  {
                int startingNode = findTheNextGraphPointToStart(twoColorArray);
                if(startingNode == -1) {
                    break;
                }
                queue.add(startingNode);
                twoColorArray[startingNode] = colorA;
                while(!queue.isEmpty()) {

                    int node = queue.poll();
                    int colorCanBeUsed = twoColorArray[node] == colorA ? colorB : colorA;
                    int[] connectedNodes = graph[node];
                    for(int adjacentNode : connectedNodes) {
                        if(twoColorArray[adjacentNode] == noColor) {
                            queue.add(adjacentNode);
                            twoColorArray[adjacentNode] = colorCanBeUsed;
                        } else {

                            if(twoColorArray[adjacentNode] != colorCanBeUsed) {
                                return false;
                            }
                        }
                    }
                }
            }

            return true;

        }

        private boolean anyNodeLeftForWhichColorIsNotSet(int[] twoColorArray) {

            for(int nodeColor: twoColorArray) {
                if(nodeColor == noColor) {
                    return true;
                }
            }
            return false;
        }

        private int findTheNextGraphPointToStart(int[] twoColorArray) {

            for(int i=0; i<twoColorArray.length; i++) {
                if(twoColorArray[i] == noColor) {
                    return i;
                }
            }

            return -1;
        }

    public static void main(String[] args) {

    }
}
