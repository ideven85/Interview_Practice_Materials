package com.cleo.algorithms.lists;

public class PartitionList {

    public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
        // Write your code here.
        LinkedList beforeStart=null,beforeEnd=null,afterStart=null,afterEnd=null;
        while(head!=null){
            LinkedList next= head.next;
            head.next = null;
            if(head.value<=k){
                if(beforeStart == null){
                    beforeStart = head;
                    beforeEnd = beforeStart;
                }else{
                    beforeEnd.next = head;
                    beforeEnd = head;
                }
            }


            else {
                    if(afterStart == null){
                        afterStart = head;
                        afterEnd = afterStart;

                    }else{
                        afterEnd.next = head;
                        afterEnd = head;
                    }
                }

            head = next;
        }
        if(beforeStart==null)
            return afterStart;
        beforeEnd.next = afterStart;
        return beforeStart;

    }

    private static void printList(LinkedList head){
        while(head!=null){
            System.out.print(head.value + " ");
            head=head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList(3);
        LinkedList head = list;
        list.next = new LinkedList(0);
        list=list.next;
        list.next = new LinkedList(5);
        list=list.next;
        list.next = new LinkedList(2);
        list=list.next;list.next = new LinkedList(1);
        list=list.next;list.next = new LinkedList(4);
       // list=list.next;list.next = new LinkedList(-4);
        // head = rearrangeLinkedList(head,-4);
        LinkedList list1 = ShiftLinkedList.kReverse(head,3);
        printList(list);
        printList(list1);



    }

}
