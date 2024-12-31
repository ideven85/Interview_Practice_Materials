package com.cleo.algorithms.graphs;

import java.util.ArrayList;
import java.util.List;

public class UnionFind {

        // Write your code here.
        List<Integer> root = new ArrayList<>();
        public void createSet(int value) {
            // Write your code here.
            root.add(value);
        }

        public Integer find(int value) {
            // Write your code here.
            if(root.isEmpty()) {
                createSet(value);
                return value;
            }
            else if( root.get(value)==value)
                return value;
            else
                return find(root.get(value));
        }

        public void union(int valueOne, int valueTwo) {
            // Write your code here.
            int rootOne = find(valueOne);
            int rootTwo=find(valueTwo);
            if(rootOne!=rootTwo){
                int index1 = root.get(rootOne);
                root.set(index1,rootTwo);
            }
        }

}
