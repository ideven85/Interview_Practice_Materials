package com.cleo.algorithms.arrays;

import java.util.Arrays;

public class ArrayOfProducts {

    public static int[] arrayOfProducts(int[] array) {
        // Write your code here.
        System.out.println(Arrays.toString(array));

        int[] answer=  new int[array.length];
       answer[0]=1;
        for (int i = 1; i < array.length; i++) {
            answer[i]=array[i-1]*answer[i-1];
        }
        System.out.println(Arrays.toString(answer));
        int R=1;
        for (int i = array.length-1; i >=0 ; i--) {

            int temp =R*answer[i];


            R*=array[i];
            System.out.print(temp+ " " + R+ " ");
            array[i]=temp;


            System.out.println(array[i]+ " " + temp);

        }
        return array;
    }
    public static int minimumWaitingTime(int[] queries) {
        // Write your code here.
        Arrays.sort(queries);
        int total=0,temp=0;
        for (int i = 1; i <queries.length; i++) {

            total+=temp;
            temp+=queries[i-1];

        }
        total+=temp;
        return total;


    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 2, 6};
       System.out.println(Arrays.toString(arrayOfProducts(nums)));
      //  System.out.println(minimumWaitingTime(nums));
    }
}
