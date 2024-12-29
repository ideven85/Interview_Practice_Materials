package com.cleo.algorithms.heaps;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * Heap is a complete binary tree and maintains heap property
     */
    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            // Write your code here.
            int firstIndex=(array.size()-2)/2;
            for (int i = firstIndex; i >=0 ; i--) {
                siftDown(i,array.size()-1,array);
            }
            return array;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            // Write your code here.
            int childOneIdx=currentIdx*2+1,childTwoIdx=1,idxToSwap;
            while(childOneIdx<=endIdx){
                childTwoIdx=2*currentIdx+2<=endIdx?2*currentIdx+2:-1;
                if(childTwoIdx!=-1&&heap.get(childTwoIdx)<heap.get(childOneIdx))
                    idxToSwap=childTwoIdx;
                else
                    idxToSwap=childOneIdx;
                if(heap.get(idxToSwap)<heap.get(currentIdx)) {
                    swap(currentIdx, idxToSwap, heap);
                    currentIdx=idxToSwap;
                    childOneIdx=currentIdx*2+1;
                }else
                    break;



            }
        }

        public void siftUp(int currentIdx, List<Integer> heap) {
            // Write your code here.

            int parentIdx = (currentIdx-1)/2;
            while(currentIdx>0&&heap.get(currentIdx)<heap.get(parentIdx)){
                swap(currentIdx,parentIdx,heap);
                currentIdx=parentIdx;
                parentIdx=(currentIdx-1)/2;
            }

        }

        public int peek() {
            // Write your code here.
            return heap.get(0);
        }

        public int remove() {
            // Write your code here.
            swap(0,heap.size()-1,heap);
            int valueToRemove = heap.get(heap.size()-1);
            heap.remove(heap.size()-1);
            siftDown(0,heap.size()-1,heap);
            return valueToRemove;
        }

        public void insert(int value) {
            // Write your code here.
            heap.add(value);
            siftUp(heap.size()-1,heap);
        }
        public void swap(int i, int j, List<Integer> heap){
            int temp = heap.get(j);
            heap.set(j,heap.get(i));
            heap.set(i,temp);
        }

    }

    public static void main(String[] args) {

    }
}
