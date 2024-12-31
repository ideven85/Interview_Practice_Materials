package com.cleo.algorithms.dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GameTheory {

    public static String findWinner(int n, int x, int y) {
        //Your code goes here
       // int[] denominations ={1,x,y};
        /*int[] denoms = {1,x,y};
       // Arrays.sort(denoms);
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
      */
        /*  dp[0]=0;
        int toCompare=0;
        for(int denom:denoms){
            for (int i = 0; i < dp.length; i++) {
                if(denom<=i) {

                    if(dp[i-denom]==Integer.MAX_VALUE)
                        toCompare=Integer.MAX_VALUE;
                    else
                        toCompare=dp[i-denom]+1;
                    dp[i]=Math.min(dp[i],toCompare);
                }
            }

        }
        System.out.println(Arrays.toString(dp));

       *//*
*/
        String winner1="Beerus",winner2="Whis";

        int[] dp1 = new int[n+1];
        Arrays.fill(dp1,-1);
        for (int i = 1; i <= n; i++) {
            if (dp1[i - 1]==-1) dp1[i] = 1;
            if (i - x >= 0 && dp1[i - x]==-1) dp1[i] = 1;
            if (i - y >= 0 && dp1[i - y]==-1) dp1[i] = 1;
        }
        System.out.println(Arrays.toString(dp1));
        if (dp1[n]==-1) return winner2;
        return winner1;
       // return findWinnerHelper(n,denominations,memo,0,"");

        //return dp[n]==dp[n-1]?winner1:winner2;

      //  return winner1;
    }
    //4, [1,2,3] -> Winner Whis
    // No matter what Beerus picks Whis wins
    //Sample Input 2 :
    //10 2 4
    //Sample Output 2 :
    //Beerus-> 10-4=6,6-1=5,
    //Once 5 is reached no matter what whis plays beerus wins
    public static String findWinnerHelper(int n, int[] denominations,Map<Integer,String> memo,int turn,String winner){


        Arrays.sort(denominations);
        int max=denominations[2];
        if(n<=(n-max)){
            return winner;
        }
        System.out.println("Hi");
        String winner1="Beerus",winner2="Whis";

        /*if(n-denominations[denominations.length-1]<n){
            System.out.println("Hello");
            for(var m:memo.entrySet()){
                System.out.println(m.getKey()+":"+m.getValue());
            }
            return winner;

        }
*/
        for(int denom:denominations){
            System.out.println("Wow");
            if(!memo.containsKey(n-denom)){
                if(turn%2==1) {
                    memo.put(n-denom,winner2);

                   return findWinnerHelper(n - denom, denominations, memo, turn + 1, winner2);
                }
               else {
                   memo.put(n-denom,winner1);
                   return findWinnerHelper(n - denom, denominations, memo, turn + 1, winner1);
                }

            }else{
                winner=memo.get(n-denom);
                return winner;
            }


        }

        return "Hi";

    }

    public static void main(String[] args) {
        int n=4,x=2,y=3;
        System.out.println(findWinner(n,x,y));
    }
}
