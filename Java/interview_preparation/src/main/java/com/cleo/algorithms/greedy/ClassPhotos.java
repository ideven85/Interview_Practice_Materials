package com.cleo.algorithms.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ClassPhotos {
    public boolean classPhotosHelper(List<Integer> backRow,List<Integer> frontRow){
        for (int i = 0; i < backRow.size(); i++) {
            if(backRow.get(i)<frontRow.get(i))
                return false;
        }
        return true;
    }
    public static int factorial(int n){
        return n<2?1:n*factorial(n-1);
    }
    public boolean classPhotos(
            List<Integer> redShirtHeights, List<Integer> blueShirtHeights) {
        // Write your code here.
        redShirtHeights.sort(Comparator.naturalOrder());
        blueShirtHeights.sort(Comparator.naturalOrder());
        if(redShirtHeights.get(0)==blueShirtHeights.get(0))
            return false;
        if(redShirtHeights.get(0)>blueShirtHeights.get(0))
            return classPhotosHelper(redShirtHeights,blueShirtHeights);
        else
            return classPhotosHelper(blueShirtHeights,redShirtHeights);
    }

    public static void main(String[] args) {
        List<Integer> red = Arrays.asList(5,1,8,3,4);
        List<Integer> blue = Arrays.asList(5, 9, 2, 4, 5);
        ClassPhotos photos = new ClassPhotos();
        System.out.println(photos.classPhotos(red,blue));
        System.out.println(factorial(10));
    }
}
