package com.cleo.algorithms.heaps;


import java.util.ArrayList;

public class Priority_Queue<T>{

    private ArrayList<Element<T>> heap;

    public Priority_Queue(){
        heap= new ArrayList<>();
    }

    public void insert(T value, int priority){
        Element<T> e= new Element<> (value, priority);
        heap.add(e);
        int childIndex= heap.size()-1;
        int parentIndex=(childIndex-1)/2;

        while(childIndex>0){
            if(heap.get(childIndex).priority < heap.get(parentIndex).priority){
                Element<T> temp= heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex= parentIndex;
                parentIndex= (childIndex-1)/2;
            }else{
                return;
            }
        }
    }
    public T getMin() throws PriorityQueueException{
        if(isEmpty()){
            throw new PriorityQueueException();
        }
        return heap.get(0).value;

    }
    public T removeMin() throws PriorityQueueException{
        if(isEmpty()){
            throw new PriorityQueueException();
        }
        Element<T> removed= heap.get(0);
        T ans = removed.value;

        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int parentIndex=0;
        int leftChildIndex= 1;
        int rightChildIndex= 2;
        int i=0;
        while(rightChildIndex<heap.size()&&(heap.get(parentIndex).priority>heap.get(leftChildIndex).priority)||(heap.get(parentIndex).priority>heap.get(rightChildIndex).priority)) {
            int minIndex = parentIndex;
            if (heap.get(leftChildIndex).priority < heap.get(minIndex).priority) {
                minIndex = leftChildIndex;
            }
            else minIndex=rightChildIndex;
            Element<T> temp = heap.get(minIndex);
            heap.set(minIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            parentIndex = minIndex;
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;
        }
        return ans;

    }
    public int size(){
        return heap.size();
    }

    public boolean isEmpty(){
      return size()==0;

    }
}
class Element<T>{
    T value;
    int priority;

    public Element(T value, int priority) {
        this.value = value;
        this.priority = priority;
    }
}
class PriorityQueueException extends Exception{
    public PriorityQueueException() {
        super();
    }
}
class PriorityQueueTest{

    public static void main(String[] args) throws PriorityQueueException{

        Priority_Queue<String> pq= new Priority_Queue<String>();
        pq.insert("abc", 15);
        pq.insert("def", 13);
        pq.insert("fsas", 90);
        pq.insert("fsafsafa", 150);
        pq.insert("xvxzxvssa", 120);

        while(!pq.isEmpty()){
            System.out.println(pq.getMin());
            pq.removeMin();
        }

    }
}
