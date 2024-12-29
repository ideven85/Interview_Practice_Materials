package com.cleo.algorithms.math;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappyV2(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public static boolean isHappy(int n) {

        int total=0;
       // String s = String.valueOf(n);
        while(true) {


            while (n != 0) {
                int last = n % 10;
                total += last * last;

                n /= 10;



            }
          //  System.out.print(total + " ");
            if (total == 1)
                return true;
            if (total==2||total==4||total==16||total==37||total==58)
                return false;


            n = total;
            total=0;



          //  s = String.valueOf(total);





        }





    }

    public static void main(String[] args) {
        System.out.println(isHappy(5));
    }
}
