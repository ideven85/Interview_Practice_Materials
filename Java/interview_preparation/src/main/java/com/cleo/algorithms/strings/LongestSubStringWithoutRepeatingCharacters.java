package com.cleo.algorithms.strings;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacters {
    public static String longestSubstringWithoutDuplication(String str) {
        // Write your code here
        //davidabcdef=>"abcdef"
        int current=0,max=0;
        Set<Character> set = new LinkedHashSet<>();
        int n = str.length();
        if(n==1)
            return str;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(!set.add(str.charAt(i))&&set.size()>=max){
                for(char c: set){
                    sb.append(c);
                }
                current=0;
                set = new HashSet<>();

            }else if(set.size()<max){

                current=0;
                set = new HashSet<>();
            }
            set.add(str.charAt(i));
            current+=1;
            if(max<=current)
                max=current;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutDuplication("clementisacap"));
    }
}
