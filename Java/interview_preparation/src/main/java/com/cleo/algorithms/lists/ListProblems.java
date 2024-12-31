package com.cleo.algorithms.lists;

public class ListProblems {



    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        // Write your code here.
        int length=0;
        LinkedList current=head,temp=head;
        while(current!=null){
            current=current.next;
            length+=1;
        }
        current=head;
        if(length==(k)){
            head.value=head.next.value;
            head.next=head.next.next;
            return;
        }




        for (int i = 0; i <length-k ; i++) {
            temp=current;
            current=current.next;
        }


        temp.next=current.next;


    }
    public LinkedList mergingLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        return null;
    }
    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        // Write your code here.


        return null;
    }

    public static void main(String[] args) {

    }
}
