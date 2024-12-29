package com.cleo.algorithms.dynamicProgramming;

import java.util.Arrays;

/**
 * LeetCode Hard
 * https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
 */
public class MinDifficultyOfAJobSchedule {
    /*
    class Solution:
    def minDifficulty(self, jobDifficulty: List[int], d: int) -> int:
        n = len(jobDifficulty)
        # If we cannot schedule at least one job per day,
        # it is impossible to create a schedule
        if n < d:
            return -1

        dp = [[float("inf")] * (d + 1) for _ in range(n)]

        # Set base cases
        dp[-1][d] = jobDifficulty[-1]

        # On the last day, we must schedule all remaining jobs, so dp[i][d]
        # is the maximum difficulty job remaining
        for i in range(n - 2, -1, -1):
            dp[i][d] = max(dp[i + 1][d], jobDifficulty[i])

        for day in range(d - 1, 0, -1):
            for i in range(day - 1, n - (d - day)):
                hardest = 0
                # Iterate through the options and choose the best
                for j in range(i, n - (d - day)):
                    hardest = max(hardest, jobDifficulty[j])
                    # Recurrence relation
                    dp[i][day] = min(dp[i][day], hardest + dp[j + 1][day + 1])

        return dp[0][1]
     */

    private int n, d;
    private int[][] memo;
    private int[] jobDifficulty;
    private int[] hardestJobRemaining;

    private int dp(int i, int day) {
        // Base case, it's the last day so we need to finish all the jobs
        if (day == d) {
            return hardestJobRemaining[i];
        }

        if (memo[i][day] == -1) {
            int best = Integer.MAX_VALUE;
            int hardest = 0;
            // Iterate through the options and choose the best
            for (int j = i; j < n - (d - day); j++) {
                hardest = Math.max(hardest, jobDifficulty[j]);
                // Recurrence relation Now Code Bottom up Solution
                best = Math.min(best, hardest + dp(j + 1, day + 1));
            }
            memo[i][day] = best;
        }

        return memo[i][day];
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        n = jobDifficulty.length;
        // If we cannot schedule at least one job per day,
        // it is impossible to create a schedule
        if (n < d) {
            return -1;
        }

        hardestJobRemaining = new int[n];
        int hardestJob = 0;
        for (int i = n - 1; i >= 0; i--) {
            hardestJob = Math.max(hardestJob, jobDifficulty[i]);
            hardestJobRemaining[i] = hardestJob;
        }
        System.out.println(Arrays.toString(hardestJobRemaining));

        // Initialize memo array with value of -1.
        memo = new int[n][d + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        this.d = d;
        this.jobDifficulty = jobDifficulty;
        return dp(0, 1);
    }

    public int minDifficultyDP(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n<d)
            return -1;
        int[][] dp = new int[n][d+1];
        for(var row:dp)
            Arrays.fill(row,Integer.MAX_VALUE);
        //Base Case
        dp[n-1][d]=jobDifficulty[n-1];
        for (int i = n - 2; i >= 0; i--) {
            dp[i][d] = Math.max(dp[i + 1][d], jobDifficulty[i]);
        }
      /*  for(var row:dp)
            System.out.println(Arrays.toString(row));
      */  for (int day = d - 1; day > 0; day--) {
            for (int i = day - 1; i < n - (d - day); i++) {
                int hardest = 0;
                // Iterate through the options and choose the best
                for (int j = i; j < n - (d - day); j++) {
                    hardest = Math.max(hardest, jobDifficulty[j]);
                    // Recurrence relation
                    dp[i][day] = Math.min(dp[i][day], hardest + dp[j + 1][day + 1]);
                }

            }
            for(var row:dp)
                System.out.println(Arrays.toString(row));
        }
        System.out.println("Finally");
        for(var row:dp)
            System.out.println(Arrays.toString(row));

        return dp[0][1];

    }

    public static void main(String[] args) {
        int[] jobs={6,5,10,3,2,1};
        int days=3;
        System.out.println(new MinDifficultyOfAJobSchedule().minDifficulty(jobs,days));
        System.out.println(new MinDifficultyOfAJobSchedule().minDifficultyDP(jobs,days));
    }
}
