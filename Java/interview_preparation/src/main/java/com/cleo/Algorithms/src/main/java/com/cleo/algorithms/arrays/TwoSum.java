package com.cleo.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TwoSum {

    private final List<Integer> list;

    public TwoSum() {
      list = new ArrayList<>();

    }

    public void add(int number) {
        list.add(number);

    }

    public boolean find(int value) {
        if(list.size()<2)
            return false;
        for(int val:list){

            if(!list.contains(value-val))
                continue;

            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        twoSum.add(1);
        twoSum.add(3);
        twoSum.add(7);
        System.out.println(twoSum.find(4));
    }
}
