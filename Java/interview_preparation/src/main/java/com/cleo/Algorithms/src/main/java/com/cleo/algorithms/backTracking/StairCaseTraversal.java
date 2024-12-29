package com.cleo.algorithms.backTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StairCaseTraversal {

    List<Integer> ways = new ArrayList<>();

    public void traversalWays(int[] ways, int height, int minSteps, int maxSteps){


    }

    public int staircaseTraversal(int height, int maxSteps) {
        // Write your code here.

        Map<Integer,Integer> memoisedMap = new HashMap<>();
        memoisedMap.put(0,1);
        memoisedMap.put(1,1);
       return memoisedStairCaseTraveral(height,maxSteps,memoisedMap);

    }

    public int memoisedStairCaseTraveral(int height, int maxSteps, Map<Integer,Integer> memoisedMap){
        if(memoisedMap.containsKey(height))
                return memoisedMap.get(height);
        int numberOfWays=0;
        for (int i = 1; i < maxSteps+1; i++)
            if(i<=height)
                numberOfWays+=memoisedStairCaseTraveral(height-i,maxSteps,memoisedMap);

        memoisedMap.put(height,numberOfWays);
        return numberOfWays;



    }

    public static void main(String[] args) {
        StairCaseTraversal stairCaseTraversal = new StairCaseTraversal();
        System.out.println(stairCaseTraversal.staircaseTraversal(4,3));
    }
}
