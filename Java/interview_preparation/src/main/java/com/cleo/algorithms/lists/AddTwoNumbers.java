package com.cleo.algorithms.lists;

import static com.cleo.algorithms.lists.Main.printList;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=reverse(l1);
        l2=reverse(l2);


        ListNode result=addTwoNumbersHelper(l1,l2,0);
        result=reverse(result);
        return result;

    }
    public ListNode reverse(ListNode head){
        ListNode last = null,current=head,reverse=head,temp=head;
        while(current!=null){


            temp=current.next;
            current.next=last;
            last=current;
            current=temp;

        }

        return last;
    }

    public ListNode addTwoNumbersHelper(ListNode l1,ListNode l2, int carry){
        if(l1==null&&l2==null&&carry==0)
            return null;
        int value=carry;
        if(l1!=null)
            value+=l1.val;
        if(l2!=null)
            value+=l2.val;
       //System.out.print(value+ " ");
        int digit=value%10;
        carry=value/10;
        ListNode result = new ListNode();
        result.val=digit;
       // System.out.print(result.val+ " ");

        if(l1!=null||l2!=null){

            result.next=addTwoNumbersHelper(l1==null?null:l1.next,l2==null?null:l2.next,carry);


        }
        return result;
    }
}
