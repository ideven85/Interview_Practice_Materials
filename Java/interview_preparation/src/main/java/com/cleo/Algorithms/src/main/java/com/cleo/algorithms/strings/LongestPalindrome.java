package com.cleo.algorithms.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static String longestPalindromicSubstring(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        String max_str = "", curr_str;
        int max_length = 0, curr_length;

        for (int i = 0; i < str.length(); i++) {
            curr_str = expand(str, i, i);
            curr_length = curr_str.length();
            if (curr_length > max_length)
            {
                max_length = curr_length;
                max_str = curr_str;
            }
            curr_str = expand(str, i, i + 1);
            curr_length = curr_str.length();
            if (curr_length > max_length)
            {
                max_length = curr_length;
                max_str = curr_str;
            }

        }
        return max_str;
    }

    public static String expand(String str, int low, int high){

        while(low>=0 && high<str.length() && str.charAt(low)==str.charAt(high)) {
            low--;high++;
        }
        return str.substring(low+1,high);

    }

    public int longestPalindrome(String s) {
        if(s.length()==0)
            return 0;
        if(s.length()==1)
            return 1;
        Map<Character,Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.compute(c,(k,v)->v==null?1:++v);
        }
        int count = 0;

        for(var m:map.entrySet()){
        //    System.out.print(m.getKey()+":"+m.getValue()+"\t");
            if(m.getValue()>=2){
                if(m.getValue()%2==0)
                    count+=m.getValue();
                else {
                    count += ( m.getValue() - 1 );
                    map.put(m.getKey(),1);
                }


            }

        }

      if(map.containsValue(1))
          count+=1;

        return count;


    }

    public static void main(String[] args) {

        String s =  "ccc";

        LongestPalindrome palindrome = new LongestPalindrome();
        System.out.println(longestPalindromicSubstring("abazxyzzyxf"));
        System.out.println(palindrome.longestPalindrome(s));
    }
}
