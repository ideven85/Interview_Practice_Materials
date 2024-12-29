package com.cleo.algorithms.backTracking;

import java.util.*;
import java.util.stream.IntStream;

public class Subsets {

 private final List<List<Integer>> subsets = new ArrayList<>();
   public void generateSubsets(int[] arr, int low,int high, int k){
       //  System.out.println(Arrays.toString(arr));
        if(high==low){
            //System.out.println(high+" " + low);
            List<Integer> temp = new ArrayList<>();
            for(int c: arr)
                temp.add(c);
            if(!subsets.contains(temp))
                subsets.add(temp);
        }else{
            for (int i = low; i <=high ; i++) {
                swap(arr,i,low);
                generateSubsets(arr,low+1,high,k);
                swap(arr,i,low);
            }
        }


    }
    public  void  swap(int[] array, int low, int high){
        int temp = array[low];
        array[low]=array[high];
        array[high]=temp;

    }
    public List<List<Integer>> combine(int n, int k) {

        int[][] arr = new int[n][k];
        for (int i = 1; i <=n ; i++) {
            for (int j = i; j <=k ; j++) {
                arr[i-1][j-1]=j;
            }
        }
        for(int[] a:arr)
            System.out.println(Arrays.toString(a));
        for (int i = 1; i <=n; i++) {
            for (int j = 0; j < k; j++) {


                generateSubsets(arr[i - 1], i, arr[i - 1].length - 1, j);
            }
        }

        return subsets;
    }



    public static void main(String[] args) {
        Subsets subsets1 = new Subsets();
      System.out.println(subsets1.combine(4,2));

    }
}
