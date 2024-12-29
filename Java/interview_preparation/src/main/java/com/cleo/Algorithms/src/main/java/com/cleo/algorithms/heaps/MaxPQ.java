package com.cleo.algorithms.heaps;

import java.util.ArrayList;
import java.util.List;

public class MaxPQ {

        List<Integer> heap = new ArrayList<>();
        // Complete this class
        boolean isEmpty() {
            // Implement the isEmpty() function here
            return heap.isEmpty();
        }

        int getSize() {
            // Implement the getSize() function here
            return heap.size();
        }

        int getMax() {
            // Implement the getMax() function here
            if(isEmpty())
                return Integer.MIN_VALUE;
            return heap.get(0);
        }

        void insert(int element) {
            // Implement the insert() function here
            heap.add(element);
            int childIndex = heap.size() - 1;
            int parentIndex = (childIndex - 1) / 2;

            while (childIndex > 0) {
                if (heap.get(childIndex) > heap.get(parentIndex)) {
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

        int removeMax() {
            // Implement the removeMax() function here
            if (isEmpty()) return Integer.MIN_VALUE;
            int removedElement = heap.get(0);
            int element = heap.get(heap.size() - 1);
            heap.set(0, element);
            heap.remove(heap.size() - 1);
            int parentIndex = 0, childIndex1 = 1, childIndex2 = 2;
            while (childIndex2 < heap.size() && (heap.get(parentIndex) < heap.get(childIndex1) || heap.get(parentIndex) < heap.get(childIndex2))) {
                int minIndex;
                if (heap.get(childIndex1) > heap.get(childIndex2)) {
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

}
