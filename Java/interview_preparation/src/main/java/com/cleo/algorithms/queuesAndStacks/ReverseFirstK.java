package com.cleo.algorithms.queuesAndStacks;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstK {
    public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
       Stack<Integer> queue = new Stack<>();
       Queue<Integer> answer = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            queue.add(input.poll());
        }

      //  System.out.println(queue);
        while(!queue.isEmpty()){
            answer.add(queue.pop());
        }
        while(!input.isEmpty())
            answer.add(input.poll());
        return answer;


    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 5, 6));
        System.out.println(reverseKElements(q,2));

    }
}
