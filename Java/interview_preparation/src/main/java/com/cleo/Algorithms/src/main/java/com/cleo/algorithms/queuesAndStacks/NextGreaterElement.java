package com.cleo.algorithms.queuesAndStacks;

import java.util.*;
import java.util.Stack;

public class NextGreaterElement {

    @SuppressWarnings("unused")

    public static int[] nextGreaterElement(int[] array) {
        // Write your code here.
       // Queue<Integer> queue = new PriorityQueue<>();
        int n = array.length;
        if(n==0)
            return array;
       int[] output = new int[array.length];
       /*
        //Brut Force
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i]==max)
                    output[i]=-1;
                else{
                    if(array[j]>array[i]) {
                       output[i] = array[j];
                       break;
                    }

                }
            }
        }

        */
        int max = Arrays.stream(array).max().getAsInt();
        int next_greater=0,j=0;
        for (int i = 0; i <n; i++) {



                if(array[i]==max) {
                    output[i] = -1;
                    continue;
                }

                   for (j = i + 1; j < n; j++) {
                       if (array[j] > array[i]) {
                           output[i] = array[j];
                           next_greater=array[j];

                           break;
                       }


                   }
                   if(j==n){
                      // System.out.println(Arrays.toString(array));
                       for (int k = 0; k < i; k++) {
                           if(array[k]>array[i]) {
                               output[i] = array[k];
                               break;
                           }

                       }



                   }




        }






       return output;
    }

    public static int[] nextGreaterElementOptimised(int[] array){
      Stack<Integer> stack = new Stack<>();
        int n = array.length;
        int[] output = new int[n];
        int next_greater=0;
        int max = Arrays.stream(array).max().orElse(-1);
       // stack.push(max);
        for (int i = n-1; i >=0 ; i--) {
            if(!stack.isEmpty()&&array[i]>array[stack.peek()]) {
                System.out.println(stack.peek());
                stack.pop();


            }else
                stack.push(i);


        }
        System.out.println(stack);
        //stack.push(0);
        for (int i = 0; i < n-1; i++) {
            if(!stack.isEmpty()&&array[stack.peek()]!=max) {

                output[i] = array[stack.pop()];

            }else if(!stack.isEmpty()&&array[stack.peek()]==max)
                output[i]=-1;
        }
        for (int j : array) {
            if (j > array[n - 1]) {
                output[n - 1] = j;
                break;
            }
        }

        return output;
    }



    public static void main(String[] args) {
        int[] nums = {6, 4, 5, 7, 2, 1, 3};
        System.out.println(Arrays.toString(nextGreaterElementOptimised(nums)));
        System.out.println(Arrays.toString(nextGreaterElement(nums)));
    }
}
