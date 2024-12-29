package com.cleo.algorithms.graphs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class REVERSE {



    public static int minEdgesToReverse(Map<Integer,List<Integer>> map,int source, int destination,Set<Integer> seen,Set<Integer> stack,int count,List<Integer> paths){


        if(source==destination) {
          //  System.out.println(source+ " " + destination);
            paths.add(destination);
            System.out.println(paths);
            count = paths.size();
            System.out.println(count);
            paths = new ArrayList<>();
            return count;
        }


        List<Integer> connections = map.get(source);
        stack.add(source);
        // System.out.println(connections);
        if(connections!=null) {
            for (int connection : connections) {
              //  System.out.print("C "+ connection);

                if(connection==destination) {
                    paths.add(destination);
                    System.out.println(paths);
                    count = paths.size();
                    System.out.println(count);
                    paths = new ArrayList<>();
                    return count;
                }
                if(seen.contains(connection))
                    continue;

                stack.add(connection);
                paths.add(connection);


              return   minEdgesToReverse(map,connection,destination,seen,stack,count,paths);

            }
        }
        return count+1;

    }
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        InputReader in = new InputReader(inputStream);
        int N = in.nextInt();
        int V=N;
        int edges = in.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <=N ; i++) {
            map.put(i,new ArrayList<>());
        }
        int count=0;


        while (N-- > 0) {

            int first=in.nextInt();
            int second=in.nextInt();
            if(first==V) {
                count += 1;
               // map.get(second).add(V);
            }


            map.get(first).add(second);


        }

        List<Integer> paths = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        Set<Integer> stack = new HashSet<>();
        for (int i = 1; i <=V ; i++) {

            paths.add(i);
            count = Math.min(minEdgesToReverse(map, i, V, seen, stack,count,paths),count);

           // System.out.println(count);
        }
     //   System.out.println(stack);
      //  System.out.println(stack.size());
        System.out.println(count);
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
