package com.cleo.algorithms.dynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        for (int i = 0; i < n; i++) {
            for(String word:wordDict){
                if(i>=word.length()-1&&(i==word.length()-1||dp[i-word.length()]))
                    if(s.substring(i-word.length()+1,i+1).equals(word)){
                      //  System.out.println(word);
                        dp[i]=true;
                        break;
                    }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1];


    }
    String s;
    List<String> dict;
    int n;
    int[] dp;

    private boolean dp(int i){
        if(i<0)
            return true;

        if(dp[i]==-1) {
            for (String word : dict)
                if (i >= word.length() - 1 &&dp(i-word.length()))
                    if(s.substring(i-word.length()+1,i+1).equals(word)){
                        dp[i]=1;
                        break;
                    }
        }
        if(dp[i]==-1)
            dp[i]=0;
        return dp[i]==1;
    }

    public boolean wordBreakMemoized(String s,List<String> dict){
        this.s=s;
        this.n=s.length();
        this.dict=dict;
        dp=new int[n];
        Arrays.fill(dp,-1);
        boolean flag=dp(n-1);
        System.out.println(Arrays.toString(dp));
        return flag;
    }

    public static void main(String[] args) {
        String s="aaaaaaa";
        List<String> dict=List.of("aaaa","aaaa");
        System.out.println(wordBreak(s,dict));
        System.out.println(new WordBreak().wordBreakMemoized(s,dict));
    }
}
