package com.cleo.algorithms.arrays;

import java.util.*;

public class ArrayProblems {

    public static int[] arrayOfProducts(int[] array) {
        // Write your code here.
        int left=1,right=1;
        int[] output = new int[array.length];
        Arrays.fill(output,1);
        for (int i = 0; i < array.length; i++) {
            output[i]=left;
            left*=array[i];
        }
        for (int i = array.length-1; i >=0 ; i--) {
            output[i]*=right;
            right*=array[i];


        }

        return output;
    }
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        int first=0;
        int sum = 0;
        Arrays.sort(array);
        int n = array.length;
        List<Integer[]> output = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            first=array[i];
            for (int j = i+1; j < array.length; j++) {
                if(first+array[j]<=targetSum){
                    sum=first+array[j];
                    int s = n-1;
                    while(sum+array[s]>targetSum&&s>j)
                        s--;
                    if(sum+array[s]==targetSum&&(s!=i)&&(s!=j)){
                        Integer[] temp = {first,array[j],array[s]};
                        if(!output.contains(temp))
                            output.add(temp);


                    }
                }
            }
        }
        for(var c: output){
            System.out.println(Arrays.toString(c));
        }
        return output;
    }
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int n = arrayOne.length,m = arrayTwo.length;
        int[] output = new int[2];
        int diff=0,min_diff=Integer.MAX_VALUE;
        int first=0,second=0;
        while(first<n&&second<m){
            int firstNum=arrayOne[first];
            int secondNum=arrayTwo[second];
            if(firstNum<secondNum){
                diff = secondNum-firstNum;
                first++;
            }else if(firstNum==secondNum){
                return new int[]{firstNum,secondNum};
            }else {
                diff = firstNum - secondNum;
                second++;
            }
            if(min_diff>diff){
                min_diff=diff;
                output[0]=firstNum;
                output[1]=secondNum;
            }

        }
        return output;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int first=m-1;
        int second=n-1;
        int container=first+second+1;
        while(second>=0){
            if(first>=0&&nums1[first]>nums2[second])
                nums1[container]=nums1[first--];
            else
                nums1[container]=nums2[second--];
            container--;

        }


    }
    public int removeElement(int[] nums, int val) {
        int counter=0;
        int n= nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i]!=val){
                int temp=nums[i];
                nums[i]=nums[counter];
                nums[counter]=temp;
                counter++;
            }
        }
        return counter;

    }
    public int removeDuplicates(int[] nums) {
      /*  int n = nums.length;
        int count=0;
        for (int i = n-2; i >=0 ; i--) {
            if(nums[i]==nums[i+1]) {
                nums[i] = nums[i - 1];

            }

        }*/
        int counter=0;
        int n= nums.length;

        int previous=nums[0],current=0;
        for (int i = 1; i < n; i++) {
            current=nums[i];
            if(current!=previous){
                previous=current;
                nums[++counter]=current;
            }
        }
        return counter+1;

    }
    public int removeDuplicatesAtMostTwice(int[] nums) {
        Map<Integer,Integer> frequencyMap = new LinkedHashMap<>();
        for(int num:nums)
            frequencyMap.compute(num,(k,v)->v==null?1:++v);
        int i=0;
        for(var m:frequencyMap.entrySet()){
            int freq=Math.min(m.getValue(),2);
            for (int j = 0; j < freq; j++) {
                nums[i++]=m.getKey();
            }

        }
        return i;


    }



    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 10, 20, 28, 3};
        int[] array2 = new int[]{26, 134, 135, 15, 17};
        int target = 0;
        System.out.println(threeNumberSum(array,target));
        System.out.println(Arrays.toString(smallestDifference(array,array2)));
        System.out.println(Arrays.toString(arrayOfProducts(array)));
        //Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        int[] nums1={1,2,3,0,0,0},nums2={2,5,6};
        int m=3,n=3;
        ArrayProblems problems = new ArrayProblems();
        problems.merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
        int[] a={1};
        int k=2;
        System.out.println(problems.removeDuplicates(a));
        System.out.println(Arrays.toString(a));
        int[] arr={1,1,1,2,2,3,4,4,5,5,5,5};
        System.out.println(problems.removeDuplicatesAtMostTwice(arr));
        System.out.println(Arrays.toString(arr));
    }
}
