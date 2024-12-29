package com.cleo.algorithms.dynamicProgramming;

public class MaximumSubSumNonAdjacent {
    public static long maxSubsetSumNoAdjacent(int[] array) {
        if(array.length==0)
            return 0;
        else if(array.length==1)
            return array[0];
        // Write your code here.
        long first=Math.max(array[0],array[1]),second=array[0],current=0;
        for (int element = 2; element < array.length; element++) {


            current=Math.max(first,second+array[element]);
            second=first;
            first=current;




        }
        System.out.println(second);
        return first;
    }

    public static void main(String[] args) {
        int[] arr = {-366, 50, 677, -13, -33, -923, 495, -851};
        System.out.println(maxSubsetSumNoAdjacent(arr));
    }
}
