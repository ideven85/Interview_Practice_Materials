package com.cleo.algorithms.dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs{
    Map<Integer,Integer> map = new HashMap<>();

    int[] cost;
    private final Map<Integer,Integer> memo = new HashMap<>();
    private int dp(int i){
        if(i<=1)
            return 0;
        if(memo.containsKey(i))
            return memo.get(i);

        memo.put(i,Math.min(dp(i-1)+cost[i-1],dp(i-2)+cost[i-2]));
        return memo.get(i);
    }

    public int minCostClimbingStairsMemoised(int[] cost) {
        this.cost=cost;
        return dp(cost.length);

    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n==1)return cost[0];
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=0;
        for (int i = 2; i <= n; i++) {
            dp[i]=Math.min(cost[i-1]+dp[i-1],cost[i-2]+dp[i-2]);



        }
          System.out.println(Arrays.toString(dp));
        return dp[n];

    }

    public static void main(String[] args) {
        /**
         * Min Cost Climbing Stairs
         */
        int[] cost={1,100,1,1,1,100,1,1,100,1};
        int[] cost1={10,15,20};

        System.out.println("\nMin cost Climbing Stairs\n");
        MinCostClimbingStairs minCost = new MinCostClimbingStairs();
        System.out.println(minCost.minCostClimbingStairs(cost));
       // System.out.println(minCost.minCostClimbingStairsMemoised(cost));
        System.out.println(minCost.minCostClimbingStairs(cost1));
        System.out.println(minCost.minCostClimbingStairsMemoised(cost1));


    }
}
