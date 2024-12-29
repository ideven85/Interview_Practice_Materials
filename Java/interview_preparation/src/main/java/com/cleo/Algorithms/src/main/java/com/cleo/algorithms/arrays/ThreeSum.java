package com.cleo.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.binarySearch;


public class ThreeSum {

    /*public int binarySearch(int[] array, int target){
        int low=0,high=array.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(target==array[mid])
                return mid;
            else if(target<array[mid])
                high=mid-1;
            else if(target>array[mid])
                low=mid+1;
        }
        return -1;
    }

     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        int low=0,high=n-1;
        Arrays.sort(nums);
        int closest =Integer.MAX_VALUE;
        int first=0;
        for (int i = 0; i < n-2; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                first = -nums[i];
                low = i + 1;
                high = n - 1;
                while (low < high) {
                    if (nums[low] + nums[high] == first) {
                        list.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (nums[low] == nums[low + 1] && low < n - 2)
                            low += 1;
                        while (nums[high] == nums[high - 1] && high > 1)
                            high -= 1;
                        low += 1;
                        high -= 1;
                    } else {
                        if (nums[low] + nums[high] > first)
                            high -= 1;
                        else
                            low += 1;
                    }
                }


            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-1,0,1,2,-1,-4};
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(array));

    }
}
