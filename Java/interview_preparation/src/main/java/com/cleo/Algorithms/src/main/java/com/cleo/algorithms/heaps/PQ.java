package com.cleo.algorithms.heaps;
import java.util.ArrayList;

public class PQ {

    private ArrayList<Integer> heap;

    public PQ() {
        heap = new ArrayList<Integer>();
    }

    boolean isEmpty() {
        return heap.size() == 0;
    }

    int size() {
        return heap.size();
    }

    int getMin() throws PriorityQueueException {
        if (isEmpty()) {
            // Throw an exception
            throw new PriorityQueueException();
        }
        return heap.get(0);
    }

    void insert(int element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if (heap.get(childIndex) < heap.get(parentIndex)) {
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    int removeMin() throws PriorityQueueException {
        // Complete this function
        // Throw the exception PriorityQueueException if queue is empty
        if (isEmpty()) throw new PriorityQueueException();
        int removedElement = heap.get(0);
        int element = heap.get(heap.size() - 1);
        heap.set(0, element);
        heap.remove(heap.size() - 1);
        int parentIndex = 0, childIndex1 = 1, childIndex2 = 2;
        while (childIndex2 < heap.size() && (heap.get(parentIndex) > heap.get(childIndex1) || heap.get(parentIndex) > heap.get(childIndex2))) {
            int minIndex;
            if (heap.get(childIndex1) < heap.get(childIndex2)) {
                minIndex = childIndex1;
            } else minIndex = childIndex2;
            int temp = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(minIndex));
            heap.set(minIndex, temp);
            parentIndex = minIndex;
            childIndex1 = parentIndex * 2 + 1;
            childIndex2 = childIndex1 + 1;
        }
        return removedElement;
    }

    public static void main(String[] args) throws PriorityQueueException{
        PQ pq = new PQ();
        pq.insert(1);
        pq.insert(2);
        System.out.println(pq.getMin());
        System.out.println(pq.removeMin());
        System.out.println(pq.size());
    }
}

