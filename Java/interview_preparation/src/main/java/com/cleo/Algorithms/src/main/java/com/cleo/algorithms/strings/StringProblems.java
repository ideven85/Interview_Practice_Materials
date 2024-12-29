package com.cleo.algorithms.strings;

import java.util.*;
import java.util.stream.Collectors;


public class StringProblems {

    /**
     *
     * @param s Given a string s
     * @return the length of longest subString without repeating characters
     */
    public int lengthOfLongestSubstring(String s) {
        if(s==null)
            return 0;
        if(s.length()==1)
            return 1;
        int n = s.length();
        int j = 0;
        int longest = 0;
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            if(map.get(s.charAt(i))==null) {
                map.put(s.charAt(i), ++j);

            }

            else{
               map.clear();
                j=0;
                map.put(s.charAt(i),++j);
            }
        }
        for(var c: map.entrySet()){
            if(longest<=c.getValue())
                longest=c.getValue();
        }
        map.entrySet().stream().forEach(s1-> System.out.print(s1.getKey() + " " + s1.getValue() + " "));
        System.out.println();


        return longest;

    }



    public int lengthOfSubStringWithDistinctCharacters(String s){
        int n = s.length();
        int longest_so_far=0,longest=0;
        int[] dp = new int[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(sb.indexOf(String.valueOf(s.charAt(i)))==-1){
                sb.append(s.charAt(i));
            }else{
                System.out.println(sb);
                sb = new StringBuilder(sb.substring(sb.lastIndexOf(String.valueOf(s.charAt(i)))));
            }
            longest_so_far = sb.length();
            if(longest<=longest_so_far)
                longest = longest_so_far;
        }
        System.out.println(sb);
        return longest;

    }


    public boolean isAnagram(String s, String t) {
        int n = s.length(),m = t.length();
        if(n!=m)
            return false;
        Map<Character,Integer> map = new HashMap<>();
        for(char c: s.toCharArray())
            map.compute(c,(k,v)->v==null?1:++v);
        for(char c: t.toCharArray()){
            if(map.get(c)==null||map.get(c)==0)
                return false;
            else
                map.put(c,map.get(c)-1);
        }
        return true;

    }
    public static String reverseWords(String s) {
        // s = s.toLowerCase();



        var list = s.trim().split(" +");
        Collections.reverse(Arrays.asList(list));
        return String.join(" ", list);


    }
    public boolean canPermutePalindrome(String s) {
        Map<Character,Integer> palindromeMap = new HashMap<>();
        for(char c: s.toCharArray())
            palindromeMap.compute(c,(k,v)->v==null?1:++v);
        boolean flag=false;
        for(var m:palindromeMap.entrySet()){
            if(m.getValue()%2!=0&&!flag)
                flag=true;
            else if(m.getValue()%2!=0)
                return false;
        }
        return true;

    }
    public static void main(String[] args) {
        String s = "deven";
        StringProblems sp = new StringProblems();
        System.out.println(sp.lengthOfLongestSubstring(s));
        String a = "  GEEK   FOR   SGEEK    ";
        String b = "GEE";
        System.out.println();
        System.out.println(reverseWords(a));

        System.out.println(sp.isAnagram("anagram","nagaram"));
        System.out.println(sp.lengthOfSubStringWithDistinctCharacters("ababcb"));
        System.out.println(sp.canPermutePalindrome("carerac"));
    }


}
