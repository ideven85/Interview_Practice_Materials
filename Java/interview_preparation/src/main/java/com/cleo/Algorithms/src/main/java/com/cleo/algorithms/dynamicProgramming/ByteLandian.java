package com.cleo.algorithms.dynamicProgramming;

import java.util.HashMap;

public class ByteLandian {
    public static long bytelandian(long n, HashMap<Long, Long> memo) {
        // Write your code here
        if(n==0)
            return 0;
        if(!memo.containsKey(n/2))
            memo.put(n/2,bytelandian(n/2,memo));
        if(!memo.containsKey(n/3))
            memo.put(n/3,bytelandian(n/3,memo));
        if(!memo.containsKey(n/4))
            memo.put(n/4,bytelandian(n/4,memo));
        return Math.max(n,memo.get(n/2)+memo.get(n/3)+memo.get(n/4));
    }

    public static void main(String[] args) {
        HashMap<Long,Long> memo = new HashMap<>();
        System.out.println(bytelandian(2,memo));
    }
}
