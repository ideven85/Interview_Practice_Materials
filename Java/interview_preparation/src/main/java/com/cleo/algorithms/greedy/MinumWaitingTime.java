package com.cleo.algorithms.greedy;

import java.util.Arrays;

public class MinumWaitingTime {
    public static int minimumWaitingTime(int[] queries) {
        // Write your code here.
        int n = queries.length;
        if(n==1)
            return 0;
        Arrays.sort(queries);
        int totalWaitingTime=0;
        for (int i = n-2; i >=0 ; i--) {
            totalWaitingTime+=queries[i+1]+queries[i];

        }
        totalWaitingTime-=queries[n-1];
       // totalWaitingTime+=queries[0]+queries[1];
        return totalWaitingTime;
    }

    public static int minimumWaitingTimeV2(int[] queries){
        int n = queries.length;
        Arrays.sort(queries);
        int[] temp = new int[n+1];
        temp[0]=0;
        for (int i = 1; i < n; i++) {
            temp[i]=temp[i-1]+queries[i-1];
        }
        return Arrays.stream(temp).sum();
    }
    public static void main(String[] args) {
        int[] queries = new int[]{3, 2, 1, 2, 6};
        System.out.println(minimumWaitingTimeV2(queries));
    }
}
