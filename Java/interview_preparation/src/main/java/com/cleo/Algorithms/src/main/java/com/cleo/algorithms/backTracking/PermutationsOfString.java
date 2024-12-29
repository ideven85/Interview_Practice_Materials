package com.cleo.algorithms.backTracking;

import java.util.*;

public class PermutationsOfString {
    private static List<String> permutations;
    public static String[] permutationOfString(String input){
        // Write your code here
        if(input==null||input.isEmpty()){
            String[] output = new String[1];
            output[0]="";
            return output;
        }
        permutations=new ArrayList<>();
        permute(input,0,input.length()-1);
        String[] answer = new String[permutations.size()];
        for (int i = 0; i < permutations.size(); i++) {
            answer[i]=permutations.get(i);
        }
        return answer;

    }


    public static String[] permuteAndStore(String str){
       Set<String> permutations= permuteAndStore("",str);
       String[] output = new String[permutations.size()];
        int i=0;
        for(String s:permutations){
            output[i++]=s;
        }
        return output;

    }
    private static Set<String> permuteAndStore(String prefix,String input){
         Set<String> set = new LinkedHashSet<>();

        int n = input.length();
        if(n==0)
            set.add(prefix);
        else{
            for (int i = 0; i < n; i++) {
                set.addAll(permuteAndStore(prefix+input.charAt(i),input.substring(i+1,n)+input.substring(0,i)));
            }
        }
        return set;
    }
    private static void permute(String input, int low, int high){
        if(low==high){
            if(!permutations.contains(input))
                permutations.add(input);
        }else{
            for (int i = low; i <=high ; i++) {
                input=swap(input,i,low);
                permute(input,low+1,high);
                input=swap(input,i,low);
            }
        }
    }
    private static String swap(String input, int left, int right){
        StringBuilder sb = new StringBuilder(input);
        char temp=input.charAt(left);
        sb.setCharAt(left,input.charAt(right));
        sb.setCharAt(right,temp);
        input= sb.toString();
        return input;
    }


    public static void main(String[] args) {
        var first = System.nanoTime();
        System.out.println(Arrays.toString(permutationOfString("abcdefg")));
        var second = System.nanoTime();
        System.out.println(Arrays.toString(permuteAndStore("abcdefg")));
        var third = System.nanoTime();
        System.out.println("First took:" +(second-first));
        System.out.println("Second Using Hashset took:"+(third-second));
        System.out.println("Ratio:"+(third-second)*1.0/(second-first));
    }

}
