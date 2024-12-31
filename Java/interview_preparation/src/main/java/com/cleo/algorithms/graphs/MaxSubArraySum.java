package com.cleo.algorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.LongStream;

public class MaxSubArraySum {
    public static long maximumSum(List<Long> a, long m) {
        // Write your code here
        long max=-1,max_so_far=0,total=0;
        if(m==1)
            return 0;
        int left=0;
        for (int i = 0; i < a.size(); i++) {
            max_so_far+=a.get(i);
            if(total<max_so_far)
                total=max_so_far;
            if(total>m){
                total=total%m;
                while(max_so_far>=m){
                    max_so_far-=a.get(left++);


                }
                i=left;
                if(total<max_so_far)
                    total=max_so_far;


            }

        }
       // System.out.println(max_so_far);

        return total;

    }

    public static void main(String[] args) {
        List<Long> a =List.of(1L,5L,9L,23L,34L,123L);
        System.out.println(a.stream().reduce(0L, Long::sum).intValue());

        System.out.println(maximumSum(a,37));
       // System.out.println("a"+12%1);
    }


}
