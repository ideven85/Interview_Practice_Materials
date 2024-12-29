package com.cleo.algorithms.queuesAndStacks;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    public static int[] stockSpan(int[] price) {
        //Your code goes here
        int n = price.length;


        int[] span = new int[price.length];
        Arrays.fill(span,1);
        if(n<=1)
            return span;

        for (int i = 1; i < span.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if(price[j]<price[i])
                    span[i]+=1;
                else
                    break;

            }

        }
        return span;


    }
    public static int[] span(int[] price){
        int n = price.length;
        Stack<Integer> stack = new Stack<>();
        int[] span = new int[n];
        return span;
    }

    public static void main(String[] args) {
        int[] price= {100,80,60,70,60,75,85};
        System.out.println(Arrays.toString(stockSpan(price)));
    }

}
