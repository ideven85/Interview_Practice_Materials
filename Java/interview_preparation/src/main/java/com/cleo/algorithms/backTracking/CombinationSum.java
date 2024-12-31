package com.cleo.algorithms.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    // TODO: 26/08/23

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return null;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> output = new ArrayList<>();
        findWays(candidates, target, new ArrayList<>(), output, 0);
        return output;
    }
    private  void findWays(int[] input, int target, List<Integer> tempList, List<List<Integer>> output, int startIndex) {

        if (target == 0) {
            output.add(new ArrayList<>(tempList));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = startIndex; i < input.length && target >= input[i]; i++) {
            if (i > startIndex && input[i] == input[i - 1])
                continue;
            tempList.add(input[i]);
            findWays(input, target - input[i], tempList, output, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
