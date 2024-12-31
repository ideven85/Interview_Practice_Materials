package com.cleo.algorithms.graphs;

import java.util.*;

public class ReconstructItinerary{
    Map<String,List<String>> graph = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for(var ticket:tickets){
            String source = ticket.get(0);
            String destination = ticket.get(1);
            graph.putIfAbsent(source,new ArrayList<>());
            graph.get(source).add(destination);
        }
        graph.forEach((key,value)->Collections.sort(value));
        List<String> output = new ArrayList<>();
        String origin = "JFK";
        int V =  graph.size();
        System.out.println(V);
        Set<String> seen = new HashSet<>();
        seen.add(origin);
        dfsUtil(V,origin,seen,output);
        Collections.reverse(output);//Need to reverse cause the person starts from origin
        //System.out.println(output);

        return output;




    }
    private void dfsUtil(int V,String origin, Set<String> seen,List<String> output){


        if(graph.containsKey(origin)){
            List<String> destinations = graph.get(origin);
            while(!destinations.isEmpty()){
                /**
                 * Basic Fundamental of dfs=> Stack-> First in first out
                 */
                String dest=destinations.remove(0);
                dfsUtil(V,dest,seen,output);
            }
        }
        output.add(origin);




    }

    public static void main(String[] args) {
        List<List<String>> destinations =  new ArrayList<>();
        destinations.add(Arrays.asList("JFK","SFO"));
        destinations.add(Arrays.asList("JFK","ATL"));
        destinations.add(Arrays.asList("SFO","ATL"));
        destinations.add(Arrays.asList("ATL","JFK"));
        destinations.add(Arrays.asList("ATL","SFO"));
        ReconstructItinerary itinerary = new ReconstructItinerary();
        System.out.println(itinerary.findItinerary(destinations));

    }

}
