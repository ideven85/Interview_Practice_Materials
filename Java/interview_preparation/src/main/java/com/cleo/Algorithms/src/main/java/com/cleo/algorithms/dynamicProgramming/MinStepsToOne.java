package com.cleo.algorithms.dynamicProgramming;

public class MinStepsToOne {
    public static int countMinStepsToOne(int n) {
        //Your code goes here
        int count=0;
        int first=minSteps(n-1)+1;
        int second=0;
        if(n%2==0)
            second=minSteps(n/2)+1;
        else
            second=minSteps((n-1)/2)+2;
        int third=0;
        if(n%3==0)
            third=minSteps(n/3)+1;
        else if((n-1)%3==0)
            third=minSteps((n-1)/3)+2;
        else
            third=minSteps((n-2)/3)+3;




        return Math.min(first,Math.min(second,third));
    }
    private static int minSteps(int n){
        int count=0;
        while(n!=1){
            if(n%3==0)
                n/=3;
            else if(n%2==0)
                n/=2;
            else
                n-=1;
            count++;
        }
        return count;

    }

    public static int minStepsToOne(int n) {

        if (n == 1) {
            return 0;
        }

        int[] minSteps = new int[n + 1];

        minSteps[1] = 0;

        for (int currStep = 2; currStep <= n; currStep++) {

            int subtractOne = Integer.MAX_VALUE;
            int divideByTwo = Integer.MAX_VALUE;
            int divideByThree = Integer.MAX_VALUE;

            subtractOne = minSteps[currStep - 1];

            if (currStep % 2 == 0) {
                divideByTwo = minSteps[currStep / 2];
            }

            if (currStep % 3 == 0) {
                divideByThree = minSteps[currStep / 3];
            }

            minSteps[currStep] = 1 + Math.min(subtractOne, Math.min(divideByTwo, divideByThree));
        }

        return minSteps[n];
    }

    public static void main(String[] args) {
        System.out.println(countMinStepsToOne(97));
        System.out.println(minStepsToOne(97));
    }
}
