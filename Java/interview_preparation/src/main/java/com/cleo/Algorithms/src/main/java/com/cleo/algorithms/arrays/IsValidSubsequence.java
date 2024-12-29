package com.cleo.algorithms.arrays;

import java.util.List;

public class IsValidSubsequence {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        int i = 0,j=0;
        while(i<array.size()&&j<sequence.size()){
            if(array.get(i).equals(sequence.get(j))){
                j++;
            }
            if(j==sequence.size())
                return true;
            i++;
        }
        return j==sequence.size();
    }

}
