package com.cleo.algorithms.dynamicProgramming;

import java.util.*;
class Solution1 {

  private final   Map<Integer,Integer> map = new HashMap<>();
  private final Map<Integer,Integer> cache = new HashMap<>();

    private int maxPoints(int number){
        if(number==0)
            return 0;
        if(number==1)
            return map.getOrDefault(1,0);
        if(cache.containsKey(number))
            return cache.get(number);

        int gain = map.getOrDefault(number,0);

        cache.put(number,Math.max(gain+maxPoints(number-2),maxPoints(number-1)));
        return cache.get(number);

    }
    public int deleteAndEarn(int[] nums) {
     //   Arrays.sort(nums);
        int maxNumber=0;
        for(int num:nums) {
            map.put(num, map.getOrDefault(num, 0) + num);
            if(maxNumber<num)
                maxNumber=num;
        }

      return   maxPoints(maxNumber);




    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] nums = {2,2,3,3,3,4};
        System.out.println(solution1.deleteAndEarn(nums));
    }
}
class DeleteAndEarnSlower{
    private final HashMap<Integer, Integer> points = new HashMap<>();
    private HashMap<Integer, Integer> cache = new HashMap<>();

    private int maxPoints(int num) {
        // Check for base cases
        if (num == 0) {
            return 0;
        }

        if (num == 1) {
            return points.getOrDefault(1, 0);
        }

        if (cache.containsKey(num)) {
            return cache.get(num);
        }

        // Apply recurrence relation
        int gain = points.getOrDefault(num, 0);
        cache.put(num, Math.max(maxPoints(num - 1), maxPoints(num - 2) + gain));
        return cache.get(num);
    }

    public int deleteAndEarn(int[] nums) {
        int maxNumber = 0;

        // Precompute how many points we gain from taking an element
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }

        return maxPoints(maxNumber);
    }
}
public class DeleteAndEarn {

    public int deleteAndEarnBest(int[] nums) {
        int maxNumber = 0;
        HashMap<Integer, Integer> points = new HashMap<>();

        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }

        int twoBack = 0;
        int oneBack = 0;
        int n = points.size();

        if (maxNumber < n + n * Math.log(n) / Math.log(2)) {
            oneBack = points.getOrDefault(1, 0);
            for (int num = 2; num <= maxNumber; num++) {
                int temp = oneBack;
                oneBack = Math.max(oneBack, twoBack + points.getOrDefault(num, 0));
                twoBack = temp;
            }
        } else {
            List<Integer> elements = new ArrayList<Integer>(points.keySet());
            Collections.sort(elements);
            oneBack = points.get(elements.get(0));

            for (int i = 1; i < elements.size(); i++) {
                int currentElement = elements.get(i);
                int temp = oneBack;
                if (currentElement == elements.get(i - 1) + 1) {
                    oneBack = Math.max(oneBack, twoBack + points.get(currentElement));
                } else {
                    oneBack += points.get(currentElement);
                }

                twoBack = temp;
            }
        }

        return oneBack;
    }

    public int deleteAndEarnOptimised(int[] nums) {
        HashMap<Integer, Integer> points = new HashMap<>();

        // Precompute how many points we gain from taking an element
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
        }

        List<Integer> elements = new ArrayList<Integer>(points.keySet());
        Collections.sort(elements);

        // Base cases
        int twoBack = 0;
        int oneBack = points.get(elements.get(0));

        for (int i = 1; i < elements.size(); i++) {
            int currentElement = elements.get(i);
            int temp = oneBack;
            if (currentElement == elements.get(i - 1) + 1) {
                // The 2 elements are adjacent, cannot take both - apply normal recurrence
                oneBack = Math.max(oneBack, twoBack + points.get(currentElement));
            } else {
                // Otherwise, we don't need to worry about adjacent deletions
                oneBack += points.get(currentElement);
            }

            twoBack = temp;
        }

        return oneBack;
    }

    public int deleteAndEarnMemoized(int[] nums) {
        int maxNumber = 0;
        HashMap<Integer, Integer> points = new HashMap<>();

        // Precompute how many points we gain from taking an element
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }

        // Base cases
        int twoBack = 0;
        int oneBack = points.getOrDefault(1, 0);

        for (int num = 2; num <= maxNumber; num++) {
            int temp = oneBack;
            oneBack = Math.max(oneBack, twoBack + points.getOrDefault(num, 0));
            twoBack = temp;
        }

        return oneBack;
    }
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> points = new HashMap<>();
        int maxNumber = 0;

        // Precompute how many points we gain from taking an element
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }

        // Declare our array along with base cases
        int[] maxPoints = new int[maxNumber + 1];
        maxPoints[1] = points.getOrDefault(1, 0);

        for (int num = 2; num < maxPoints.length; num++) {
            // Apply recurrence relation
            int gain = 0;
            gain = points.getOrDefault(num, 0);
            maxPoints[num] = Math.max(maxPoints[num - 1], maxPoints[num - 2] + gain);
        }
        System.out.println(Arrays.toString(maxPoints));

        return maxPoints[maxNumber];
    }


    public static void main(String[] args) {
        int[] nums ={5,2,2,3,4,2};
        DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
        DeleteAndEarnSlower deleteAndEarnSlower = new DeleteAndEarnSlower();
        System.out.println(deleteAndEarn.deleteAndEarn(nums));
        System.out.println(deleteAndEarn.deleteAndEarnMemoized(nums));
        System.out.println(deleteAndEarn.deleteAndEarnOptimised(nums));
        System.out.println(deleteAndEarnSlower.deleteAndEarn(nums));
    }

}
