package com.cleo.algorithms.lists;
class Node {
    public int data;
    public Node next;

    Node() {
        this.data = 0;
        this.next = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    public static void printList(Node  head){
        while(head!=null){
            System.out.print(head.data+ " ");
            head=head.next;
        }
        System.out.println();
    }
}
public class MiddleNode {

    public Node middleNode(Node linkedList) {
        if(linkedList==null)
            return null;
        // Write your code here.
        int length=length(linkedList);
        int mid=length/2;

        for (int i = 0; i < mid; i++) {
            linkedList=linkedList.next;

        }
        return linkedList;
    }

    public static int length(Node  head){
        int count=0;
        while(head!=null){
            count+=1;
            head=head.next;
        }
        return count;
    }

    public static Node deleteMiddle(Node head) {
        // Write your code here.
        if(head==null)
            return null;
        int length=length(head);
        if(length==1)
            return  new Node(-1);
        int mid=length/2;
        Node current=head,temp=head;
        for (int i = 0; i < mid; i++) {
            temp=current;
            current=current.next;
        }
        temp.next=current.next;
        current=temp;
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node current = head;
        current.next = new Node(2);
        current=current.next;
        current.next=new Node(3);
        current=current.next;
        current.next=new Node(4);
        current=current.next;
        head=deleteMiddle(head);
        Node.printList(head);
    }

}
