package com.cleo.algorithms.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.cleo.algorithms.arrays.CircularArrayRotation.circularArrayRotation;
import static com.cleo.algorithms.arrays.FirstDuplicateValue.firstDuplicateValue;
import static com.cleo.algorithms.arrays.IsValidSubsequence.isValidSubsequence;
import static com.cleo.algorithms.arrays.MoveElementToEnd.moveElementToEnd;

public class Main {

    public static int singleNumber(int[] nums) {
        int result=-1;
        /*
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.compute(num,(k,v)->v==null?1:++v);
        }
        for(var m:map.entrySet()){
            if(m.getValue()==1)
                return m.getKey();
        }

         */
        int sum=Arrays.stream(nums).sum();
        for (int num : nums) {
            sum -= num;

        }
        return -1;


    }
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1,2,3,4);
        List<Integer> queries = Arrays.asList(1,2);
        System.out.println(circularArrayRotation(a,3,queries));
        List<Integer> s1 = List.of(1,3,4);
        List<Integer> s2 = List.of(1,4);
        System.out.println(isValidSubsequence(s1,s2));
        List<Integer> moveToEnd=Arrays.asList(2,1,2,2,2,2,3,4,2);
        System.out.println(moveElementToEnd(moveToEnd,2));
        int[] arr = new int[]{2,1,5,2,3,3,4};
        System.out.println(firstDuplicateValue(arr));
        arr = new int[]{ 2, 3, 2, 2 };
        System.out.println(singleNumber(arr));

    }
}
