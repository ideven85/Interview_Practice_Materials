package com.cleo.algorithms.dynamicProgramming;

import java.util.Arrays;

public class TrappedWater {
    //  private static int[] heights,leftMax=new int[2],rightMax=new int[2];
    public static int waterArea(int[] height) {
        // Write your code here.
        if(height.length==0)
            return 0;
        int[] leftMaxHeight = new int[height.length];
        int[] rightMaxHeight = new int[height.length];

        int totalWaterSaved = 0;
        //1. fill up the left and right max height of the index
        computeIndexLeftAndMaxHeight(leftMaxHeight, rightMaxHeight, height);
        System.out.println(Arrays.toString(leftMaxHeight));
        System.out.println(Arrays.toString(rightMaxHeight));
        System.out.println(Arrays.toString(height));
        for (int i = 0; i < height.length; i++) {

            int leftMax = leftMaxHeight[i];
            int rightMax = rightMaxHeight[i];
            int minHeight = Math.min(leftMax, rightMax);
            totalWaterSaved = totalWaterSaved + (Math.max(minHeight - height[i], 0));
            System.out.print(totalWaterSaved+ " ");
        }

        return totalWaterSaved;

    }


    private static void computeIndexLeftAndMaxHeight(int[] leftMaxHeight, int[] rightMaxHeight, int[] height) {

        leftMaxHeight[0] = 0;
        int leftMax = height[0];

        //filling left heights
        for (int i = 1; i < height.length; i++) {

            leftMaxHeight[i] = leftMax;
            if (leftMax < height[i])
                leftMax = height[i];
        }
        //  System.out.println(Arrays.toString(leftMaxHeight));

        //filling right heights
        rightMaxHeight[height.length - 1] = 0;
        int rightMax = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {

            rightMaxHeight[i] = rightMax;
            if (rightMax < height[i])
                rightMax = height[i];
        }

    }


  /*  private static int calculateTrappedWater(int left, int right,int max, int[] heights){
        int area=0;
        for (int i = left+1; i <right ; i++) {
            area+=max-heights[i];
        }
        return area;
    }

    private static void getLeftAndRightMax(int leftMax, int rightMax,int[] heights){
        int left=0,left_index=0,right=0,right_index=0,max=0,max_index=0;
        for (int i = 0; i < heights.length; i++) {
            if(max<=heights[i]){
                max=heights[i];
                max_index=i;
            }
        }
        for (int i = leftMax; i >=0 ; i--) {
            if(left>=heights[i])
                left=heights[i];
        }
        for (int i = max_index+1; i < heights.length; i++) {
            if(right<=heights[i]){
                right=heights[i];
                right_index=i;
            }
        }
        leftMax=left;
        rightMax=right;


    }


   */
    public static void main(String[] args) {
        int[] arr= new int[]{0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
        System.out.println(waterArea(arr));
    }
}
