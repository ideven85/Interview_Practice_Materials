package com.cleo.algorithms.queuesAndStacks;

import java.util.List;
import java.util.Stack;

public class BalancedBrackets {
    public static boolean balancedBrackets(String str) {
        // Write your code here.
        List<Character> OPENINGS = List.of('(','[','{');
        List<Character> CLOSINGS = List.of(')',']','}');
        Stack<Character> stack = new Stack<>();
        for(char c: str.toCharArray()){
            if(OPENINGS.contains(c))
                stack.push(c);
            else if(!stack.isEmpty()&&CLOSINGS.contains(c)){
                int v = CLOSINGS.indexOf(c);
                if(stack.peek()==OPENINGS.get(v))
                    stack.pop();
                else
                    return false;
            }
            if(stack.isEmpty()&&CLOSINGS.contains(c))
                return false;

        }
        System.out.println(stack);
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(balancedBrackets(s));
    }
}
