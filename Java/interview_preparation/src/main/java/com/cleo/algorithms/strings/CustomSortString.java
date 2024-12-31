package com.cleo.algorithms.strings;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    public String customSortString(String order, String s) {
        Map<Character,Integer> destinationMap = new HashMap<>();
        for(char c: s.toCharArray()){
            destinationMap.compute(c,(k,v)->v==null?1:++v);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            if(destinationMap.containsKey(order.charAt(i))){
                int count = destinationMap.get(order.charAt(i));
                sb.append(String.valueOf(order.charAt(i)).repeat(count));
                destinationMap.remove(order.charAt(i));


            }
        }
        for(char c:destinationMap.keySet()){
            int count = destinationMap.get(c);
            sb.append(String.valueOf(c).repeat(count));
        }
        return sb.toString();
    }
}
