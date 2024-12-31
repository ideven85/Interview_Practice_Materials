package com.cleo.algorithms.lists;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head;
        ListNode current;
        if (list1 != null && list2 != null)
            if (list1.val < list2.val) {
                head = new ListNode(list1.val);
                current = head;
                current=current.next;
                list1=list1.next;
            } else if (list1.val == list2.val) {
                head = new ListNode(list1.val);
                current = head;
                current=current.next;
                list1=list1.next;
                current= new ListNode(list2.val);
                current = current.next;
                list2=list2.next;
            } else {
                head = new ListNode(list2.val);
                current = head;
                list2=list2.next;
                current=current.next;

            }
        else if(list1==null)
            return list2;
        else
            return list1;
        while(list1!=null&&list2!=null){
            if (list1.val < list2.val) {
                current.next = new ListNode(list1.val);
                current = current.next;
                list1=list1.next;
            } else if (list1.val == list2.val) {
                head = new ListNode(list1.val);
                current = current.next;
                list1=list1.next;
                current.next = new ListNode(list2.val);
                current = current.next;
                list2=list2.next;
            } else {
                current.next = new ListNode(list2.val);
                current = current.next;
                list2=list2.next;

            }
        }
        if(list1!=null)
            current.next=list1;
        else if(list2!=null)
            current.next=list2;
        return head;
    }
    public ListNode mergeLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeLists(l1, l2.next);
            return l2;
        }
    }
}
