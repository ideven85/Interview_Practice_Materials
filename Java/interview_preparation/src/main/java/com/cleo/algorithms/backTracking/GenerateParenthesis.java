package com.cleo.algorithms.backTracking;

import java.util.*;

public class GenerateParenthesis {

    private final String OPENING="(";
    private final String CLOSING=")";


    private boolean areBracketsBalanced(String str){
        Stack<Character> stack = new Stack<>();
        for(char c: str.toCharArray()){

            if(c=='(')
                stack.push(c);
            else {
                if(!stack.isEmpty())
                    stack.pop();
                else
                    return false;

                //   System.out.println(stack);
            }
        }

        return stack.isEmpty();
    }

    private Set<String> generatePermutations(String prefix,String str){
            Set<String> permutations = new LinkedHashSet<>();
            int n = str.length();
            if(n==0)
                if(areBracketsBalanced(prefix))
                    permutations.add(prefix);
            for (int i = 0; i < n; i++) {
                permutations.addAll(
                        generatePermutations(
                                prefix+str.charAt(i),
                                str.substring(i+1,n)+str.substring(0,i)));

            }
            return permutations;

        }
        public List<String> generateParenthesis(int n) {
            //String parenthesis="()".repeat(n);
            //Set<String> set=generatePermutations("",parenthesis);
            List<String> list = new ArrayList<>();
            dfs(list,0,0,"",n);
            return list;

        }
        public List<String> generateParenthesisV1(int n) {
            List<String> res = new ArrayList<String>();
        backtracking(res,new StringBuilder(),0,0,n);
        return res;
    }
//

    /**
     * Algorithm:
     * To ensure that the current string is always valid during the backtracking process, we need two variables left_count and right_count that record the number of left and right parentheses in it, respectively.
     *
     * Therefore, we can define our backtracking function as
     * backtracking(cur_string, left_count, right_count) that takes the current string, the number of left parentheses, and the number of right parentheses as arguments. This function will build valid combinations of parentheses of length 2n recursively.
     *
     * The function adds more parentheses to cur_string only when certain conditions are met:
     *
     * If left_count < n, it suggests that a left parenthesis can still be added, so we add one left parenthesis to cur_string, creating a new string new_string = cur_string + (, and then call backtracking(new_string, left_count + 1, right_count).
     *
     * If left_count > right_count, it suggests that a right parenthesis can be added to match a previous unmatched left parenthesis, so we add one right parenthesis to cur_string, creating a new string new_string = cur_string + ), and then call backtracking(new_string, left_count, right_count + 1).
     *
     * This function ensures that the generated string of length 2n is valid, and adds it directly to the answer. By only generating valid strings, we can avoid wasting time checking invalid strings.

     */
    private void backtracking(List<String> answer, StringBuilder curString, int leftCount, int rightCount, int n) {
        if (curString.length() == 2 * n) {
            answer.add(curString.toString());
            return;
        }
        if (leftCount < n) {
            curString.append("(");
            backtracking(answer, curString, leftCount + 1, rightCount, n);
            curString.deleteCharAt(curString.length() - 1);
        }
        if (leftCount > rightCount) {
            curString.append(")");
            backtracking(answer, curString, leftCount, rightCount + 1, n);
            curString.deleteCharAt(curString.length() - 1);
        }
    }
    private void dfs(List<String> res, int left, int right, String s, int n) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }

        if (left < n) {
            dfs(res, left + 1, right, s + "(", n);
        }

        if (right < left) {
            dfs(res, left, right + 1, s + ")", n);
        }
    }
    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        var time = System.nanoTime();
        System.out.println(generateParenthesis.generateParenthesis(3));
        var time1 = System.nanoTime();
        System.out.println(generateParenthesis.generateParenthesisV1(3));
        var time2 = System.nanoTime();
        System.out.println(time1-time);
        System.out.println(time2-time1);
        System.out.println(generateParenthesis.generateParenthesisV1(3));
    }
}
