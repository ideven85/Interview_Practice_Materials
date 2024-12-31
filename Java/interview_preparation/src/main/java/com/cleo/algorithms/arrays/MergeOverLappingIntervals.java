package com.cleo.algorithms.arrays;

import java.util.*;
import java.util.stream.Collectors;

class Interval {
    int start,  finish;

    Interval(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}
public class MergeOverLappingIntervals {


    static class Activity{
        int startTime,finishTime;

        public Activity(int startTime, int finishTime) {
            this.startTime = startTime;
            this.finishTime = finishTime;
        }

        public Activity() {
        }
    }
    static class ActivityComparator implements Comparator<Activity>{
        @Override
        public int compare(Activity o1, Activity o2) {
            return o1.startTime -o2.startTime;
        }
    }
    static class IntervalComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start- o2.finish;
        }
    }
    public static List<Interval> mergeIntervals(Interval[] intervals) {
        // write your code here.
        List<Interval> list = Arrays.stream(intervals).sorted(new IntervalComparator()).collect(Collectors.toList());
        List<Interval> output = new ArrayList<>();
        Interval interval = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if(interval.finish<list.get(i).start){
                interval = new Interval(interval.start,list.get(i).finish);
            }else if(interval.finish<list.get(i).finish)
                interval = new Interval(list.get(i).start,list.get(i).finish);
            if(!output.contains(interval))
                output.add(interval);
        }
        return output;


    }
    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        // Write your code here.
        int n = intervals.length;
        List<Activity> activities = new ArrayList<>();
        for(int[] interval: intervals){
            activities.add(new Activity(interval[0],interval[1]));
        }
        activities.sort(new ActivityComparator());
        List<Activity> mergedActivities = new ArrayList<>();
        int[][] mergedIntervals;
        Activity activity = new Activity(activities.get(0).startTime,activities.get(0).finishTime);
        mergedActivities.add(activity);
        for (int i = 1; i < activities.size(); i++) {

            if(activity.finishTime<activities.get(i).startTime){

                activity = new Activity(activity.startTime, activities.get(i).finishTime);

            }else if(activity.finishTime>activities.get(i).finishTime){
                activity = new Activity(activities.get(i).startTime,activities.get(i).finishTime);

            }
            if(!mergedActivities.contains(activity))
                mergedActivities.add(activity);


        }
        for(var c:mergedActivities){
            System.out.println(c.startTime+","+c.finishTime);
        }

        mergedIntervals = new int[mergedActivities.size()][2];
        int i=0;
        for (int j = 0; j < mergedActivities.size(); j++) {
            mergedIntervals[j][0]=mergedActivities.get(j).startTime;
            mergedIntervals[j][1]=mergedActivities.get(j).finishTime;
        }


        return mergedIntervals;
    }


    public int[][] mergingIntervals(int[][] intervals){
        if(intervals.length<2)
            return intervals;
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        List<int[]> result = new ArrayList<>();
        int index = 0;
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if(result.get(index)[1]>=intervals[i][0])
                result.set(index,new int[]{result.get(index)[0],Math.max(result.get(index)[1],intervals[i][1])});
            else {
                index++;
                result.add(new int[]{intervals[i][0],intervals[i][1]});
            }

        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2},{3,5},{4,7},{6,8},{9,10}};
        MergeOverLappingIntervals overLappingIntervals = new MergeOverLappingIntervals();
      //  overLappingIntervals.mergeOverlappingIntervals(intervals);
        intervals=overLappingIntervals.mergingIntervals(intervals);
        for(var row: intervals){
            System.out.print(Arrays.toString(row) +'\t' );

        }

    }
}
