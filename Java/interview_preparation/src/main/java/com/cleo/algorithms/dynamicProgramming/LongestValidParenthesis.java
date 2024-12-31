package com.cleo.algorithms.dynamicProgramming;

import java.util.*;
class Solution {
    // TC : O(n)
    // SC : O(n)
    public int longestValidParentheses(String s) {
        if(s==null || s.length()<2){
            return 0;
        }

        Stack<Integer> st =new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                st.push(i);
            } else{

                // current closing bracket

                if(!st.empty() && s.charAt(st.peek()) == '('){
                    // balanced case
                    st.pop();
                } else {
                    // unbalanced case
                    st.push(i);
                }
            }
        }

        int maxLen = 0;
        int endTerminal = s.length();

        while(!st.empty()){
            int startTerminal  = st.pop();
            maxLen = Math.max(maxLen, endTerminal - startTerminal -1);
            endTerminal = startTerminal;
        }

        return Math.max(endTerminal, maxLen);

    }
}
public class LongestValidParenthesis {
    public static int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        boolean matcher=true;
        int count = 0,max=0;
        Stack<Character> stack = new Stack<>();
        List<Integer> balanced = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {


                stack.push('(');
            } else {


                if (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                       // stack.push(')');
                        count += 2;


                    }
                }
                else

                        count = 0;



            }



            balanced.add(count);
        }
        if(stack.isEmpty())
            balanced.add(count);

        System.out.println(balanced);

        System.out.println(stack+ " " + count);
        return balanced.stream().max(Comparator.naturalOrder()).get();

    }
     public int longestValidParenthesesV2(String s) {
        Stack<Integer> stack = new Stack<>();
        int sum=0,total=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                stack.push(-1);
                sum+=-1;
            }else if(c==')'){
                if(sum<0){
                    total+=2;
                    stack.pop();
                    sum+=1;
                }

            }
        }
         System.out.println(total);
        return total;

    }

    public static void main(String[] args) {
        String  s = "()(()()";
        System.out.println(longestValidParentheses(s));
        LongestValidParenthesis validParenthesis = new LongestValidParenthesis();
        System.out.println(validParenthesis.longestValidParenthesesV2(s));
        Solution sol = new Solution();
        System.out.println(sol.longestValidParentheses(s));
    }
}
