package com.cleo.algorithms.dynamicProgramming;

import java.util.*;

public class MaxSumIncreasingSubsequence {
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        // Write your code here.
        int n = array.length;
        if(n==1)
            return new ArrayList<List<Integer>>() {
                {
                    add(List.of(array[0]));
                    add(List.of(array[0]));
                }


            };

        int sum_so_far=0,max_sum=0;
        int[] dp = array.clone();
        int[] sequences = new int[n];
        Arrays.fill(sequences,-1);

        for (int i = 0; i < n; i++) {
            int current = array[i];
            for (int j = 0; j <i ; j++)
                if(array[j]<array[i]&&dp[j]+current>=dp[i]) {
                    dp[i] = dp[j] + current;
                    sequences[i]=j;
                }
            if(dp[i]>=dp[max_sum])
                max_sum=i;
        }

        List<Integer> max_increasing_sequence = new ArrayList<>();
        sum_so_far=dp[max_sum];
        while(max_sum!=-1){
            max_increasing_sequence.add(array[max_sum]);
            max_sum=sequences[max_sum];
        }

        List<Integer> temp = new ArrayList<>();
        temp.add(sum_so_far);
        Collections.reverse(max_increasing_sequence);
        return new ArrayList<List<Integer>>() {
            {
                add(temp);
                // Example max sum
                ; // Example max sequence
                add(max_increasing_sequence);
            }
        };
    }

    public static void main(String[] args) {
        int[] arr = {10};
        var list = maxSumIncreasingSubsequence(arr);
        System.out.println(list);
    }
}
