package com.cleo.algorithms.greedy;

import java.util.*;
import java.util.stream.Collectors;

public class ActivityScheduling {

    static class Activity{
        int index,time;

        public Activity(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }
    static class ActivitySortComparator implements Comparator<Activity>{
        @Override
        public int compare(Activity o1, Activity o2) {
            return o1.time - o2.time;
        }
    }


    public static ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        // Write your code here.

       List<Activity> activitySet = new ArrayList<>();

        for (int i = 0; i < 2*k; i++) {
            activitySet.add(new Activity(i,tasks.get(i)));
        }
      activitySet.sort(new ActivitySortComparator());
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        for(Activity activity: activitySet){
            System.out.println(activity.index+ ":" + activity.time);
        }
        for (int i = 0; i < k; i++) {
            output.add(new ArrayList<>());
        }
        for (int i = 0; i < k; i++) {
            output.get(i).add(activitySet.get(i).index);
            output.get(i).add(activitySet.get(2*k-i-1).index);
            output.get(i).sort(Comparator.naturalOrder());

        }



        return output;
    }

    public static void main(String[] args) {
        int k=3;
        ArrayList<Integer> tasks = new ArrayList<>();
        tasks.add(1);tasks.add(3);tasks.add(5);tasks.add(3);tasks.add(4);tasks.add(1);
        System.out.println(taskAssignment(k,tasks));

    }
}
