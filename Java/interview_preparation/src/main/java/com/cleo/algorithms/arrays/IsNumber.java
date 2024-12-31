package com.cleo.algorithms.arrays;

public class IsNumber {
    public boolean isNumber(String s) {
        int i = 0, n = s.length();
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        while (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;


        boolean isNumeric = false;
        System.out.println(i);

        while (i < n && (Character.isDigit(s.charAt(i)))) {




                i++;
                isNumeric = true;

        }


        if (i < n && (s.charAt(i) == '.'||(s.charAt(i)=='e'||s.charAt(i)=='E'))) {
            i++;
            while (i < n && (Character.isDigit(s.charAt(i)))) {
                i++;
                isNumeric = true;
            }
        }

        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        return isNumeric && i == n;
    }

    public static void main(String[] args) {
        IsNumber isNumber = new IsNumber();
        System.out.println(isNumber.isNumber("+6e-1"));
    }
}
