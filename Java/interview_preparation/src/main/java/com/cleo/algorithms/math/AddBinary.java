package com.cleo.algorithms.math;

public class AddBinary {
    public static String addStrings(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n>m){
            int diff = n -m;
            s2="0".repeat(diff)+s2;
        }else if(n<m){
            int diff = m-n;
            s1 = "0".repeat(diff)+s1;
        }
        int max = Math.max(n,m);
        int carry = 0,sum=0;
        StringBuilder sb = new StringBuilder();
        for (int i = max-1; i >=0 ; i--) {
            sum=Integer.parseInt(String.valueOf(s1.charAt(i)))+Integer.parseInt(String.valueOf(s2.charAt(i)))+carry;
            if(sum>1) {
                sum = 0;
                carry = 1;
            }else
                carry = 0;
            sb.append(sum);




        }
        if(carry==1)
            sb.append(1);
        sb.reverse();
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(addStrings("1","11"));
    }

}