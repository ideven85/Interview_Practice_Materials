package com.cleo.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public ArrayList<Integer> nextPermutation(ArrayList<Integer> nums) {
        int len = nums.size();
        if (len == 0 || len == 1)
            return nums;
        // step 1: find the index i where nums[i] < nums[j]
        int i = len-2;
        while (i>=0 && nums.get(i)>=nums.get(i+1))
            i -= 1;
        // step 2: applicable only if we find an index from step 1
        // (a) find index j from BACK which is greater than nums[i]
        // (b) swap i & j elements
        if (i >= 0) {
            int j = len-1;
            while (j>=0 && nums.get(j)<=nums.get(i))
                j--;
            swap(nums, i, j);
        }
        // step 3: Reverse the array after the break point 'i'
        reverse(nums, i+1, len-1);
        return nums;
    }

    private void swap(ArrayList<Integer> nums, int left, int right) {
        int temp = nums.get(right);
        nums.set(right,nums.get(left));
        nums.set(left,temp);
    }

    private void reverse(ArrayList<Integer> nums, int to, int from) {
        int left = to, right = from;
        while (left <= right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}
class Solution2 {
    public void nextPermutation(int[] A) {
        if(A == null || A.length <= 1) return;
        int i = A.length - 2;
        while(i >= 0 && A[i] >= A[i + 1]) i--; // Find 1st id i that breaks descending order
        if(i >= 0) {                           // If not entirely descending
            int j = A.length - 1;              // Start from the end
            while(A[j] <= A[i]) j--;           // Find rightmost first larger id j
            swap(A, i, j);                     // Switch i and j
        }
        reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }
}
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums =new int[]{3,2,1};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
