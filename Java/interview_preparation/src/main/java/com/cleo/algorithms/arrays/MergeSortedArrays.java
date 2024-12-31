package com.cleo.algorithms.arrays;

import java.util.Arrays;

public class MergeSortedArrays {

    public void merge(int[] a, int lastA, int[] b, int lastB) {

        int indexA = lastA-1;
        int indexB = lastB-1;
        int indexMerged = indexA+indexB+1;
        while(indexB>=0){
            if (indexA >= 0 && a[indexA] > b[indexB]) {
                a[indexMerged]=a[indexA];
                indexA--;
            }else{
                a[indexMerged]=b[indexB--];
            }
            indexMerged--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
        mergeSortedArrays.merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
}
