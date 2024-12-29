package com.cleo.algorithms.lists;


import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
    private static final Comparator<ListNode> listComparator =
            new Comparator<ListNode>() {
                @Override
                public int compare(ListNode x, ListNode y) {
                    return x.val - y.val;
                }
            };
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        Queue<ListNode> queues = new PriorityQueue<>((x,y)->x.val-y.val);
        for(ListNode q: lists){
            if(q!=null)
                queues.add(q);
        }
        ListNode answer = new ListNode(0),p=answer;
        while(!queues.isEmpty()){
            ListNode current = queues.poll();
            p.next=current;
            p = p.next;
            if(current.next!=null)
                queues.add(current.next);

        }
        return answer.next;

    }


}
