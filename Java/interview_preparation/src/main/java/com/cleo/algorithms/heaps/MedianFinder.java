package com.cleo.algorithms.heaps;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// TODO: 15/08/23 Re do the whole question 
class MedianFinder {

    Queue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);

    Queue<Integer> minPQ = new PriorityQueue<>();
    int totalNum = 0;
    boolean isNumLessThanZero = false;

    public MedianFinder() {

    }

    public void addNum(int num) {
        totalNum += 1;

        if (maxPQ.isEmpty()) {
            maxPQ.offer(num);
            return;
        }

        if (minPQ.isEmpty() && num >= maxPQ.peek()) {
            minPQ.offer(num);
            return;
        }

        if (num < maxPQ.peek()) {
            //can i put in maxPQ
            if (maxPQ.size() - minPQ.size() > 0)
                minPQ.offer(maxPQ.poll());
            maxPQ.offer(num);

        } else if (num > minPQ.peek()) {
            //can i put in min
            if (!(minPQ.size() < maxPQ.size()))
                maxPQ.offer(minPQ.poll());
            minPQ.offer(num);

        } else {
            if (minPQ.size() == maxPQ.size()) {
                maxPQ.offer(num);
            } else {
                minPQ.offer(num);
            }
        }


    }

    public double findMedian () {

        double val = 0;
        if (totalNum % 2 == 0) {
            val = (double) (maxPQ.peek() + minPQ.peek()) / 2;

        } else {

            val = maxPQ.peek();
        }

        return val;

    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(2);
        obj.addNum(3);
        System.out.println(obj.findMedian());
        obj.addNum(1);
        System.out.println(obj.findMedian());

    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

// Do not edit the class below except for
// the insert method. Feel free to add new
// properties and methods to the class.
class Program {
    static class ContinuousMedianHandler {
        public double getMedian() {
            return median;
        }

        double median = 0;
        List<Integer> heap = new ArrayList<>();

        public void insert(int number) {
            heap.add(number);
            MinHeap minHeap = new MinHeap(heap);
            int size = minHeap.heap.size();
            //int mid=size/2;
            if(size%2==0)
                median=(minHeap.heap.get(size/2)+ (double) (minHeap.heap.get(size + 1) /2))/2.0;
            else
                median=minHeap.heap.get(size/2)*1.0;
        }

    }

    static class MinHeap {




        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            // Write your code here.
            int firstIndex=(array.size()-2)/2;
            for (int i = firstIndex; i >=0 ; i--) {
                siftDown(firstIndex,array.size()-1,array);
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
            while(currentIdx>=0&&heap.get(currentIdx)<heap.get(parentIdx)){
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
            int temp = heap.get(i);
            heap.set(i,heap.get(j));
            heap.set(j,temp);
        }

    }
}