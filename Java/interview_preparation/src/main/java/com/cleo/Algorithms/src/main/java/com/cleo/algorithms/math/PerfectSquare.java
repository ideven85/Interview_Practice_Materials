package com.cleo.algorithms.math;

public class PerfectSquare {
    public boolean isPerfectSquare(int num) {
        int i = 1;

        int Sn=0;
        //Nth Term is: [first+(n-1)*2]
        for (int j = 0; j <= num; j++) {
            i = 1+(j)*2;
            Sn+=i;

            if(Sn==num)
                return true;
            if(Sn>num||Sn<0)
                return false;
        }
      //  System.out.println(i+1);
        return false;


    }

        public int mySqrt(int num) {
        int i = 1;
        if(num==0)
            return 0;
        int Sn=0;
        //Nth Term is: [first+(n-1)*2]
        for (int j = 1; j <=num; j++) {
            i = 1+(j-1)*2;
            Sn+=i;
            if(Sn>num||Sn==Integer.MAX_VALUE||Sn<0)
                return j-1;
            else if(Sn==num)
                return j;
        }
        System.out.println(i+1);
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(new PerfectSquare().isPerfectSquare(1024));
        System.out.println(System.currentTimeMillis());
        System.out.println(new PerfectSquare().mySqrt((int) Math.pow(2,31)-1));
        System.out.println(new PerfectSquare().mySqrt(10));
    }
}
