package com.cleo.algorithms.dynamicProgramming;

import java.util.*;

// TODO: 26/08/23 "Deadline September 13th"
public class LongestIncreasingSubString {
    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        int result = 1;
        int left=-1,right=-1;
        for (int i : arr) {
            if (map.containsKey(i)) {
                continue;
            }
            left = map.getOrDefault(i - 1, 0);
            right = map.getOrDefault(i + 1, 0);

            int sum = left + right + 1;
            map.put(i, sum);
            result = Math.max(sum, result);
            map.put(i - left, sum);
            map.put(i + right, sum);
        }
        int first=-1,last=-1;
        for(var m:map.entrySet()){
            if(m.getValue()==result){
                System.out.println(m.getKey());
                if(last==-1)
                    last=m.getKey();
               else if(first==-1)
                    first=m.getKey();
            }
        }

        ArrayList<Integer> output = new ArrayList<>();
        output.add(first);
        output.add(last);
        return output;
        /*int n = arr.length;
        int[] dp = new int[n+1];
        int[] arr2 = new int[n];
        int index=0;
        for(int num:arr){
            arr2[index++]=num;
        }
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));
        dp[0]=1;
        int count=0,max_count=0;
        int first=-1,last=-1;
        for (int i = 1; i < n; i++) {
            if(arr2[i]-arr2[i-1]==1) {
                dp[i] = 1 + dp[i - 1];
                count++;
                if(max_count<count){
                    max_count=count;

                }



            }
            else {
                dp[i] = 1;
                count=1;



            }
        }
        ArrayList<Integer> output = new ArrayList<>();

        int max = 0;
        index=0;

        for (int i = 0; i < dp.length; i++) {
            if(max<dp[i]) {
                max=dp[i];
                index=i;
            }
        }
       // System.out.println(max);
        if(max==1){
            output.add(arr[0]);
            return output;

        }


       // System.out.println(index);

        //System.out.println(arr2[index-1]);
        output.add(arr2[index-max+1]);

        output.add(arr2[index]);

       // System.out.println(Arrays.toString(dp));



         */


    }
    public static ArrayList<Integer> longestConsecutiveIncreasingSequenceV1(int[] arr) {
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr,0,arr2,0,arr.length);
        Arrays.sort(arr);
        Map<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;
        int first = arr[0];
        hashMap.put(first, 1);
        for (int i = 1; i < arr.length; i++) {
            if (hashMap.containsKey(first) && arr[i] == hashMap.get(first) + first) {
                hashMap.put(first, hashMap.get(first) + 1);
                continue;
            }
            first = arr[i];
            hashMap.put(first, 1);
        }
        int seqStart=0;
        for (int i:arr2){
            if (hashMap.containsKey(i)){
                if (max<hashMap.get(i)) {
                    seqStart = i;
                    max = hashMap.get(i);
                }
            }
        }
        list.add(seqStart);
        list.add(seqStart+max-1);
        return list;
    }
    public static String uniqueChar(String str){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        String s = "";
        StringBuilder sb = new StringBuilder();
        for(char c:str.toCharArray()){
            if(sb.indexOf(String.valueOf(c))==-1)
                sb.append(c);
        }
        s=sb.toString();
        return s;

    }

    public static void main(String[] args) {
        String s="abcdabcd";
        int[] nums = {2,12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
        int[] nums2 = {1,4,6};
        System.out.println(longestConsecutiveIncreasingSequenceV1(nums));
        System.out.println(longestConsecutiveIncreasingSequenceV1(nums2));

        System.out.println();
        System.out.println(uniqueChar(s));
    }
}