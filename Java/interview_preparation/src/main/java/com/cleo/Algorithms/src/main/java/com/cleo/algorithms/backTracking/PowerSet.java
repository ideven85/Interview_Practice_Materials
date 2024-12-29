package com.cleo.algorithms.backTracking;

import java.util.*;

public class PowerSet {
    private static List<List<Integer>> list = new ArrayList<>();


    public static void generatePowerSets(List<Integer> array, int low, int high){
        if(low==high){
           // System.out.print(array+ " ");
                if(!list.contains(array))
                    list.add(array);

        }
        for (int i = low; i <=high ; i++) {
          // array= new ArrayList<>( swap(array,i,low));

            generatePowerSets(array,low+1,high);
            //array=new ArrayList<>(swap(array,i,low));
          //  System.out.println(array);

        }
    }
    public static List<Integer> swap(List<Integer> array,int low,int high){
        int temp = array.get(low);
        array.set(low,array.get(high));
        array.set(high,temp);
        return array;

    }

    public static List<List<Integer>> powerset(List<Integer> array) {
        // Write your code here.
        int n = array.size();

        for (int i = 1; i <= n/2; i++) {
            generatePowerSets(array.subList(0,i+1),0,i);


            generatePowerSets(array.subList(i-1,n),i-1,n);
        }
        return list;
    }
    public static List<List<Integer>> powerSet(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = array.size();
      // List<Integer> currentSubset = new ArrayList<>();
        result.add(new ArrayList<>());

        for (var e:array) {
            //System.out.println(result);
            int length = result.size();
            for (int i = 0; i < length; i++) {
                List<Integer> currentSubset = new ArrayList<>(result.get(i));
                currentSubset.add(e);

                if(!result.contains(currentSubset))
                    result.add(currentSubset);

            }

        }
        result.remove(0);
        return result;
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
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
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1,2,2);
        System.out.println(powerSet(array));
        System.out.println(subsetsWithDup(new int[]{1,2,2}));


    }
}
