package com.cleo.algorithms.lists;


import static com.cleo.algorithms.lists.Main.reverse;
//Doubt 
// TODO: 14/09/23 "Do again, this solution is correct but implement again" 
public class RotateList {


    public ListNode reverse(ListNode head,int start,int end){
        ListNode last = null,current=head,reverse=head,temp=head;

        while(current!=null&&start!=end){


            temp=current.next;
            current.next=last;
            last=current;
            current=temp;
            start++;

        }

        return last;
    }
    private int length(ListNode root){
        int size=0;
        while(root!=null){
            size++;
            root=root.next;
        }
        return size;
    }
    public  void printList(ListNode head){
        while(head!=null){
            System.out.print(head.val+ " ");
            head=head.next;
        }
        System.out.println();
    }
    public ListNode rotateRight(ListNode head, int k) {
      /*  if(head==null)
            return null;
        int length=length(head);
        k=k%length;
        if(k==0)
            return head;

        head=reverse(head,0,length);
        printList(head);

        ListNode current=head,temp=head;

        current=reverse(head,0,k+1);;
        System.out.print("List: ");
        printList(head);
        //System.out.println(current.val);
        for (int i = 0; i < k; i++) {
            temp=current;
            current=current.next;
        }
        printList(head);
        current=reverse(current,k,length-1);
        temp.next=current;

        *//*System.out.println(current.val);


        current=reverse(head,k,length-1);
        temp.next=current;
*//*



    return head;*/
      /**  if (head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy,slow=dummy;

        int i;
        for (i=0;fast.next!=null;i++)//Get the total length
            fast=fast.next;

        for (int j=i-n;j>0;j--) //Get the i-n%i th node
            slow=slow.next;
        System.out.println(slow.val);
        printList(slow);
        fast.next=dummy.next; //Do the rotation
        dummy.next=slow.next;

        slow.next=null;

        return dummy.next;


       */
        if(head == null || k == 0) {
            return head;
        }

        ListNode p = head;
        int len = 1;
        while(p.next != null) {
            p = p.next;
            len++;
        }
        p.next = head;
        k %= len;
        for(int i = 0; i < len - k; i++) {
            p = p.next;
        }
        head = p.next;
        System.out.println(head.val);
        System.out.println(p.val);
        p.next = null;
        return head;


    }
}
