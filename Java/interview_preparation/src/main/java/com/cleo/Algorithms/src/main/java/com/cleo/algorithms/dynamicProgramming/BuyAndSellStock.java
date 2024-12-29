package com.cleo.algorithms.dynamicProgramming;


/**
 *Leet Code Hard
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/">...</a>
 *
 */
public class BuyAndSellStock {
    /*
    Bottom Up Approach
     */
    private int[] prices;
    private int[][][] memo;
    //Example 1:
    //
    //Input: k = 2, prices = [2,4,1]
    //Output: 2
    //Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
    public int maxProfit(int k, int[] prices) {

        this.prices=prices;
        this.memo=new int[prices.length][k+1][2];

       return dp(0,k,0);



    }

    private int dp(int day, int transactions_remaining, int holding_stock){
        if(transactions_remaining==0||day==prices.length)
            return 0;

        if(memo[day][transactions_remaining][holding_stock]==0){
            int doNothing=dp(day+1,transactions_remaining,holding_stock);
            int doSomething;
            if(holding_stock==1)
                //Selling Stock
                doSomething=prices[day]
                        +dp(day+1,
                        transactions_remaining-1,0);
            else
                doSomething=-prices[day]+dp(day+1,transactions_remaining,1);
            memo[day][transactions_remaining][holding_stock]=Math.max(doSomething,doNothing);



        }
        return memo[day][transactions_remaining][holding_stock];
    }


    /*Bottom Up implementation of Buy And sell stock at most k times*/
    public int maxProfitDP(int k, int[] prices){
        int[][][] dp = new int[prices.length+1][k+1][2];
        int n = prices.length;


        for (int day = n-1; day >=0; day--) {
            for (int transactions_remaining= 1; transactions_remaining <= k; transactions_remaining++) {
                for (int holding_stock = 0; holding_stock < 2; holding_stock++) {
                    int doNothing = dp[day+1][transactions_remaining][holding_stock];
                        int doSomething;
                        if (holding_stock == 1) {

                            doSomething = prices[day] + dp[day+1][transactions_remaining-1][0];
                        } else {

                            doSomething = -prices[day] + dp[day+1][transactions_remaining][1];
                        }
                        dp[day][transactions_remaining][holding_stock] = Math.max(doNothing, doSomething);

                    }
                }
            }
                return dp[0][k][0];


    }


    public static void main(String[] args) {
       int k = 2;int[] prices = {2,4,1};
       BuyAndSellStock buyAndSellStock = new BuyAndSellStock();
        System.out.println(buyAndSellStock.maxProfitDP(k,prices));
    }
}
