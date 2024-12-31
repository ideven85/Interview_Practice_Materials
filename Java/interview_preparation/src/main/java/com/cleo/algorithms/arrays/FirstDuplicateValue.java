package com.cleo.algorithms.arrays;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstDuplicateValue {
    public static int firstDuplicateValue(int[] array) {
        // Write your code here.
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for(int c: array){
            if(map.get(c)!=null)
                return c;
            else{
                map.put(c,1);
            }
        }
        return -1;
    }

}
