package com.cleo.algorithms.heaps;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BuyTicket {
    public static int buyTicket(int[] input, int k) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        Queue<Integer> queue = new PriorityQueue<>((a,b)->(b-a));
        Queue<Integer> list = new LinkedList<>();
        int i=0;
        for(int el:input) {
            queue.add(el);
            list.add(i++);
        }
        int total=1;
        for (i = 0; i < input.length; i++) {
            while(input[list.peek()]!=queue.peek())
                list.add(list.poll());
            if(list.peek()==k)
                return total;
            list.poll();
            queue.poll();
            total++;
        }
        return total;
    }
    public static int ChotaBhim(int cups[], int size) {
        int time = 2; Arrays.sort(cups); int total = 0;
        int index, temp; while (time >= 0) {
            total += 1;
            cups[0] = (int) Math.ceil(cups[0] / 2.0);
            index = 0;
            temp = cups[0];
            while (index < size - 1 && temp < cups[index + 1]) {
                cups[index] = cups[index + 1]; index += 1;
            }
            cups[index] = temp;
            time -= 1; }
        System.out.println("Total %d " + total); return total;
    }
    public static int ChotaBhim3(int cups[], int size) {
        int time = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int i = 0;
        for (i = 0; i < size; i++) {
            pq.add(cups[i]);
        }
        int total = 0;
        int value;
        while (time > 0) {
            value = pq.remove();
            total += 1;
            value = (int) Math.ceil(value / 2.0);
            pq.add(value);
            time -= 1;
        }
        System.out.println("Total : " + total);
        return total;
    }
    public static void main(String[] args) {
        int cups[] = { 2, 1, 7, 4, 2 };// ChotaBhim(new int[]{3,9,4},3);
        int[] tickets = {2, 3, 2, 2, 4};
        //System.out.println(ChotaBhim(tickets,tickets.length));
        System.out.println(buyTicket(tickets,3));
        //System.out.println(ChotaBhim3(tickets,tickets.length));

    }
}
