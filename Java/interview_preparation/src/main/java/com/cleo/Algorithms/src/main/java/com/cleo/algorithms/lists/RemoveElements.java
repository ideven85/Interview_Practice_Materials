package com.cleo.algorithms.lists;

public class RemoveElements {
    public ListNode removeElementsV1(ListNode head, int val) {
        if(head==null)
            return null;
        ListNode current=head,prev=null;
        while(current!=null){
            if(current.val==val){
                if(current.next!=null) {
                    prev = current.next;
                    current.next=current.next.next;

                }else{
                    current=null;
                }

            }else{
                prev=current;
                current=current.next;
            }
        }
        return head;

    }
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return null;
        head.next=removeElements(head.next,val);
        return head.val==val?head.next:head;
    }
}

