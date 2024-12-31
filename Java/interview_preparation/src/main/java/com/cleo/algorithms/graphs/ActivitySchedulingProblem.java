package com.cleo.algorithms.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ActivitySchedulingProblem {

    static class Activity{
        int job_id;
        int start;
        int end;

        public Activity(int job_id, int start, int end) {
            this.job_id = job_id;
            this.start = start;
            this.end = end;

        }

        public Activity() {


        }
    }
    static class ActivityComparator implements Comparator<Activity>{
        @Override
        public int compare(Activity o1, Activity o2) {
            return o2.end-o1.start;
        }
    }

    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        // Write your code here.
        return new ArrayList<Integer>();
    }
}
