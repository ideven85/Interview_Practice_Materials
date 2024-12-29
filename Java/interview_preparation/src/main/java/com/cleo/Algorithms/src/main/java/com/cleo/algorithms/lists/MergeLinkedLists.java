package com.cleo.algorithms.lists;

public class MergeLinkedLists {
    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        // Write your code here.
        if(headOne==null&&headTwo==null)
            return null;
        if(headOne==null)
            return headTwo;
        if(headTwo==null)
            return headOne;

        if(headOne.value< headTwo.value) {
            headOne.next = mergeLinkedLists(headOne.next, headTwo);
            return headOne;
        }

        headTwo.next=mergeLinkedLists(headOne,headTwo.next);
        return headTwo;

    }
    public LinkedList mergingLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        return null;
    }

}
