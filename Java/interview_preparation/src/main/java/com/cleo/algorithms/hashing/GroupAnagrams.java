package com.cleo.algorithms.hashing;

import java.util.*;

public class GroupAnagrams {

    public String sortWord(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        s=new String(chars);
        return s;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>();

        Map<String,List<String>> anagramMap=new HashMap<>();
        for(String word:strs){
            String sortedWord=sortWord(word);
            anagramMap.putIfAbsent(sortedWord,new ArrayList<>());
            anagramMap.get(sortedWord).add(word);
        }
        for(var map:anagramMap.entrySet()){
            List<String> temp=map.getValue();
            output.add(temp);
        }
        return output;


    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams.groupAnagrams(strs));
    }
}
