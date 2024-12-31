package com.cleo.algorithms.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsequences {

    private static final List<String> sequences = new ArrayList<>();

    public static List<String> subsequences(String input){
        if(input==null||input.isEmpty())
            return null;
        int n = input.length();
        char[] output = new char[n];
        sequences.add("");
        for (int i = 0; i < n; i++) {
            output[0]=input.charAt(i);
            subsequencesHelper(input,output,1,i+1,true);
        }
        return sequences;
    }
    private static void subsequencesHelper(String input,char[] output, int length, int current,boolean flag){
        if(flag){
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < length; i++) {
                temp.append(output[i]);
            }
            sequences.add(temp.toString());

        }
        if(current==input.length())
            return;
        output[length]=input.charAt(current);
        subsequencesHelper(input,output,length+1,current+1,true);
        subsequencesHelper(input,output,length,current+1,false);
    }
    public static void print(int[] input) {
        int[] output = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            output[0] = input[i];
            print(input, output, 1, i + 1, true);
        }
    }
    private static void print(int[] input, int[] output, int len, int current, boolean print) {

        if (print) {
            for (int i = 0; i < len; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.print("\t");
        }
        if (current == input.length) {

            return;
        }


        output[len] = input[current];
        print(input, output, len + 1, current + 1, true);
        print(input, output, len, current + 1, false);
    }

    public static void main(String[] args) {
        System.out.println(subsequences("1234"));
        System.out.println(Arrays.toString(Recursion.subsequences("abcd")));
        print(new int[]{1,2,3,4});

    }

}
class Recursion {
    public static String[] subsequences(String input) {
        if (input.isEmpty()) {
//base case
            String[] output = new String[1];
            output[0] = "";
            return output;
        }
        String[] smallOutput = subsequences(input.substring(1));
        String[] output = new String[smallOutput.length * 2];
        System.arraycopy(smallOutput, 0, output, 0, smallOutput.length);
        for (int i = 0; i < smallOutput.length; i++) {
            output[smallOutput.length+i] = input.charAt(0) + smallOutput[i];
        }
        return output;
    }
}