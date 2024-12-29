package com.cleo.algorithms.lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head==null)
            return null;
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while(current!=null){
            list.add(current.val);
            current=current.next;
        }
        list.sort(Comparator.naturalOrder());
        ListNode output=new ListNode(list.get(0));
        current=output;
        int n = list.size();
        int i=0;
        for (int j = 1; j < n; j++) {
            current.next = new ListNode(list.get(j));
            current=current.next;
        }
        return output;

    }
}
