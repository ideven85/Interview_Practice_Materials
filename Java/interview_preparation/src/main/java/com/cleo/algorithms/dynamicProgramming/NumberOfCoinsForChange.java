package com.cleo.algorithms.dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOfCoinsForChange {
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.
        int count=0;
        int[] dp = new int[n+1];
        dp[0]=1;
        int ways = 0;
        //Top-Down Approach
        for(int denom:denoms){
            for (int amount = 1; amount <=n; amount++) {
                if(denom<=amount)
                    dp[amount]+=dp[amount-denom];
                //System.out.println(Arrays.toString(dp));
                count++;
            }
        }

        System.out.println(count);
        //     return recur(n,denoms,0);//Alternative Solution using memoization
        return dp[n];

    }

    //private static Map<Integer,Integer> memo;
  //  private static int[][] memo;
    private static int countWays(int[] denmos,int amount, int n) {
      /*  if(amount==0)
            memo[n][amount]=1;*/

       /* if(amount-denmos[n-1]>0){

        }*/
        return 0;


    }
    public static int numberOfCoins(int[] denoms, int amount){
     //   memo=new HashMap<>();
        int n = denoms.length;
       int[][]  memo=new int[n+1][amount+1];
        for (int i = 0; i <= n; i++) {
            memo[i][0]=1;
        }
        int count=0;
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=amount ; j++) {
                memo[i][j]=memo[i-1][j];
                if(denoms[i-1]<=j)
                    memo[i][j]=memo[i][j]+memo[i][j-denoms[i-1]];
                count++;
            }
           /* for(var row:memo)
                System.out.println(Arrays.toString(row));
*/

        }
        System.out.println(count);
        return memo[n][amount];


    }

        public static void main(String[] args) {
        int n=5;int[] denominations={1,2,5};//5*3=15
        System.out.println(numberOfWaysToMakeChange(n,denominations));
            System.out.println(numberOfCoins(denominations,n));
    }
}
