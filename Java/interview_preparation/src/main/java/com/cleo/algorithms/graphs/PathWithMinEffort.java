package com.cleo.algorithms.graphs;

import java.util.Arrays;


// TODO: 19/09/23 "Implement me" 
public class PathWithMinEffort {
    /**
     *
     *Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
     * Output: 2
     * Explanation: The route of [1,3,5,3,5]
     * has a maximum absolute difference of 2 in consecutive cells.
     * This is better than the route of [1,2,2,2,5],
     * where the maximum absolute difference is 3.
     */
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;
        int[][] current=new int[n][m];
        int[][] prev=new int[n][m];
        for(var row:current)
            Arrays.fill(row,Integer.MAX_VALUE);
        for(var row:prev)
            Arrays.fill(row,Integer.MAX_VALUE);
        prev[0][0]=0;
        
        return -1;





    }
}
