package com.cleo.algorithms.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class HeapSort {
    public static void inplaceHeapSort(int[] arr) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Change in the given input itself.
         * Taking input and printing output is handled automatically.
         */
       int n=arr.length;
       int mid=n/2;
       for(int i = mid-1; i >=0; i--) {
            downHeapify(arr,i,n);
       }
       // System.out.println(Arrays.toString(arr));

        for(int i=n-1;i>=0;i--){
            int temp= arr[i];
            arr[i]= arr[0];
            arr[0]= temp;
           downHeapify(arr,0,i);
        }


    }


    private static void downHeapify(int[] arr, int i, int n) {
        int parentIndex = i;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        while (leftChildIndex < n) {
            int minIndex = parentIndex;
            if (arr[leftChildIndex] < arr[minIndex]) {
                minIndex = leftChildIndex;
            }

            if (rightChildIndex < n && arr[rightChildIndex] < arr[minIndex]) {
                minIndex = rightChildIndex;
            }
            if (minIndex == parentIndex) {
                return;
            }
            int temp = arr[parentIndex];
            arr[parentIndex] = arr[minIndex];
            arr[minIndex] = temp;
            parentIndex = minIndex;
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;

        }
    }


    public static void heapSortV1(int[] arr){
        //Build the heap
        int n= arr.length;
        for(int i=(n/2)-1; i>=0;i--){
            downHeapify(arr,i,n);
        }
        //Remove elemts from starting one by one, and put them at respective last position
        for(int i=n-1;i>=0;i--){
            int temp= arr[i];
            arr[i]= arr[0];
            arr[0]= temp;
            downHeapify(arr, 0,i);
        }
    }

    private static void heapifyDown(int[] arr, int currentIndex, int end) {
        int leftChild=2*currentIndex+1;
        int rightChild=-1,indexToSwap;
        while(leftChild<=end){
            rightChild=currentIndex*2+2<=end?currentIndex*2+2:-1;
            if(rightChild!=-1&&arr[rightChild]<arr[leftChild])
                indexToSwap=rightChild;
            else
                indexToSwap=leftChild;
            if(arr[currentIndex]>arr[indexToSwap]){
                int temp=arr[currentIndex];
                arr[currentIndex]=arr[indexToSwap];
                arr[indexToSwap]=temp;
                currentIndex=indexToSwap;
                leftChild=currentIndex*2+1;
            }else
                break;

        }


    }

    private static int removeMax(int current,int[] arr){
        swap(arr,current,arr.length-1);
        int answer=arr[arr.length-1];
        heapifyDown(arr,current,arr.length-1);
        return answer;
    }

    private static void swap(int[] arr, int first,int last ){
        int temp=arr[first];
        arr[first]=arr[last];
        arr[last]=temp;
}



   /* public static void InplaceHeapSort()

    {
        int parentIndex = i;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        whlie(leftChildIndex < n) {
        int minIndex = parentIndex;
        if (arr[leftChildIndex] < arr[minIndex]) {
            minIndex = leftChildIndex;
        }

        if (rightChild < n && arr[rightChildIndex] < arr[minIndex]) {
            minIndex = rightChlidIndex;
        }
        if (minIndex == parentIndex) {
            return;
        }
        int temp = arr[parentIndex];
        arr[parentIndex] = arr[minIndex];
        arr[minIndex] = temp;
        parentIndex = minIndex;
        leftChildIndex = 2 * parentIndex + 1;
        rightChildIndex = 2 * parentIndex + 2;

    }
    }


   public static void heapSort(int[] arr) {
        //Build the heap
        int n = arr.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            downHeapify(arr, i, n);
        }
        //Remove elemts from starting one by one, and put them at respective last position
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            downHeapify(arr, 0, i);
        }
    }

   */


    public static void main (String[]args){
        int[] arr = {4, 7, 3, 2, 8, 9, 6, 1};
        //heapSort(arr);
       inplaceHeapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    }

