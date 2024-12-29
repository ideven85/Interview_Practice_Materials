package com.cleo.algorithms.arrays;

public class IsBadVersion {

    public boolean isBadVersion(int n){
        return true;
    }

    public int firstBadVersion(int n) {
        int low=0,high=n;
        int mid=(low+high)/2;
        while(low<high){
            mid=(low+high)/2;
            if(!isBadVersion(mid))
                low=mid;
            else
                high=mid-1;


        }
        return low;

    }
}
