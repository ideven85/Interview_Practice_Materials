package com.cleo.algorithms.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NonConstructibleChange {
    public int nonConstructibleChange(int[] coins) {
        // Write your code here.
        if(coins.length==0)
            return 1;
        Arrays.sort(coins);
        int n = coins.length;
        int curr_sum=0;

        for (int i = 0; i < n; i++) {
            curr_sum+=coins[i];

        }
        return -1;
    }
}
