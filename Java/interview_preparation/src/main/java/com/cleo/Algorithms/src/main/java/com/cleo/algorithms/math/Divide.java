package com.cleo.algorithms.math;

public class Divide {
    public static int divide(int dividend, int divisor) {
        if(dividend==0)
            return 0;

        if(dividend>Integer.MAX_VALUE-1)
            dividend =Integer.MAX_VALUE-1;
        else if(dividend<Integer.MIN_VALUE+1)
            dividend=Integer.MIN_VALUE+1;

        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int answer=0;

        if(b==1)
            answer=a;
        else{
            for (int i = b; i <=a ; i+=b) {
                answer+=1;
                // System.out.print(answer+ " " );
            }
        }
        if((dividend<0&&divisor>0)||(dividend>0&&divisor<0))
            return -answer;
        return answer;

    }

    public static void main(String[] args) {
        System.out.println(divide(-48,-7));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Math.pow(-2,31));
    }
}
