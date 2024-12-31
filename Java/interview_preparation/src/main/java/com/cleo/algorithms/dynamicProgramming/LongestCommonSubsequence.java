package com.cleo.algorithms.dynamicProgramming;

import java.util.*;

public class LongestCommonSubsequence {

    //Memoisation or Bottom up approach
    public static int lcs(String s1, String s2, int n, int m, Map<Character,Integer> lookup){
        if(n==0||m==0) {
            return s1.charAt(0)==s2.charAt(0)?1:0;
        }

        if(lookup.containsKey(s1.charAt(n)))
            return lcs(s1,s2,n-1,m-1,lookup);

        if(s1.charAt(n)==s2.charAt(m)){
            lookup.put(s1.charAt(n),1);
            return 1+lcs(s1,s2,n-1,m-1,lookup);
        }
        return Math.max(lcs(s1,s2,n-1,m,lookup),lcs(s1,s2,n,m-1,lookup));

    }


    //AlgoExpert Code
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        int[][][] lcs = new int[str2.length()+1][str1.length()+1][];
        int n = str2.length(),m=str1.length();
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                lcs[i][j]=new int[]{0,0,0,0};

            }
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(str2.charAt(i-1)==str1.charAt(j-1)){
                    int[] newEntry = new int[]{(int)(str2.charAt(i-1)),lcs[i-1][j-1][1]+1,i-1,j-1};
                    lcs[i][j]=newEntry;
                }else{
                    int[] newEntry;
                    if(lcs[i-1][j][1]>lcs[i][j-1][1]){
                        newEntry = new int[]{-1, lcs[i - 1][j][1], i - 1, j};
                    }else{
                        newEntry = new int[]{-1, lcs[i][j - 1][1], i, j - 1};
                    }
                    lcs[i][j]=newEntry;
                }
            }
        }
        return buildSequence(lcs);

    }

        public static List<Character> buildSequence(int[][][] lcs){
        List<Character> sequence = new ArrayList<>();
        int i=lcs.length-1,j=lcs[0].length-1;
        while(i!=0&&j!=0){
            int[] current = lcs[i][j];
            if(current[0]!=-1)
                sequence.add(0,(char)current[0]);
            i=current[2];j=current[3];



        }
        return sequence;

    }
    //My revision to above
    public static List<Character> longestCommonSubsequenceV2(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j],Math.max(dp[i-1][j-1],dp[i][j-1]));
            }
        }
        List<Character> sequence = new ArrayList<>();
        int i=n;
        int j=m;
        while(i!=0&&j!=0){
            if(dp[i][j]==dp[i-1][j])
                i--;
            else if(dp[i][j]==dp[i][j-1])
                j--;
            else{
                sequence.add(0,(char)str1.charAt(i-1));//Coz we only increase when characters are same otherwise
                //we put max
                i--;
                j--;
            }
        }
        return sequence;

    }


        public static void main(String[] args) {
        String s1 ="8111111111111111142";
        String s2 = "222222222822222222222222222222433333333332";
        Map<Character,Integer> map = new HashMap<>();
      //  System.out.println(longestCommonSubsequence(s1,s2));
            System.out.println(longestCommonSubsequence(s1,s2));
            System.out.println(longestCommonSubsequenceV2(s1,s2));

       /* System.out.println(lcs(s1,s2,s1.length()-1,s2.length()-1,map));
        for(var c:map.entrySet()){
            System.out.println(c.getKey()+":"+c.getValue());
        }

        */

    }
}
