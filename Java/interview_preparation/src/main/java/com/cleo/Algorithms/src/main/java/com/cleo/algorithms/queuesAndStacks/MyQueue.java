package com.cleo.algorithms.queuesAndStacks;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> front,rear;
    public MyQueue() {
        front = new Stack<>();
        rear  = new Stack<>();
    }

    public void push(int x) {
            if(rear.size()==0)
           rear.push(x);
      else {
            rear.push(x);
                util();

            }



    }
    public void util(){
        int size = rear.size();
        while(size-->0){
            //System.out.println(rear.peek());
            front.push(rear.pop());
        }

        //System.out.println(front.peek());
        //rear.push(x);
    }

    public int pop() throws Exception {
        if(!empty()) {


            return front.pop();
        }

        else{
            throw new IndexOutOfBoundsException("Stack Is empty");
        }

    }

    public int peek() {

        return front.peek();

    }

    public boolean empty() {
        return front.empty();

    }

    public static void main(String[] args) throws Exception {
        MyQueue myQueue = new MyQueue();
        myQueue.push(10);
        myQueue.push(20);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());

    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */