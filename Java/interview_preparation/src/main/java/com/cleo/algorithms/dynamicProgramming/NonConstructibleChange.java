package com.cleo.algorithms.dynamicProgramming;

import java.util.Arrays;

public class NonConstructibleChange {

    public static int nonConstructibleChange(int[] coins) {
        // Write your code here.
        int n =coins.length;
        Arrays.sort(coins);
        int sum=0;
        for(int coin:coins){
            if(coin>sum+1)
                return sum+1;
            sum+=coin;
            System.out.print(sum+" ");
        }
        return 1+sum;
    }

    public static void main(String[] args) {
        int[] a = {5, 7, 1, 1, 2, 3, 22};
        System.out.println(nonConstructibleChange(a));
    }
}
