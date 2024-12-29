package com.cleo.algorithms.strings;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GeneratePermutations {
    public static void allPermutations(String str){
        int n = str.length();

        generatePermutations("", str,3);
    }
    private static int count=0;
    private static String answer="";
    public static void generatePermutations(String prefix, String str, int k){
        int n = str.length();

        if(n==0){
            count+=1;
            if(count==k) {
                answer = prefix;
               // return prefix;
            }

           System.out.print(prefix + "\t"+count+"\t");

        }
        for (int i = 0; i < n; i++) {
            if(count==k)
                break;

            generatePermutations(prefix+str.charAt(i),str.substring(0,i)+str.substring(i+1,n),k);
        }

        //  return answer;

    }
    public static String getPermutation(int n, int k) {

        var x = IntStream.range(1,n+1).boxed();
        StringBuilder sb = new StringBuilder();
        for(var c:x.collect(Collectors.toList())){
            sb.append(c);
        }
        String s = "";
       generatePermutations("",sb.toString(),k);
        return answer;
    }

    public static void main(String[] args) {

        System.out.println( getPermutation(9,273815));
    }
}
