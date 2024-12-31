package com.cleo.algorithms.arrays;

import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.
        int temp = 0;
        
        for (int i = 0; i < array.size(); i++) {
            if(array.get(i)!=toMove){
                int tmp = array.get(i);
                array.set(i,array.get(temp));
                array.set(temp,tmp);
                temp+=1;
            }
        }


        return array;
    }
    public static void moveZeroes(int[] nums) {
        int temp=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                int tmp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=tmp;
                temp+=1;
            }
        }
    }

    public static void main(String[] args) {
        var a = Arrays.asList(0,1,0,3,12);
        System.out.println(moveElementToEnd(a,2));
        int[] nums = new int[]{0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
