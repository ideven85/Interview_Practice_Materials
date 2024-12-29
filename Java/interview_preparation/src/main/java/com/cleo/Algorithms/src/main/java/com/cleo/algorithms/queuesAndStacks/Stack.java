package com.cleo.algorithms.queuesAndStacks;


class StackEmptyException extends Exception{
    public StackEmptyException() {
        super();
        System.out.println("Stack is empty");
    }
}
class StackFullException extends Exception{
    public StackFullException(){
        super();
        System.out.println("Stack is full");
    }
}

public class Stack {
  private static   class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }



    }


    //Define the data members
    private Node root;
    private int size;

    public Stack() {
        //Implement the Constructor
        root=null;
        size=0;
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() {
        //Implement the getSize() function
       return size;
    }

    public boolean isEmpty() {
        //Implement the isEmpty() function
        return size<=0;
    }

    public void push(int element) {
        //Implement the push(element) function
        if(isEmpty()){
            root = new Node(element);

        }else{
            Node newHead = new Node(element);
            newHead.next=root;
            root=newHead;
        }
        size++;

    }

    public int pop() {
        //Implement the pop() function
        if(isEmpty())
           return -1;
        Node current=root;
        int answer=root.data;
        if(root.next!=null) {
            root.data = root.next.data;
            root.next = root.next.next;
           // root.next = root;
        }else if(root.next==null){

            root=null;

            //root.next.next=null;
        }
        size--;
        return answer;

    }


    public int top(){
        //Implement the top() function
        if(isEmpty())
            return -1;
        return root.data;

    }

    public static void main(String[] args) throws Exception {
        Stack stack = new Stack();
        stack.push(10);
        System.out.println(stack.getSize());
        System.out.println(stack.pop());
        System.out.println(stack.getSize());
        stack.push(10);
        stack.push(20);
        stack.push(100);
        stack.push(30);

        System.out.println(stack.top());
        System.out.println(stack.pop());

    }
}


/*
class StackUsingLL<T> {

    private Node<T> head;
    private int size;
    private Node<T> tail;

    public StackUsingLL(){
        head= null;
        size=0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    //Pushing happening at he begining of the LL
    public void push(T elem){
        Node<T> newNode = new Node<T>(elem);
        newNode.next = head;
        head= newNode;
        size++;
    }

    //Since pushing is happening at first node
    public T top() throws StackEmptyException{
        if(head==null){
            throw new StackEmptyException();
        }
        return head.data;

    }

    public T pop() throws StackEmptyException{
        if(head==null){
            throw new StackEmptyException();
        }
        //since we are pushing data in the front so the so we must remove the data from the front itself
        T temp =head.data;
        head = head.next;
        size--;
        return temp;
    }

}

class StackUse{

    public static void main(String[] args) throws StackFullException, StackEmptyException {


        StackUsingLL<Integer> stack = new StackUsingLL<>();
        int arr[]={5,6,7,1,9};
        for(int i=0;i<arr.length; i++){
        stack.push(arr[i]);
        }
        while(!stack.isEmpty()){
        System.out.println(stack.pop());
        }

        stack.push(10);
        System.out.println(stack.top());
        stack.pop();
        stack.size();
        System.out.println(stack.isEmpty());
        stack.isEmpty();

}


   }

*/
