package com.cleo.algorithms.dynamicProgramming;

public class JobSchedule {
    public int minDifficulty(int[] A, int D) {
        int n = A.length, maxd;
        if (n < D) return -1;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; --i)
            dp[i] = Math.max(dp[i + 1], A[i]);
        for (int d = 2; d <= D; ++d) {
            for (int i = 0; i <= n - d; ++i) {
                maxd = 0;
                dp[i] = Integer.MAX_VALUE;
                for (int j = i; j <= n - d; ++j) {
                    maxd = Math.max(maxd, A[j]);
                    dp[i] = Math.min(dp[i], maxd + dp[j + 1]);
                }
            }
        }
        return dp[0];
    }
    /**
     * def minDifficulty(self, A, d):
     *         n, inf = len(A), float('inf')
     *         if n < d: return -1
     *         dp = [inf] * n + [0]
     *         for d in range(1, d + 1):
     *             for i in range(n - d + 1):
     *                 maxd, dp[i] = 0, inf
     *                 for j in range(i, n - d + 1):
     *                     maxd = max(maxd, A[j])
     *                     dp[i] = min(dp[i], maxd + dp[j + 1])
     *         return dp[0]
     *
     *  def minDifficulty(self, A, d):
     *         n, inf = len(A), float('inf')
     *         dp = [[inf] * n + [0] for i in xrange(d + 1)]
     *         for d in xrange(1, d + 1):
     *             for i in xrange(n - d + 1):
     *                 maxd = 0
     *                 for j in xrange(i, n - d + 1):
     *                     maxd = max(maxd, A[j])
     *                     dp[d][i] = min(dp[d][i], maxd + dp[d - 1][j + 1])
     *         return dp[d][0] if dp[d][0] < inf else -1
     */


    // TODO: 02/12/23

    public int minDifficultyV2(int[] jobDifficulty, int d) {

        return -1;
    }



}
