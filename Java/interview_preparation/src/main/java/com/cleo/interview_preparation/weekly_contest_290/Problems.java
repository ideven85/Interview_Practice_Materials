package com.cleo.interview_preparation.weekly_contest_290;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problems {

    public int minimumCardPickup(int[] cards) {
        /**
         * You are given an integer array cards where cards[i] represents the value of the ith card. A pair of cards are matching if the cards have the same value.

Return the minimum number of consecutive cards you have to pick up to have a pair of matching cards among the picked cards. If it is impossible to have matching cards, return -1.
         */
        int left=0,right=cards.length-1;
        int minimum=Integer.MAX_VALUE;
        int[] distinct =Arrays.stream(cards).distinct().toArray();
        if(distinct.length==0)
            return -1;
        while(left<right){
            if(cards[left]==cards[right]){
        }
        return -1;
    }

    public static String removeDigit(String number, char digit) {
        //int num = Integer.valueOf(number);
        //int to_remove = Integer.valueOf(String.valueOf(digit));
        long maximum = Long.MIN_VALUE;
        int i=0;
        for(char c:number.toCharArray()){
            if(c==digit){
                String current = number.substring(0,i)+number.substring(i+1);
                
            }
            i++;

        }
        return String.valueOf(maximum);
        
        
    }
    public static void main(String[] args) {
        String number ="2998589353917872714814599237991174513476623756395992135212546127959342974628712329595771672911914471";
        char digit = '1';
        System.out.println(removeDigit(number, digit));
    }
}
