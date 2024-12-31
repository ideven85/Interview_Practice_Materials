package com.cleo.algorithms.graphs;

import java.util.*;

import static java.util.Comparator.comparingInt;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

// TODO: 29/08/23 "Incorrect Algorithm" 
public class MinConnectionsToConnectAllAirPorts {

    private Map<String, List<String>> visitedMap = new LinkedHashMap<>();
    static Set<String> result = null;
    int count=0;
    public  int airportConnections(
            List<String> airports, List<List<String>> routes, String startingAirport) {
        // Write your code here.
        int V = airports.size();
        for(var route: routes){
            String origin = route.get(0);
            String destination = route.get(1);
            List<String> destinationList;
            if(visitedMap.containsKey(origin)){
                destinationList = visitedMap.get(origin);
                destinationList.add(destination);
            }else{
                destinationList = new LinkedList<>();
                destinationList.add(destination);
                visitedMap.put(origin,destinationList);
            }





        }
      //  List<String> sortedKeySet = new ArrayList<>(visitedMap.keySet());
        visitedMap= visitedMap.entrySet().stream()
                .sorted(comparingInt(e -> e.getValue().size()))
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));

        /*Map<String, List<String>> sorted = visitedMap.entrySet().stream()
                .sorted(comparingByValue(comparingInt(List::size)));
        *///visitedMap.forEach((key,value)->value.size());
        //visitedMap.forEach((key, value) -> value.stream().count());
        /*for(Map.Entry<String,List<String>> map:visitedMap.entrySet()){
            System.out.println(map.getKey()+":"+map.getValue());
        }*/
        result= new HashSet<>();
        //There are no outgoing flights from starting airport
        List<String> sortedAirPorts=new ArrayList<>(visitedMap.keySet());
        System.out.println(sortedAirPorts);
        System.out.println(sortedAirPorts.size());
        Set<String> seen = new HashSet<>();
        result.add(startingAirport);
        seen.add(startingAirport);
        count=airports.size();
        for (int i = sortedAirPorts.size()-1; i >=0 ; i--) {
            dfs(sortedAirPorts.get(i),startingAirport,airports.size(),seen);
        }
        int c=0;
        for(Map.Entry<String,List<String>> map:visitedMap.entrySet()){
            System.out.println(map.getKey()+":"+map.getValue());

            c+=map.getValue().size();
        }
        System.out.println(result);
        System.out.println(c);
        return count;
    }

    // TODO: 19/09/23
    /**
     * Correct this algorithm today 
     * @param origin
    */
    protected  void dfs(String origin,String startingAirPort,int V,Set<String> seen) {
        //Now I want only unreachable airports to count
        //
        if(seen.size()==V)
            return;
        if(seen.contains(origin))
            return;
        seen.add(origin);
        count--;
        // Visit all the outgoing edges first.
        if (visitedMap.containsKey(origin)) {
            List<String> destList = visitedMap.get(origin);
            for (int i = 0; i < destList.size(); i++) {
                String destination = destList.remove(0);//Point of DFS//uses Stack First in, first out
                if(destination.equals(startingAirPort)){
                    count++;
                    continue;
                }



                dfs(destination,startingAirPort,V,seen);
            }
        };
        // add the airport to the head of the itinerary
        result.add(origin);

    }
        public static void main(String[] args){
            List<String> airports = Arrays.asList("BGI", "CDG", "DEL", "DOH", "DSM", "EWR", "EYW", "HND", "ICN", "JFK", "LGA", "LHR", "ORD", "SAN", "SFO", "SIN", "TLV", "BUD");
            List<List<String>> routes = List.of(
                    List.of("DSM", "ORD"),
                    List.of("ORD", "BGI"),
                    List.of("SIN", "CDG"),
                    List.of("CDG", "SIN"),
                    List.of("CDG", "BUD"),
                    List.of("DEL", "DOH"),
                    List.of("DEL", "CDG"),
                    List.of("TLV", "DEL"),
                    List.of("EWR", "HND"),
                    List.of("HND", "ICN"),
                    List.of("HND", "JFK"),
                    List.of("ICN", "JFK"),
                    List.of("EYW", "LHR"),
                    List.of("LHR", "SFO"),
                    List.of("SFO", "SAN"),
                    List.of("SFO", "DSM"),
                    List.of("SAN", "EYW")
            );
            MinConnectionsToConnectAllAirPorts allAirPorts = new MinConnectionsToConnectAllAirPorts();
            System.out.println(allAirPorts.airportConnections(airports,routes,"LGA"));
            //Output=2
        }
    }


/*

public class MinConnectionsToConnectAllAirPorts {
    public  int airportConnections(
            List<String> airports,
            List<List<String>> routes, String startingAirport) {


    }

    public static void main(String[] args) {
        List<String> airports = Arrays.asList("BGI", "CDG", "DEL", "DOH", "DSM", "EWR", "EYW", "HND", "ICN", "JFK", "LGA", "LHR", "ORD", "SAN", "SFO", "SIN", "TLV", "BUD");
        List<List<String>> routes = List.of(
                List.of("DSM", "ORD"),
                List.of("ORD", "BGI"),
                List.of("BGI", "LGA"),
                List.of("SIN", "CDG"),
                List.of("CDG", "SIN"),
                List.of("CDG", "BUD"),
                List.of("DEL", "DOH"),
                List.of("DEL", "CDG"),
                List.of("TLV", "DEL"),
                List.of("EWR", "HND"),
                List.of("HND", "ICN"),
                List.of("HND", "JFK"),
                List.of("ICN", "JFK"),
                List.of("JFK", "LGA"),
                List.of("EYW", "LHR"),
                List.of("LHR", "SFO"),
                List.of("SFO", "SAN"),
                List.of("SFO", "DSM"),
                List.of("SAN", "EYW")
        );
    }
}
*
 */