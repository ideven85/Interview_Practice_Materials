package com.cleo.algorithms.queuesAndStacks;


	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

	}



public class Queue<B> {

    //Define the data members

    private Node head,tail;
    private int front,rear,size;

    public Queue() {
        //Implement the Constructor
        head=tail=null;
        front=-1;
        rear=-1;
        size=0;
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() {
        //Implement the getSize() function
        return this.size;
    }


    public boolean isEmpty() {
        //Implement the isEmpty() function
        return this.size<=0;
    }


    public void enqueue(int data) {
        //Implement the enqueue(element) function
        if(isEmpty()){
            head= new Node(data);
            tail=head;
        }
        else{
            tail.next = new Node(data);
            tail=tail.next;
        }
        this.size+=1;
    }


    public int dequeue() {
        //Implement the dequeue() function
        if(isEmpty())
            return -1;
        int answer = head.data;
        head=head.next;
        this.size-=1;
        return answer;
    }


    public int front() {
        //Implement the front() function
        return tail.data;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(100);
        System.out.println(queue.front());

        System.out.println(queue.dequeue());
        System.out.println(queue.getSize());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println(queue.dequeue());

    }
}
