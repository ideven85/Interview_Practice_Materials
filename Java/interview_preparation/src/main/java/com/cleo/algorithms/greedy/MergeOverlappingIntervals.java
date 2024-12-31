package com.cleo.algorithms.greedy;

import java.util.*;

public class MergeOverlappingIntervals {
    static class Activity{
        int start_time;
        int finish_time;

        public Activity(int start_time, int finish_time) {
            this.start_time = start_time;
            this.finish_time = finish_time;
        }

        @Override
        public String toString() {
            return this.start_time+" "+this.finish_time;
        }
    }
    static class ActivityComparator implements Comparator<Activity>{
        @Override
        public int compare(Activity o1, Activity o2) {
            return o1.start_time-o2.start_time;
        }
    }
    public static int[][] merge(int[][] intervals) {
        List<Activity> activities = new ArrayList<>();
        for(int[] interval:intervals){
            int startTime=interval[0];
            int finishTime=interval[1];
            activities.add(new Activity(startTime,finishTime));
        }
        activities.sort(new ActivityComparator());
        System.out.println(activities);
        Activity previous = activities.get(0);

        //int current=0;
        int prev=0;




       List<Activity> sortedActivities= mergeActivities(activities);
        int[][] answer = new int[sortedActivities.size()][];
        for(Activity activity:sortedActivities){
            answer[prev]=new int[]{activity.start_time, activity.finish_time};
            prev++;
        }
        return answer;




    }
    public static List<Activity> mergeActivities(List<Activity> activities){
        if(activities.size()<=1)
            return activities;
        List<Activity> result = new LinkedList<>();
        int start=activities.get(0).start_time;
        int finish=activities.get(0).finish_time;
        for(Activity activity:activities){
            if(activity.start_time<=finish)
                finish=Math.max(finish, activity.finish_time);
            else{
                result.add(new Activity(start,finish));
                start=activity.start_time;
                finish=activity.finish_time;
            }
        }
        result.add(new Activity(start,finish));
        return result;
    }
/*
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        // Sort by ascending starting point using an anonymous Comparator

        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }
*/

    public static void main(String[] args) {
        int[][] intervals = {{1,4},{0,4}};
        intervals=merge(intervals);
        for(var interval:intervals)
            System.out.println(Arrays.toString(interval));
    }
}
