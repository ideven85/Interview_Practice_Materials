package com.cleo.algorithms.dynamicProgramming;

import java.util.*;

public class Main {

    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        dp[0]=0;dp[1]=1;dp[2]=1;
        for (int i = 3; i <=n; i++) {
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
       // System.out.println(Arrays.toString(dp));
        return dp[n];

    }
    Map<Integer, Integer> memo = new HashMap<>();

    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        memo.put(n, fibonacci(n - 1) + fibonacci(n - 2));
        return memo.get(n);
    }


    /**
     * If we sort all the numbers into buckets indexed by these numbers,
     * this is essentially asking you to repetitively take an bucket while giving up
     * the 2 buckets next to it. (the range of these numbers is [1, 10000])
     *
     * The optimal final result can be derived by keep updating 2 variables skip_i,
     * take_i, which stands for:
     * skip_i : the best result for sub-problem of first (i+1) buckets from 0 to i,
     * while you skip the ith bucket.
     * take_i : the best result for sub-problem of first (i+1) buckets from 0 to i,
     * while you take the ith bucket.
     *
     * DP formula:
     * take[i] = skip[i-1] + values[i];
     * skip[i] = Math.max(skip[i-1], take[i-1]);
     * take[i] can only be derived from: if you skipped the [i-1]th bucket, and you take bucket[i].
     * skip[i] through, can be derived from either take[i-1] or skip[i-1], whatever the bigger;
     *  for numbers from [1 - 10000], each has a total sum sums[i]; if you earn sums[i], you cannot earn sums[i-1] and sums[i+1]
     *  * kind of like house robbing. you cannot rob 2 connected houses.
     *  *
     */
    public int deleteAndEarnV2(int[] nums) {
        int n = 10001;
        int[] values = new int[n];
        for (int num : nums)
            values[num] += num;

        int take = 0, skip = 0;
        for (int i = 0; i < n; i++) {
            int takei = skip + values[i];
            int skipi = Math.max(skip, take);
            take = takei;
            skip = skipi;
         //   System.out.print(take + " " + skip + " ");
        }
        return Math.max(take, skip);
    }


    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.tribonacci(25));
        int[] nums = {2,2,3,3,3,4};
        System.out.println(main.deleteAndEarnV2(nums));
        System.out.println(main.fibonacci(60));
    }
}
