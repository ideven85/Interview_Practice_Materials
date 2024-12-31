package com.cleo.algorithms.dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinCountOfSquares {
   /* public static int minCount(int n) {
        //Your code goes here
        if(n<=1)
            return 1;
      */
    /*  int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <=n ; i++) {
            if(i*i==n)
                return 1;
            if(i*i<n) {
                int sum=0;
                int count=0;
                for (int j = 1; j <= i; j++) {
                    sum+=j*j;
                    if(sum==n)
                        dp[i]=j;
                }

            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];*/
    /*
        int[] dp = new int[n+1];
       Arrays.fill(dp,-1);


    int   count=minSquares(n,dp);
      //  System.out.println(Arrays.toString(dp));
        return count;
    }
    public static int minSquares(int n, int[] dp) {
        if(n == 0) {
        return 0;
        }
        int minAns = Integer.MAX_VALUE;
        for(int i=1; i*i <= n;i++) {
            int currAns;
            if(dp[n-(i*i)] == -1){
                currAns = minSquares(n-(i*i),dp);
                dp[n-(i*i)] = currAns;
            } else {
                currAns = dp[n-(i*i)];
            }
            if(minAns > currAns) {
                minAns = currAns;
            }
        }
        return  1 + minAns;

    }
  *//*  private static int minCount(int n,Map<Integer,Integer> memo,int count){
        if(memo.get(n)!=null)
            return count;
        int sqrt=0;
        if((int)(Math.sqrt(n))==Math.sqrt(n)) {
            sqrt=(int)(Math.sqrt(n));
            memo.put(sqrt, ++count);
        }
        else {
            sqrt=(int)(Math.sqrt(n))+1;
            memo.put(sqrt + 1, ++count);
        }

        n-=sqrt;

        count++;


        return minCount(n,memo,count);
    }
*/


    public static int minCount(int n) {
        if(n==0)
            return 0;
        int min=Integer.MAX_VALUE;
        for (int i = 1; i*i <=n ; i++) {
            int current=minCount(n-i*i);
            if(min>current)
                min=current;
        }
        return 1+min;

    }

        public static void main(String[] args) {
        int n=30;
        System.out.println(minCount(41));
    }
}
