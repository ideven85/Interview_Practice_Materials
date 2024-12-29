package com.cleo.algorithms.queuesAndStacks;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    //Define the data members
   private final Queue<Integer> first;
   private final Queue<Integer> second;
   private int size;
    public StackUsingQueues() {
        //Implement the Constructor
        first= new LinkedList<>();
        second= new LinkedList<>();
        size=0;
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() {
        //Implement the getSize() function
        return size;
    }

    public boolean isEmpty() {
        //Implement the isEmpty() function
        return size<=0;
    }

    public void push(int element) {
        //Implement the push(element) function
        first.add(element);
        size++;
    }

    public int pop() {
        //Implement the pop() function
        if(isEmpty())
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
        //Implement the top() function
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

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.getSize());
    }
}