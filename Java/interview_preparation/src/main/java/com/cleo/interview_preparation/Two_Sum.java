package com.cleo.interview_preparation;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int i=0;
        for(int num:nums){
            if(map.containsKey(target-num)){
                return new int[]{i,map.get(target-num)};

            }
            map.put(num, i);
            i++;
        }
        return new int[]{-1,-1};
        
    }
    
}
