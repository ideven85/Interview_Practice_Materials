package com.cleo.algorithms.lists;

public class SwapPairs {
    public Node swapPairs(Node head) {
        Node swapped;
        if (head != null && head.next != null) {
            swapped = head.next;
            head.next = swapped.next;
            swapped.next = head;
            head = swapped;
            head.next.next = swapPairs(head.next.next);
        }
        return head;
    }
}
