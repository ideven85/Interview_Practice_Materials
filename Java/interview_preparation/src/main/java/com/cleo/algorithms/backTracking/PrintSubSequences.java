package com.cleo.algorithms.backTracking;

import java.util.Arrays;

public class PrintSubSequences {

    /**
     *
     * @param input Given a string print all possible
     *              permutations of the string
     */
    public static void printSubsequences(String input){
        printSubsequencesHelper(input,"");

    }
    public static void printSubsequencesHelper(String input, String prefix){
        if(input.isEmpty()){
            System.out.print(prefix+ " ");
            return;
        }
        String smallInput=input.substring(1);
        printSubsequencesHelper(smallInput,prefix);
        printSubsequencesHelper(smallInput,prefix+input.charAt(0));
    }

    /**
     * For Storing the subsequences
     * @param input Given a string
     * @return Store and return all possible
     * distinct subsequences of the string
     */
    public static String[] subsequences(String input) {
        if (input.isEmpty()) {
// base case
            String[] output = new String[1];
            output[0] = "";
            return output;
        }

        String[] smallOutput = subsequences(input.substring(1));
        String[] output = new String[smallOutput.length * 2];

        System.arraycopy(smallOutput, 0, output, 0, smallOutput.length);

        for (int i = 0; i < smallOutput.length; i++) {
            output[smallOutput.length + i] = input.charAt(0)+smallOutput[i];
        }

        return output;
    }

    public static void main(String[] args) {
        printSubsequences("abc");
        System.out.println();
        System.out.println(Arrays.toString(subsequences("abc")));
    }
}
