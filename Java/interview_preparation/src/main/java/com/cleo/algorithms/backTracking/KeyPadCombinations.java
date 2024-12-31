package com.cleo.algorithms.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyPadCombinations {
    private static final List<String> result=new ArrayList<>();
    private static String[] s1;
    public static String[] keypad(int n){
        // Write your code here
        if(n==0){
            String[] output = new String[1];
            output[0]="";
            return output;
        }
        String s = String.valueOf(n);
        int[] input = new int[s.length()];
        int t = n;
        for (int i = 0; i < input.length; i++) {
            input[i]=t%10;
            t/=10;
        }
        //Serious Doubt
       /* String[] current=keypad(n/10);
        String[] output = new String[current.length*2];
        System.arraycopy(current,0,output,0,current.length);
        String input = keyPadNumbers(n%10);
        for (int i = 0; i < current.length; i++) {
            assert input != null;
            output[current.length+i]=input.charAt(0)+current[i];
        }*/
     //   List<String> output = new ArrayList<>();

//23-> 2="abc",3="def" output=> ad,ae,af,bd,be,bf,cd,ce,cf

        //System.arraycopy(current,0,output,0,current.length);

        char[] output = new char[input.length];


         keyPadHelper(input,0,output);
          s1 = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            s1[i]=new StringBuilder(result.get(i)).reverse().toString();
        }
        return s1;

    }
    private static void keyPadHelper(int[] input, int pos, char[] output){
        if(pos==input.length){
            StringBuilder temp= new StringBuilder();
            for (int i = 0; i < input.length; i++) {
                if(output[i]=='\0')
                    temp.append("");
                else
                    temp.append(output[i]);
            }
                result.add(temp.toString());
            return;
        }
        String str=getKeyPadNumbers(input[pos]);


            if(str.isEmpty()){
                result.add("");
                keyPadHelper(input,pos+1,output);
            }else

                for (char c : str.toCharArray()) {
                    output[pos] = c;
                    keyPadHelper(input, pos + 1, output);
                }

    }
    private static String getKeyPadNumbers(int n){
        switch (n){
            case 2: return "abc";
            case 3: return "def";
            case 4: return "ghi";
            case 5: return "jkl";
            case 6: return "mno";
            case 7: return "pqrs";
            case 8: return "tuv";
            case 9: return "xwyz";
            default: return "";
        }
    }
    public static void printKeypad(int input){
        // Write your code here
        keypad(input);
        for(String s:s1)
            System.out.println(s);

    }

    public static void main(String[] args) {
        int n = 230;
        System.out.println(Arrays.toString(keypad(n)));
        printKeypad(23);
    }
}
class keypad {
    public static String getOptions(int digit) {
        if (digit == 2) {
            return "abc";
        }
        if (digit == 3) {
            return "def";
        }
        if (digit == 4) {
            return "ghi";
        }
        if (digit == 7) {
            return "pqrs";
        }
        return "";
    }

    public static String[] KeypadCombinations(int input) {
        if (input == 0) {
            String[] output = new String[1];
            output[0] = "";
            return output;
        }

        String[] smallOutput = KeypadCombinations(input / 10);
        int lastDigit = input % 10;
        String lastDigitOptions = getOptions(lastDigit);
        String[] output = new String[smallOutput.length * lastDigitOptions.length()];
        int K = 0;
        for (String string : smallOutput) {
            for (int j = 0; j < lastDigitOptions.length(); j++) {
                output[K] = string + lastDigitOptions.charAt(j);
                K++;
            }
        }
        return output;
    }
}
