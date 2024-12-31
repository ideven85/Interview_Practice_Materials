package com.cleo.algorithms.dynamicProgramming;
/*
class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        if n == 0:
            return ""
        start=0;end=0
        for i in range(n):
            l1 = self._expandAroundCenter(s,i,i)
            l2 = self._expandAroundCenter(s,i,i+1)
            length = max(l1,l2)
            if length>(end-start):
                start=i-(length-1)//2
                end = i+length//2
        return s[start:end+1]

    def _expandAroundCenter(self,s,low,high):
        LEFT = low;RIGHT=high
        while LEFT>=0 and RIGHT<len(s) and s[LEFT]==s[RIGHT]:
            LEFT-=1
            RIGHT+=1
        return RIGHT-LEFT-1





 */
public class LongestPalindromicSubString {

    // TODO: 19/08/23 No idea how I had done it
    public String longestPalindrome(String s) {
        int n = s.length();
       // int[] dp = new int[n];
       // StringBuilder sb = new StringBuilder();
        if(n==0)
            return "";
        int start=0,end=0,l1=0,l2=0;
        for (int i = 0; i < n; i++) {
            /*
            For every character in the String, we are moving pointers further
             and backward to find the palindrome
             We then check to see the length and return the longer one
             When we reach the mid point of a palindrome we store it in length and continue
             till we find a palindrome substring of longer length
             */
            l1=expandAroundCenter(s,i,i);
            l2=expandAroundCenter(s,i,i+1);
            int length=Math.max(l1,l2);
            if(length>(end-start)){

                start=i-(length-1)/2;
                end=i+length/2;
                System.out.println(length+ " "+ i + " " + s.substring(start,end+1)+" "+start+" "+end);

            }


        }


        return s.substring(start,end+1);
    }

    public int expandAroundCenter(String s, int start, int end){
        while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
            start-=1;
            end+=1;
        }
        return end-start-1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubString palindromicSubString = new LongestPalindromicSubString();
        System.out.println(palindromicSubString.longestPalindrome("nitinisdabbad"));
    }
}
