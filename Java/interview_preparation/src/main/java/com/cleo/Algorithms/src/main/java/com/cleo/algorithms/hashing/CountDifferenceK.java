package com.cleo.algorithms.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountDifferenceK {
    public static int getPairsWithDifferenceK(int arr[], int k) {
        //Write your code here
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int count =0;
        for (int j : arr) {
            if (hashMap.containsKey(j)) {
                hashMap.put(j, hashMap.get(j) + 1);
            } else hashMap.put(j, 1);
            if (k == 0) count += hashMap.get(j) - 1;
        }
        if (k==0) return count;
        for (int j : arr) {
            if (hashMap.containsKey(j - k)) {
                count += hashMap.get(j - k);
                hashMap.remove(j);
            }
            if (hashMap.containsKey(j + k)) {
                count += hashMap.get(j + k);
                hashMap.remove(j);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,1,2,1};
        System.out.println(getPairsWithDifferenceK(nums,0));
    }
}
