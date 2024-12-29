package com.cleo.algorithms.backTracking;

public class CountSubStrings {

    static int countSubstrings(final String input, final String valueToFind) {
        if(input.length()<valueToFind.length())
            return 0;
        int count;
        String remaining;
        if(input.startsWith(valueToFind)){
            remaining=input.substring(valueToFind.length());
            count=1;
        }else {
            remaining = input.substring(1);
            count=0;
        }
        return countSubstrings(remaining,valueToFind)+count;


    }

    public static void main(String[] args) {
        String input = "bagbagbags";
        String test = "bags";
        System.out.println(countSubstrings(input,test));
    }


}
