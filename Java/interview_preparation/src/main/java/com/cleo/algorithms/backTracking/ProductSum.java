package com.cleo.algorithms.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum {

    public static int calculateSum(List<Object> array, int multiplier){
        int sum=0;
        for(var e:array){
            if(e instanceof List<?>)
                sum+=calculateSum((List<Object>) e,multiplier+1);
            else
                sum+=(int) e;
        }
        return sum*multiplier;
    }


    public static int productSum(List<Object> array) {
        // Write your code here.

        return calculateSum(array,1);
    }

    public static void main(String[] args) {
        //[5, 2, [7, -1], 3, [6, [-13, 8], 4]]
        List<Object> c = new ArrayList<>();
        c.add(5);
        c.add(2);
        c.add(Arrays.asList(7,-1));
        c.add(3);
        c.add(Arrays.asList(6,Arrays.asList(-13,8),4));

        List<Object> c1 = new ArrayList<>();
        c1.add(2);
        c1.add(3);
        c1.add(Arrays.asList(1,2));
        var start = System.nanoTime();
        System.out.println(productSum(c));
        var finish = System.nanoTime();
        System.out.println(finish-start);
        System.out.println(productSum(c1));
    }
}
