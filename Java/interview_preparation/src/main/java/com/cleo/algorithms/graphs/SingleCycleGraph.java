package com.cleo.algorithms.graphs;

import java.util.HashSet;
import java.util.Set;

public class SingleCycleGraph {
    public static boolean hasSingleCycle(int[] array) {


        // Write your code here.
       // Set<Integer> seen = new HashSet<>();
        int n = array.length;
        int elements_visited=0;
        int i=0;

            int jumps = array[i];
            int j = i+jumps;
            elements_visited=1;

            while(i!=j){
                if(elements_visited>n)
                    return false;

                elements_visited++;

                if(j<0)
                    j+=array.length;
                jumps=array[j%array.length];
                j=(j+jumps)% array.length;







                if(elements_visited==n&&j==0) {
                    System.out.println(j);
                    return true;
                }
            }
            return elements_visited==n;






            



        

    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 11, -6, -23, -2, 3, 88, 908, -26};
        System.out.println(hasSingleCycle(arr));
    }
}
