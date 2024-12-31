package com.cleo.algorithms.arrays;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;

public class SumArrays {
    public static void sumOfTwoArrays(int arr1[], int arr2[], int output[]) {
        int first = Integer.parseInt(Arrays.toString(arr1));
        int second = Integer.parseInt(Arrays.toString(arr2));
        System.out.println(first);
        int sum = first+second;
        output = new int[arr1.length+arr2.length+1];
        for (int i = output.length-1; i >=0; i--) {
            output[i]=sum%10;
            sum/=10;

        }
        for(int num:output){
            System.out.print(num + " ");
        }

    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4};
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = {9,1};
        //int[] output = new int[arr1.length+arr2.length];
        //sumOfTwoArrays(arr1,arr2,output);
       // System.out.println(Arrays.toString(output));
    }
}