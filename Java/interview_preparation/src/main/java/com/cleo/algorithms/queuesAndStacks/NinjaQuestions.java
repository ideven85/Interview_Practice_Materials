package com.cleo.algorithms.queuesAndStacks;

import java.util.Arrays;
import java.util.Stack;


public class NinjaQuestions {


    public static boolean isBalanced(String str) {
            //Your code goes here
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
    public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
        //Your code goes here
        while(!input.isEmpty()){
            extra.push(input.pop());
        }
        while(!extra.isEmpty()){
            input.push(extra.remove(0));
        }
    }
    public static boolean checkRedundantBrackets(String expression) {
        //Your code goes here
       Stack<Character> stack = new Stack<>();
       int opening=0;
       for(char c: expression.toCharArray()){
            if(c==')'){
                while(stack.peek()!='('){
                    stack.pop();
                    opening++;
                }
                stack.pop();
                if(opening<=1)
                    return true;
                opening=0;



           }else
               stack.push(c);
       }
       return false;
    }
    public static int countBracketReversals(String input) {
        if(input.length()%2!=0)
            return -1;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '}' && !stack.isEmpty()&&stack.peek()=='(')
                stack.pop();

            else
                stack.push(c);



        }




    int size=stack.size();
    int front = 0;
		while(!stack.isEmpty()&&stack.peek()=='{'){
        front+=1;
        stack.pop();
    }
		if(front%2==0)
            return size/2;
		else
                return size/2+1;
    }
    public static int countBracketReversalsV2(String input) {
        //Your code goes here
        if (input.length()%2!=0) return -1;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (!stack.isEmpty() && stack.peek() =='{' && input.charAt(i)=='}') stack.pop();
            else stack.push(input.charAt(i));
        }
        int count=0,length = stack.size();
        while (!stack.empty() && stack.peek() == '{')
        {
            stack.pop();
            count++;
        }
        if(count%2==0)
            return length/2;
        else
            return length/2+1;
    }
    static class Pair{
        int position;
        int value;

        public Pair(int position, int value) {
            this.position = position;
            this.value = value;
        }
    }
    public static int[] stockSpan(int[] price) {
        int n = price.length;


        int[] span = new int[price.length];
        Arrays.fill(span,1);
        if(n<=1)
            return span;

        for (int i = 1; i < span.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if(price[j]<price[i])
                    span[i]+=1;
                else
                    break;

            }

        }
        return span;


    }

        public static void main(String[] args) {
        String exp="a+()+c";
        System.out.println(checkRedundantBrackets(exp));
            System.out.println(countBracketReversalsV2("{{}}}}"));
    }

}
