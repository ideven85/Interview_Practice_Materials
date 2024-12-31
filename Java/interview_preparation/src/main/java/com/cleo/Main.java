package com.cleo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int fib(int n){
        if(n<2)
            return n;
        else{
            int a=0,b=1;
            for (int i = 1; i < n; i++) {
                b+=a;
                a=b-a;
            }
            return b;
        }
    }

    public static int factorial(int n){
        return n<2?1:n*factorial(n-1);
    }
    public static void main(String[] args) {
        System.out.println("Hi baby");
        System.out.println(factorial(10));
        System.out.println("Hi there");
        long start = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(fib(i));
        }
        long end = System.currentTimeMillis();
        System.out.println(list);
        System.out.println(end-start);

    }
}
