package com.cleo.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

public class CircularArrayRotation {
    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        // Write your code here
        int n = a.size();
        if(k>n)
            k = k%n;
        if(k>(n-k))
            k = n-k;

        List<Integer> left = new ArrayList<>(),right= new ArrayList<>();
        for (int i = 0; i <k; i++) {
            left.add(a.get(i));

        }
        for (int i = k; i < n; i++) {
            right.add(a.get(i));
        }

        for (int i = 0; i < right.size(); i++) {
            a.set(i, right.get(i));
        }
        System.out.println(a);
        int j = 0;
        for (int i = n-k; i < n; i++) {
            a.set(i, left.get(j++));
        }


        System.out.println(a);


        queries.replaceAll(a::get);
        return queries;

    }

}
