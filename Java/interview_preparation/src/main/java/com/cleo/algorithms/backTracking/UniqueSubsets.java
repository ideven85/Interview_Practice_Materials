package com.cleo.algorithms.backTracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class UniqueSubsets {
    private static final Set<String> subsets = new HashSet<>();


    public static void subsets(int[] input, int index, String set) {
        if (index == input.length) {
            subsets.add(set);
            return;
        }
        subsets(input, index + 1, set + input[index] + " ");
        subsets(input,index+1,set);

    }

    public static void printSubsets(int input[]) {
        subsets(input,0,"");
        for(String s:subsets){
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        int[] input = IntStream.rangeClosed(-3,-1).toArray();
        System.out.println(Arrays.toString(input));
        printSubsets(input);
    }
}
