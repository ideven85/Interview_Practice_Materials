package com.cleo.algorithms.lists;

public class PalindromeLinkedList {

    public  void printList(ListNode head){
        System.out.print("List:");
        while(head!=null){
            System.out.print(head.val+ " ");
            head=head.next;
        }
        System.out.println();
    }

    public boolean isPalindrome(ListNode head) {

        int size=0;
        ListNode current = head,pointer=head,reverse=new ListNode(),temp=reverse;

        while(pointer!=null){



            temp.next= new ListNode(pointer.val);
            pointer=pointer.next;
            temp=temp.next;

            size+=1;
        }
        reverse.val=reverse.next.val;
        reverse.next=reverse.next.next;



        reverse = reversed(reverse);
        printList(reverse);
        printList(head);
        temp=reverse;
        boolean flag = true;
       while(current!=null){
            //System.out.println(current.val+ ": " + reverse.val);
                if (current.val != reverse.val){
                   flag=false;
                   break;

                }

                current = current.next;
                reverse = reverse.next;

        }
        return flag;


    }

    public ListNode reversed(ListNode head){
        ListNode last = null,current=head,reverse=head,temp=head;
        while(current!=null){


            temp=current.next;
            current.next=last;
            last=current;
            current=temp;

        }

        return last;
    }
}
