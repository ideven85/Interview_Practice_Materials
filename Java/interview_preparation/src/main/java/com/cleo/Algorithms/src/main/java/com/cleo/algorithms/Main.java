package com.cleo.algorithms;


import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;
import java.util.regex.Pattern;

public class Main {

    public static int[] max_amplitude(int n, int[] loud) {

        // Write your Code here
        Arrays.sort(loud);
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i]=loud[n-i-1];
        }
        return answer;
    }

    public static boolean containsOnlyDigits(String s){
        Pattern pattern = Pattern.compile("[0-9]+");

       return pattern.matcher(s).matches();
    }
    public static void main(String[] args) {
        Function<String,Integer> fn = String::length;
        System.out.println("Hi there typing from an almost mechanical keyboard");
        System.out.println("Hi there trying to type from an old keyboard");
        System.out.println("Slightly better than previous but not as good as Logitech");

        System.out.println(fn.apply("deven"));
        System.out.println(containsOnlyDigits("1234"));
        System.out.println("Hello world!");
    }
}