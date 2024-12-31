package com.cleo.algorithms.queuesAndStacks;

import java.util.*;
import java.util.Queue;

public class MyStack {

    private final Queue<Integer> first;
    private final Queue<Integer> second;
    private int size;


        public MyStack() {
            first= new LinkedList<>();
            second= new LinkedList<>();
            size=0;
        }

        public void push(int x) {

            first.add(x);
            size++;

        }

        public int pop() {
            if(empty())
                return -1;
            assert first.size()>=1;
            while(first.size()>1)
                second.add(first.poll());
            int answer=first.poll();
            while(!second.isEmpty()){
                first.add(second.poll());
            }
            size--;
            return answer;

        }

        public int top() {
            assert first.size()>=1;
            while(first.size()>1)
                second.add(first.poll());
            int answer=first.peek();
            second.add(first.poll());
            while(!second.isEmpty()){
                first.add(second.poll());
            }
            //  System.out.println(first);

            return answer;

        }

        public boolean empty() {
            return size==0;
        }

    public static void main(String[] args) {
            MyStack myStack = new MyStack();
            myStack.push(1);
            myStack.push(2);
            myStack.push(3);
        //System.out.println(myStack.top());
      //  System.out.println(myStack.pop());
       // System.out.println(myStack.pop());
       // Stack<Integer> stack = new Stack<>();
        //stack.push(1);
        //tack.push(2);
        //ystem.out.println("Standard Stack: pop(2)"+stack.pop());
        System.out.println("My stack pop: "+myStack.pop());
      //  System.out.println(myStack.front);
        System.out.println(myStack.top());
        //System.out.println(myStack.front);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());

    }

}

