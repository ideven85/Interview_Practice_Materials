package com.cleo.algorithms.queuesAndStacks;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueRandom {
   static void f (Queue<Integer> Q) {
        int i ;
        if (!Q.isEmpty()) {
            i = (int) Q.poll();
            f(Q);
            Q.add(i);
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        f(q);
        System.out.println(q);
    }
}
