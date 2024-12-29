package com.cleo.algorithms.lists;

public class DetectLoop {
    public static ListNode findLoop(ListNode head) {
        // Write your code here.
        ListNode slow = head,fast=head;
        while(fast.next!=null){
            if(fast.next.next!=null){
                fast=fast.next.next;
                slow = slow.next;
                if(slow==fast)
                    break;
            }

        }
        if(fast==null||fast.next==null)
            return null;
        slow = head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;

    }

}
