package com.cleo.algorithms.heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class CheckMaxHeap {
    public static boolean checkMaxHeap(int arr[]) {
        /*
         * Your class should be named Solution Don't write main(). Don't read input, it
         * is passed as function argument. Return output and don't print it. Taking
         * input and printing output is handled automatically.
         */
        int n = arr.length;
        if(n==0)
            return true;
        //System.out.println(Arrays.toString(arr));
       Queue<Integer> pq = new PriorityQueue<Integer>((a,b)->b-a);
        for(int el:arr){
            pq.add(el);
        }
        System.out.println(pq);
        for (int j : arr) {
            if (j != pq.remove())
                return false;

        }
       // System.out.println(Arrays.toString(arr));
        return true;


    }

    public static void main(String[] args) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
      //  System.out.println(maxHeap);
        int[] arr = {10,6,2,1,5,1};
        maxHeap.addAll(Arrays.asList(10,6,2,1,5,1));
        while(!maxHeap.isEmpty()){
            System.out.print(maxHeap.poll()+ " ");
        }
        System.out.println(checkMaxHeap(arr));

    }
}
