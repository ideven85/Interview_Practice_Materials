package com.cleo.algorithms.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenerateSubsequences {

    public static String[] generateSubsequences(String input){
        if(input.isEmpty()){
            String[] ouput = new String[1];
            ouput[0]="";
            return ouput;
        }
        String[] current = generateSubsequences(input.substring(1));
        String[] output = new String[2*current.length];
        System.arraycopy(current,0,output,0,current.length);
        for (int i = 0; i < current.length; i++) {
            output[current.length+i]=input.charAt(0)+current[i];
        }
        return output;
    }
    public static List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> subSets=new ArrayList<>();
        subSets.add(new ArrayList<>());
        for(int num:nums) {
            int n = subSets.size();
            for (int i = 0; i < n; i++) {
                List<Integer> currentSubset = new ArrayList<>(subSets.get(i));
                currentSubset.add(num);
                if(!subSets.contains(currentSubset)) {
                    Collections.sort(currentSubset);
                    subSets.add(currentSubset);
                }
            }
        }
        subSets.remove(0);
        return subSets;
    }
    public static void findSubsets(List<List<Integer>> subset, int[] nums, ArrayList<Integer> output, int index)
    {
        // Base Condition
        if (index == nums.length) {

            subset.add(output);
            return;
        }

        // Not Including Value which is at Index
        findSubsets(subset, nums, new ArrayList<>(output), index + 1);

        // Including Value which is at Index
        output.add(nums[index]);
        findSubsets(subset, nums, new ArrayList<>(output), index + 1);
    }
    public static int[][] subsets(int input[]) {
        // Write your code here
        List<List<Integer>> subsets = new ArrayList<>();
        findSubsets(subsets,input,new ArrayList<>(),0);
        int[][] answer = new int[subsets.size()][];
        int i=0;
        for(List<Integer> set:subsets){
            answer[i]=new int[set.size()];
            int j=0;
            for(int s:set){
                answer[i][j++]=s;
            }
            i++;
        }
        return answer;
    }


    public static void main(String[] args) {
        var s1 = System.nanoTime();
        System.out.println(Arrays.toString(generateSubsequences("abcd")));//5,652,542;175,750
        var s2 = System.nanoTime();
        System.out.println(s2-s1);//4,127,375
        int[] input = {1,2,3};
        int[][] nums = subsets(input);
        for(int[] num:nums)
            System.out.println(Arrays.toString(num));
    }
}
