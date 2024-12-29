package com.cleo.algorithms.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();


        for(char c: s.toCharArray())
            map.compute(c,(k,v)->v==null?1:++v);
        int counts = 0;
        for(var m:map.entrySet()){
            if(m.getValue()%2==0){
                counts++;
                map.remove(m.getKey());
            }

        }
        return 0;



    }
}
