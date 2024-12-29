package com.cleo.algorithms.math;

        import java.util.*;
class CandidateCode {
    public static void main(String args[] ) throws Exception {

        //Write code here
        Scanner in = new Scanner(System.in);
        int month = in .nextInt();
        int day = in.nextInt();
        if(month==2&&day>1)
            System.out.println(5);
        else if(month==2)
            System.out.println(4);
        else {
            boolean b1 = (month <= 7 && month % 2 != 0) || (month > 7 && month % 2 == 0);
            if(b1 &&day<=4)
                System.out.println(5);
            else if(b1)
                System.out.println(6);
            else {
                boolean b = month > 7 || month % 2 == 0;
                if(b &&day<=6)
                    System.out.println(5);
                else {
                    System.out.println(6);
                }
            }
        }






    }
}

public class Columns {

    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        String s = in.next();
        Map<Character,Integer> map = new LinkedHashMap<>();

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(i!=0&&i%4==0){

            }
            if(map.get(s.charAt(i))!=null)
                map.put(s.charAt(i),map.get(s.charAt(i+1)));
            else
                map.put(s.charAt(i),1);

        }

    }
}