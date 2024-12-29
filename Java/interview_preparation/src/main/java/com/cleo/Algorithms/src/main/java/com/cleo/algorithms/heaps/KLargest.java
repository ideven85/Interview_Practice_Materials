package com.cleo.algorithms.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KLargest{
    public static void printKLargest(int[] arr, int k){
        PriorityQueue<Integer> pq= new PriorityQueue<Integer> ();

        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }

        for(int i=k; i<arr.length;i++){
            if(pq.peek()<arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        }

        System.out.println(pq.poll());

    }
    public static ArrayList<Integer> kLargest(int[] arr, int k) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        ArrayList<Integer> output = new ArrayList<>();
        PriorityQueue<Integer> pq= new PriorityQueue<Integer> ((a,b)->b-a);

        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }

        for(int i=k; i<arr.length;i++){
            if(pq.peek()>arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        while(!pq.isEmpty()){
            output.add(pq.poll());
        }
        Collections.reverse(output);
        return output;


    }
    public static void main(String[] args){
        int[] arr={2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6};
        int k= 4;
        printKLargest(arr,k);
    }
}
