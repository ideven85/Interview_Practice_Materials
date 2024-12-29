package com.cleo.algorithms.dynamicProgramming;

import java.util.*;

public class LongestIncreasingSequence {

    private int[] root;
    private int[] rank;
    public int find(int u){
        if(root[u]==u)
            return u;
        return root[u]=find(root[u]);
    }

    public void unionByRank(int u, int v){
        int root_u = find(u);
        int root_v = find(v);
        if(rank[root_u]<rank[root_v])
            root[root_v]=root[root_u];
        else if(rank[root_u]>rank[root_v])
            root[root_u]=root[root_v];
        else{
            root[root_v]=root[root_u];
            rank[root_v]+=1;
        }


    }
    public boolean connected(int u, int v){
        return find(u)==find(v);
    }

    public int longestConsecutive(int[] nums) {
        root = new int[nums.length];
        rank = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            root[i]=i;
            rank[i]=1;
        }
        int count = 0;

        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]<nums[i+1])
                unionByRank(i,i+1);

        }



        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < nums.length-1; i++) {
            if(connected(i,i+1)){
                output.add(nums[i]);
                count+=1;

            }
        }
        System.out.println(output);
       // System.out.println(Arrays.toString(rank));
        return count;

    }
    public int lcs(int[] num){
        int res = 0;
        Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = map.getOrDefault(n - 1, 0);//1,3,2
                int right = map.getOrDefault(n + 1, 0);
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                if(res<=sum)
                    res = sum;

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
            else {
                // duplicates
                continue;
            }
        }

        return res;
    }

    public int lcsV2(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        dp[0]=1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(nums[j]<nums[i]&&dp[j]>dp[i])
                    dp[i]=dp[j];
            }
            dp[i]++;
        }

        System.out.println(Arrays.toString(dp));
        return Arrays.stream(dp).max().getAsInt();
    }
    public  ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
       // Map<Integer,Integer> map = new LinkedHashMap<>();
        if(arr.length==0)
            return null;
        if(arr.length==1)
            return new ArrayList<>(arr[0]);
        ArrayList<Integer> output = new ArrayList<>();
        int count=0,max_count=0;
        int first=0,last=0;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]<arr[i+1]) {
                count++;
                first=i;
                if(max_count<count) {
                    max_count = count;
                    last=i;
                }

            }else{
                count=1;
                first=i;
                last=i;

            }
        }
        if(first!=last) {
            output.add(first+1);
            output.add(last+1);

        }else
            output.add(0);
        return output;
    }

    public static void main(String[] args) {
        LongestIncreasingSequence lcs = new LongestIncreasingSequence();
        int[] nums = {2,12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
        System.out.println(lcs.longestConsecutive(nums));
     //  System.out.println(lcs.longestConsecutive(nums));
        //System.out.println(lcs.lcsV2(nums));
       // System.out.println(lcs.lcs(nums));
       // System.out.println(nums[7]+ " " + nums[11]);
        System.out.println(lcs.longestConsecutiveIncreasingSequence(nums));
    }
}
