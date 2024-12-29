package com.cleo.algorithms.queuesAndStacks;

public class QueueUsingArray {

    private int data[];
    private int front;
    private int rear;
    private int size;

    public QueueUsingArray(){

        data= new int[5];
        front= 0;
        rear= 4;
    }

    public QueueUsingArray(int capacity){

        data= new int[capacity];
        front= 0;
        rear= capacity-1;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void enqueue(int elem){
        data[rear-1]=elem;
        rear--;
    }

    public int front(){
        return data[front];

    }

    public int dequeue(){
        return  data[front++];

    }

}
