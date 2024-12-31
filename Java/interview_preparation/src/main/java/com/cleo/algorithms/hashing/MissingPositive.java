package com.cleo.algorithms.hashing;

import java.util.Arrays;

public class MissingPositive {

    public static int missingNumber(int[] nums) {
       int missing;
       boolean zero=false;
       int n =nums.length;
        for (int i = 0; i <n ; i++) {

                if(nums[i]==0)
                    zero=true;
                while (nums[i] != i+1 && nums[i] > 0) {
                    missing = nums[i];
                    nums[i] = nums[missing - 1];
                    nums[missing - 1] = missing;
                }
            if(nums[i]==0)
                zero=true;
            }


        System.out.println(Arrays.toString(nums));
        System.out.println(zero);
        if(!zero)
            return 0;
        for (int i = 0; i < n; i++) {
            if(nums[i]!=i+1)
                return i+1;
        }
        return -1;


    }
   static void swap(int[] arr,int i,int correct) {
        int temp=arr[i];
        arr[i]= arr[correct];
        arr[correct]= temp;
    }
    public static int missingNumberV2(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i];
            if (arr[i] < arr.length && arr[i] != arr[correct]) {
                swap(arr, i , correct);
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
        // search for first missing number
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index+1) {
                return index+1;
            }
        }

        // case 2
        return arr.length+1;
    }
    public static int SmallestPositiveMissingNumber4(int[] arr, int size)
    {
        int temp;
        for (int i = 0; i < size; i++)
        {

            while (arr[i] != i + 1 && arr[i] > 0 && arr[i] <= size)
            {
                temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }



            for (int i = 0; i < size; i++) {
                if (arr[i] != i + 1)
                    return i + 1;
            }
            return size+1;

    }


    public static void main(String[] args) {
        int[] nums= {1,2,3,4,5};
        System.out.println(missingNumberV2(nums));
        System.out.println("New:"+SmallestPositiveMissingNumber4(nums,nums.length));
    }
}
