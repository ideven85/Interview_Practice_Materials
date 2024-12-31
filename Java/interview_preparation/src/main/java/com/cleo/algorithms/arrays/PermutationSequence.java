package com.cleo.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public  String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact=1;
        for (int i = 1; i < n; i++) {
            fact*=i;
            numbers.add(i);
        }
        numbers.add(n);
        String answer = "";
        k-=1;
        while(true){
            answer = answer+numbers.get(k/fact);
         //   System.out.println(k);
            numbers.remove(k/fact);
            System.out.println(numbers.size());
            if(numbers.size()==0)
                break;
            k = k%fact;
            fact = fact/numbers.size();
        }
        return answer;
    }

    public static void main(String[] args) {
        PermutationSequence pm = new PermutationSequence();
        System.out.println(pm.getPermutation(3,1));
    }
}
