package com.cleo.algorithms.greedy;

import java.util.*;

/**
 * Asked in interview last year
 * Cleared the coding round based only on this question's answer
 */
public class LargestNumber {

    static class ValueComparator implements Comparator<String>{



        @Override
        public int compare(String o1, String o2) {
           String order1=o1+o2;
           String order2=o2+o1;
           return order2.compareTo(order1);




        }
    }


    public String largestNumber(int[] nums) {
        int largest=Integer.MIN_VALUE;
        String[] numbers = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(numbers,new ValueComparator());


      //  System.out.println(Arrays.asList(numbers));
        if(numbers[0].equals("0"))
            return "0";
        StringBuilder s1 = new StringBuilder();
        for(var s:numbers){
            s1.append(s);
        }


        return s1.toString();

    }

    public static void main(String[] args) {
        LargestNumber l = new LargestNumber();
        int[] nums = new int[]{10,2};
        int[] nums1 = new int[]{9,5,3,34,30,321};

        int value = (int)Math.pow(10,9);
        System.out.println(l.largestNumber(nums));

        System.out.println(l.largestNumber(nums1));
    }
}
