package com.cleo.algorithms.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LeetCode{
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), ans, nums);
        return ans;
    }

    public void backtrack(List<Integer> curr, List<List<Integer>> ans, int[] nums) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int num: nums) {
            if (!curr.contains(num)) {
                curr.add(num);
                backtrack(curr, ans, nums);
                System.out.print(curr.get(curr.size()-1)+ " ");
                curr.remove(curr.size() - 1);//Popping Off Last Element..??
            }
        }
    }


}
public class GeneratePermutations {

    static List<List<Integer>> answer = new ArrayList<>();



    public static void permute(int[] nums, int left, int right) {
        if (left == right) {

            List<Integer> temp = new ArrayList<>();
            for (int c : nums) {
                temp.add(c);
            }
            if (!answer.contains(temp))
                answer.add(temp);


        } else {
            for (int i = left; i <= right; i++) {
               swap(nums, i, left);
                permute(nums, left + 1, right);
               swap(nums, i, left);
            }
        }
    }

    public static void  swap(int[] array, int low, int high){
        int temp = array[low];
        array[low]=array[high];
        array[high]=temp;

    }

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        answer.clear();
        int[] temp = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            temp[i]= array.get(i);
        }
        List<Integer> temp1 = new ArrayList<>();
        permute(temp,0,array.size()-1);

        return answer;
    }
    public List<List<Integer>> permute(int[] nums) {
        answer.clear();
        permute(nums,0,nums.length-1);
        return answer;


    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1,2,3,4);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<arr.size();i++)
            list.add(new ArrayList<>());
        list=getPermutations(arr);
        for(var c: list){
            System.out.print(c+"\t");
        }
        System.out.println();
        LeetCode leetCode = new LeetCode();
        list=leetCode.permute(new int[]{1,2,3,4});
        for(var c: list){
            System.out.print(c+ "\t");
        }

    }
}
