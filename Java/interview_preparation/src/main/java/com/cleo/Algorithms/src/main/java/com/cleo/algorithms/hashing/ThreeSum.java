package com.cleo.algorithms.hashing;

import java.util.*;

public class ThreeSum {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        List<Integer[]> list = new ArrayList<>();
        Arrays.sort(array);
        int low = 0,high=array.length-1;
    //    List<Integer> temp = new ArrayList<>();
        int s=0;
        for (int i = low; i <=high ; i++) {
         //   temp = new ArrayList<>();
            int sum=array[i];




         //   temp.add(array[i]);
            for (int j = i+1; j <=high ; j++) {
               if(sum+array[j]<=targetSum) {
              //     temp.add(array[j]);
                  sum+=array[j];
                  s = high;
                  if(sum+array[s]>targetSum)

                   while(sum+array[s]>targetSum&&s>j)
                     s--;
                   if(s!=j) {

                       if (sum + array[s] == targetSum) {
               //            temp.add(array[high]);
                           if (!list.contains(new Integer[]{array[i], array[j], array[s]})) {
                               list.add(new Integer[]{array[i], array[j], array[s]});

                           }
                       }
                   }
                  sum=array[i];
               }

            }
        }
        return list;
    }
    public  static List<List<Integer>> threeSum(int[] array) {
        List<List<Integer>> list = new ArrayList<>();
        int targetSum=0;
        Arrays.sort(array);
        int low = 0,high=array.length-1;
         //   List<Integer> temp = new ArrayList<>();
        int s=0;
        for (int i = low; i <=high ; i++) {
          //     temp = new ArrayList<>();

            int sum=array[i];
            if(sum>0)
                break;



           //    temp.add(array[i]);
            for (int j = i+1; j <=high ; j++) {
                if(sum+array[j]<=targetSum) {
                //         temp.add(array[j]);
                    sum+=array[j];
                    s = high;
                    if(sum+array[s]>targetSum)

                        while(sum+array[s]>targetSum&&s>j)
                            s--;
                    if(s!=j) {

                        if (sum + array[s] == targetSum) {
                                    //    temp.add(array[high]);
                            if (!list.contains(List.of(array[i],array[j],array[s]))) {
                                list.add(List.of(array[i],array[j],array[s]));

                            }
                        }
                    }
                    sum=array[i];
                }

            }
        }
        return list;

    }

    public List<List<Integer>> threeSumReference(int[] nums) {
            Arrays.sort(nums);

            Map<Integer,Integer> mp = new HashMap<>();
            List<List<Integer>> ans = new ArrayList<>();
            int n = nums.length, i ,j,k,sum;

            // Map to store last occurenece of each element
            for(i=0;i<n;i++){
                mp.put(nums[i],i);
            }

            i=0;

            while(i<n){
                //if numbers are positive there sum can never be 0
                if(nums[i]>0){
                    break;
                }

                j=i+1;
                while(j<n){
                    sum = nums[i]+nums[j];
                    // re-rwrite the equation to make it on 2 variables nums[k] =-1*(nums[i]+nums[j])
                    sum = -1*sum;
                    //check if nums[k] is present and its occurence is after nums[i] and nums[j] to avoid dupes
                    if(mp.containsKey(sum) && mp.get(sum)>j){
                        ans.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],sum)));
                    }
                    j=mp.get(nums[j])+1;
                }
                i=mp.get(nums[i])+1;
            }
            return ans;
        }


    public static void main(String[] args) {
        int[] arr = {12,3,1,2,-6,5,-8,6};
        var list = threeNumberSum(arr,0);
        for(var e:list)
            System.out.println(e[0]+" "+e[1]+" "+e[2]);
        System.out.println(threeSum(arr));
    }
}
