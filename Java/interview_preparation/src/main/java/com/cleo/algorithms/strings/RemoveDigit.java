package com.cleo.algorithms.strings;

public class RemoveDigit {
    // TODO: 15/01/23  
    public static String removeDigit(String number, char digit) {
        int n = number.length();
        int index = number.indexOf(digit);

        String answer = "";
        int indices = 0, i = 0, count = 0;
        for (i = 0; i < n - 1; i++) {
            if (number.charAt(i) == digit) {
                count += 1;
                if (number.charAt(i + 1) > digit) {
                    answer = number.substring(0, i) + number.substring(i + 1, n);
                    break;

                }
            }

        }
         if (count == 1&&i==n-1)
            answer = number.replace(String.valueOf(digit), "");
        if (i == n - 1) {
            if (number.charAt(i) == digit)
                answer = number.substring(0, n - 1);


        }
            int s = Integer.parseInt(answer);

            return String.valueOf(s);


    }

    public static void main(String[] args) {
        String number="1231";
        System.out.println(removeDigit(number,'1'));

    }
}
