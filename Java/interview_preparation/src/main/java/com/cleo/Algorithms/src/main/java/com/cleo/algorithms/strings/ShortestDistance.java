package com.cleo.algorithms.strings;

public class ShortestDistance {
    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        int first=0,second=0,distance=0,n= wordsDict.length,min=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(wordsDict[i].equals(word1))
                first=i;
            else if(wordsDict[i].equals(word2))
                 second=i;
             distance=Math.abs(first-second);
            System.out.println(distance);
             if(min>distance)
                 min=distance;
            System.out.println(min);
        }
        return min;

    }

    public static void main(String[] args) {
        String[] dict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1="coding";
        String word2="makes";
        System.out.println(shortestDistance(dict,word1,word2));
    }
}
