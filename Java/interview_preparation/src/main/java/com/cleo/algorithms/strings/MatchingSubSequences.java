package com.cleo.algorithms.strings;

import java.util.HashMap;
import java.util.Map;

public class MatchingSubSequences {
    public static int numMatchingSubseq(String s, String[] words) {
        Map<String,Integer> wordMap = new HashMap<>();
        for(String word: words){
            wordMap.compute(word,(k,v)->v==null?1:++v);
        }
        int matching = 0;
        for(String w: wordMap.keySet()){
            int bigger=0,smaller=0;
          //  System.out.println(w);
            for (int i = 0; i < s.length(); i++) {


                if(s.charAt(i)==w.charAt(smaller))
                        smaller++;
                if(smaller==w.length()) {
                    matching += wordMap.get(w);
                    break;
                }
            }

        }
        return matching;

    }

    public static void main(String[] args) {
        String  s = "abcde";
        String[] words = new String[]{"a","bb","acd","ace"};
        System.out.println(numMatchingSubseq(s,words));

    }
}