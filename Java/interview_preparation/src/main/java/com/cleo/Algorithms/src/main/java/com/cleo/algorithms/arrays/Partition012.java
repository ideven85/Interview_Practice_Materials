package com.cleo.algorithms.arrays;

import java.util.Arrays;

public class Partition012 {

    public static void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left]=array[right];
        array[right]=temp;
    }
    public static void partition(int[] array){
        int left = 0,right = array.length -1,i=0;
        if(right==0)
            return;
        while(i<=right){
            if(array[i]==0) {
                swap(array, i, left);
                i+=1;left+=1;
            }
           else if(array[i]==2) {
                swap(array, i, right);
                right-=1;
            }else
                i+=1;



        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,0,1,2,0};
        partition(arr);
        System.out.println(Arrays.toString(arr));
    }
}
