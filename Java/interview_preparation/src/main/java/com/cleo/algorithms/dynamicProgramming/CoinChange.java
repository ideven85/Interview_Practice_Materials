package com.cleo.algorithms.dynamicProgramming;

import java.util.Arrays;

public class CoinChange {

    //Greedy Approach
    //Does not work in all cases
    public int minimumCoins(int[] coins, int amount){
        int n = coins.length;
        if(n==1){
            if(amount%coins[0]==0)
                return amount/coins[0];
            else
                return -1;
        }
        int minCoins=0;
        Arrays.sort(coins);
        Arrays.stream(coins)
                .boxed()
                .filter(c->c<10)
                .map(c->c*100)
                .forEach(c-> System.out.print(c+ " "));
      //  System.out.println(Arrays.toString(coins));
        for (int i = n-1; i >=0 ; i--) {

            if(amount==0)
                return minCoins;
            else{
                if(coins[i]<=amount && amount>0){
                    int coins1 = amount/coins[i];
                    minCoins+=(amount/coins[i]);
                    amount=amount-(coins1*coins[i]);
                    System.out.println(minCoins+ " "+amount);
                }
            }


        }
        return -1;
    }


    public int minimumCoinsDP(int[] coins, int amount){
        int n = coins.length;
        if(n==1){
            if(amount%coins[0]==0)
                return amount/coins[0];
            else
                return -1;
        }
        int minCoins=0;
        Arrays.sort(coins);//O(n(log(n))

        int[] dp = new int[n];
        int s = 0,min_s=0,current=amount;
        if(coins[n-1]<amount) {
            dp[0] = amount / coins[n - 1];
            current-=dp[0]*(amount%coins[n-1]);
        }

        int j=1;
        for (int i = n-2; i >=0 ; i--) {
            min_s=current/coins[i];
            s = amount/coins[i];

        }
        return minCoins;

    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Write your code here.
        int size = denoms.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int toCompare = 0;
        for (int denom : denoms) {
            for (int i = 0; i < dp.length; i++) {
                if (denom <= i) {
                    if (dp[i - denom] == Integer.MAX_VALUE)
                        toCompare = Integer.MAX_VALUE;
                    else
                        toCompare = dp[i - denom] + 1;
                    dp[i] = Math.min(dp[i], toCompare);
                }
            }

        }
        return dp[n]==Integer.MAX_VALUE?-1:dp[n];
    }


    private static int[][] memo;
    private static int numberOfCoinsForChange(int[] denmos,int amount, int n){
     /*   int n = denoms.length;
        //Arrays.sort(denoms);
        if(denoms[index]<amount)
            total+=denoms[index]+numberOfCoinsForChange(amount-denoms[index],denoms,)
*/       if(amount==0)
            return 1;
        if(amount<0)
            return 0;

        if(n==0)
            return 0;
        else
            return numberOfCoinsForChange(denmos,amount-denmos[n-1],n)
                    +numberOfCoinsForChange(denmos,amount,n-1);
    }

    public static void main(String[] args) {
        int[] coins = {2,3,5};
        int amount = 10;
        CoinChange coinChange = new CoinChange();
        int[] demoms = {3,5};
        int n = 9;
        System.out.println(minNumberOfCoinsForChange(n,demoms));
        System.out.println(minNumberOfCoinsForChange(amount,coins));
        System.out.println(numberOfCoinsForChange(coins,amount,3));
    }
}

