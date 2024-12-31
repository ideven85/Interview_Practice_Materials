package com.cleo.algorithms.dynamicProgramming;

import java.util.Arrays;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(n>m) {

            int starting_index = word1.indexOf(word2.charAt(0));
            int ending_index = word1.indexOf(word2.charAt(m-1));
            return starting_index+(n-ending_index);

        }else{

            int starting_index = word2.indexOf(word1.charAt(0));
            int ending_index = word2.indexOf(word1.charAt(n-1));
            return starting_index+(m-ending_index+1);
        }
    }

    //Max speed
    //Min Memory Usage
    public int minDistanceV2(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    dp[i][j] = j;

                else if (j == 0)
                    dp[i][j] = i;

                else if (word1.charAt(i - 1)
                        == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                else
                    dp[i][j] = 1
                            + Math.min(dp[i][j - 1],
                            Math.min(dp[i - 1][j],
                                    dp[i - 1]
                                            [j - 1]));
            }
        }
        for(var row:dp)
            System.out.println(Arrays.toString(row));
        return dp[m][n];
    }
}
