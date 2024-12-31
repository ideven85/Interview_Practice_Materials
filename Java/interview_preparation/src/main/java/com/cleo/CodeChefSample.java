package com.cleo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CodeChefSample {
    public static boolean isLapindrome(String s){
        int n = s.length();
        int mid = n/2;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < mid; i++) {
            char c = s.charAt(i);
            map.compute(c,(k,v)->v==null?1:++v);
        }
        //   for(var m:map.entrySet()){
        //     System.out.println(m.getKey()+" " +m.getValue());
        // }
        int i=n%2==0?mid:mid+1;
        for ( ; i < s.length(); i++) {
            char c= s.charAt(i);
            if(map.get(c)==null||map.get(c)==0)
                return false;
            else
                map.put(c,map.get(c)-1);
        }
        return true;
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        InputReader in = new InputReader(inputStream);
        int N = in.nextInt();
        while(N-->0){
            String s = in.next();
            if(isLapindrome(s))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
