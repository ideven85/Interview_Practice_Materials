package com.cleo.algorithms.queuesAndStacks;
import java.util.Stack;
public class CheckRedundantBrackets {
    public static boolean checkRedundantBrackets(String expression) {
        //Your code goes here
        Stack<Character> stack = new Stack<>();
        boolean flag=true;
        int charCount=0;
        for(char c: expression.toCharArray()) {

            if (c == ')') {
                while (stack.peek() != '(') {
                    stack.pop();
                    charCount++;
                }
                stack.pop();
                if (charCount <= 1) return true;
                charCount = 0;
            } else
                stack.push(c);
        }
        return false;
    }

    public static void main(String[] args) {
        String expr = "a+(b)+c ";
        System.out.println(checkRedundantBrackets(expr));
    }
}
