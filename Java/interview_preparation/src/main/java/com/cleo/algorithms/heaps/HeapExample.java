package com.cleo.algorithms.heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapExample {
    public static void main(String[] args) {
        Queue<Integer> minHeap = new PriorityQueue<>(Arrays.asList(1,3,2,4,-1));
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(Arrays.asList(1,3,2,4));
        System.out.println(minHeap);
        System.out.println(maxHeap);
    }
}
