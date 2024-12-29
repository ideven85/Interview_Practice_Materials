package com.cleo.algorithms.backTracking;

import java.util.HashMap;
import java.util.Map;

public class MinSquaresNeededToRepresentN {

    public static int minSquares(int n){
        if(n==0)
            return 0;
        Map<Integer,Integer> memo = new HashMap<>();
        return minSquaresHelper(n,memo);

    }
    private static int minSquaresHelper(int n,Map<Integer,Integer> memo){
        if(n==0)
            return 0;
        if(memo.containsKey(n))
            return memo.get(n);

        int minAns=Integer.MAX_VALUE;
        for (int i = 1; i*i <=n ; i++) {

            int currentAns;
            if(!memo.containsKey(n-i*i)){
                currentAns=minSquaresHelper(n-i*i,memo);
                memo.put(n-i*i,currentAns);
            }else
                currentAns=memo.get(n-i*i);
            if(minAns>currentAns)
                minAns=currentAns;

        }
        for(var m:memo.entrySet()){
            System.out.print(m.getKey()+":"+m.getValue()+"\t");
        }
        System.out.println();
        return 1+minAns;
    }

    public static void main(String[] args) {
        System.out.println(minSquares(34));
    }
}
