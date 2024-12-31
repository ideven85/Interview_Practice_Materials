package com.cleo.algorithms.strings;

public class IsSubSequence {

    public static boolean checkSubsequence(String s, String t){
        int n = t.length();
        int m = s.length();
        if(n==0&&m!=0)
            return false;
        else if(m==0)
            return true;
        int j=0;
        for (int i = 0; i <n ; i++) {
            if(j==m)
                return true;
            if(t.charAt(i)==s.charAt(j))
                j++;
        }
        return j==m;

    }
    public static boolean isSubsequence(String s, String t) {
        int n = t.length();
        int m = s.length();
        if(n>m)
            return checkSubsequence(s,t);
        else
            return checkSubsequence(t,s);

    }

    public static void main(String[] args) {
        String s = "b";
        String t = "abc";
        System.out.println(isSubsequence(s,t));
    }
}
