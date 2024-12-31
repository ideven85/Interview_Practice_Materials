package com.cleo.algorithms.lists;

public class ShiftLinkedList {
    public static int length(LinkedList head){
        int count=0;
        while(head!=null){
            head=head.next;
            count++;
        }
        return count;
    }
    public static LinkedList kReverse(LinkedList head, int k) {
        //Your code goes here
        if(k==0)
            return head;
        int size=length(head);
        if(k<0)
            k=size+k;
        System.out.println(k);
        LinkedList current = head;
//last node after reverse
        LinkedList prevTail = null; //first node before reverse
        LinkedList prevCurrent = head;
        while (current != null) {
//loop for reversing K nodes
            int count = k;
            LinkedList tail = null;
            while (current != null && count > 0) {
                LinkedList next = current.next;
                current.next = tail;
                tail = current;
                current = next;
                count--;
            }
            //reversed K Nodes
            if (prevTail != null) {
//Link this set and previous set
                prevTail.next = tail;
            } else {
//We just reversed first set of K nodes, update head point to the Kth Node
                head = tail;
            }
//save the last node after reverse since we need to connect to the next set.
            prevTail = prevCurrent;
//Save the current node, which will become the last node after reverse
            prevCurrent = current;
        }
        return head;
    }

}
