package com.cleo.algorithms.lists;

public class Main {

    public static ListNode reverse(ListNode root){
        if(root==null)
            return null;
       root=reverse(root.next);
       return root;

    }
    public static void printList(ListNode head){
        while(head!=null){
            System.out.print(head.val+ " ");
            head=head.next;
        }
        System.out.println();
    }
    private static int length(ListNode head){
        if(head==null)
            return 0;

        return 1+length(head.next);
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode current=head;

        current.next=new ListNode(2);
        current=current.next;
        current.next = new ListNode(3);
        current=current.next;

        current.next = new ListNode(9);
        current=current.next;
        current.next= new ListNode(4);

        current=current.next;
        printList(head);
       /* System.out.println();
        head=reverse(head);
        printList(head);
        System.out.println();
       PalindromeLinkedList p = new PalindromeLinkedList();
        printList(head);
        System.out.println("Is palindrome?");
       /* DeleteValue deleteValue = new DeleteValue();
       // head=deleteValue.removeElements(head,1);
       // printList(head);
        System.out.println();
       // head = deleteValue.removeElements(head,2);
        //printList(head);
        SortList sortedList = new SortList();
        printList(head);
        System.out.println();
        ListNode lst = sortedList.sortList(head);
        printList(lst);
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode added = addTwoNumbers.addTwoNumbers(head,head);
        System.out.println(added.val);
        printList(added);

        printList(head);

        */
          DeleteValue deleteValue = new DeleteValue();
        head=deleteValue.removeElements(head,1);
        printList(head);
        SortList sortedList = new SortList();
        printList(head);
        System.out.println("Pinkie Boy");
        ListNode lst = sortedList.sortList(head);
        printList(lst);
        RotateList rotateList = new RotateList();
        head=rotateList.rotateRight(head,6);
        System.out.print("Printing List rotated right by 6:");
        printList(head);
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode added = addTwoNumbers.addTwoNumbers(head,lst);
        System.out.println("Length of list after adding the two lists:"+length(added));
        printList(added);

      //  System.out.println(p.isPalindrome(head));
    }
}
