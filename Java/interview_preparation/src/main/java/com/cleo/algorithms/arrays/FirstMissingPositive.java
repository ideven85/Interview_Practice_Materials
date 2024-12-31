package com.cleo.algorithms.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        boolean one = false;
        for (int num : nums) {
            if (num == 1) {
                one = true;
                break;
            }
        }
        if(!one)
            return 1;
        int n = nums.length;
        int count=0;
        for (int num : nums) {
            if (num > 0) {
                count++;
            }

        }
        boolean[] exists = new boolean[count+1];

        for(int num:nums){
            if(num>0&&num<=count)
                exists[num]=true;

        }
        for (int i = 1; i <= count; i++) {
              if(!exists[i])
                  return i;
        }

        return count+1;

    }

    public int[] missingNumbers(int[] nums) {
        // Write your code here.
      Set<Integer> contained = new HashSet<>();
      for(int num:nums)
          contained.add(num);
      int[] answer= new int[]{-1,-1};
        for (int i = 1; i <nums.length+3 ; i++) {
            if (!contained.contains(i)) {
                if (answer[0] == -1)
                    answer[0] = i;
                else {
                    answer[1] = i;
                }
            }
        }

    return answer;
    }

    public static void main(String[] args) {
                     int[] nums = {1,2,3};
        System.out.println(firstMissingPositive(nums));
        FirstMissingPositive missingPositive = new FirstMissingPositive();
        System.out.println(Arrays.toString(missingPositive.missingNumbers(nums)));
    }
}
