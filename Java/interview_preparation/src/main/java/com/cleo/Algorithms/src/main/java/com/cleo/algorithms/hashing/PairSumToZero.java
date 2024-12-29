package com.cleo.algorithms.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PairSumToZero {
    public static int PairSum(int[] arr, int size) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int count =0;
        int k=0;
        for(int i=0;i<arr.length;i++){
            if(hashMap.containsKey(arr[i])){
                hashMap.put(arr[i],hashMap.get(arr[i])+1);
            }
            else hashMap.put(arr[i],1);
            if(k==0) count+=hashMap.get(arr[i])-1;
        }
        if (k==0) return count;
        for(int i=0;i<arr.length;i++){
            if(k!=0 && hashMap.containsKey(arr[i]-k)){
                count+=hashMap.get(arr[i]-k);
                hashMap.remove(arr[i]);
            }
            else if(k!=0 && hashMap.containsKey(arr[i]+k)){
                count+=hashMap.get(arr[i]+k);
                hashMap.remove(arr[i]);
            }
        }
        return count;
    }
    public static int PairSum(int[] arr){
        if(arr.length==0)
            return 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int el:arr){
            map.compute(el,(k,v)->v==null?1:++v);
        }
       // System.out.println(map.get(0));
        int count=0;
        for(int el:arr){
            if(el==0) {
                if (map.get(el) != 0) {
                    int c1 = map.get(el);
                  //  System.out.println(c1);
                    int c2=(c1*(c1-1))/2;
                   // System.out.println(c2);
                    count += c2;
                    map.put(el, 0);
                }
            }
           else if(map.containsKey(-el)&&map.get(-el)!=0){
                int c1=map.get(el);
                int c2=map.get(-el);
                count+=c1*c2;
                map.put(el,0);
                map.put(-el,0);

            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,2,1,-2,2,3};
        System.out.println(PairSum(arr));
      //  System.out.println(subarraySum(arr,2));
    }
}