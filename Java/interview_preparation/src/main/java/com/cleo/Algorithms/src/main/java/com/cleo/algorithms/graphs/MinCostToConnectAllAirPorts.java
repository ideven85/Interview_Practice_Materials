package com.cleo.algorithms.graphs;

import java.util.*;
/*
airports=["BGI", "CDG", "DEL", "DOH", "DSM", "EWR", "EYW", "HND", "ICN", "JFK", "LGA", "LHR", "ORD", "SAN", "SFO", "SIN", "TLV", "BUD"]
    routes = [
        ["DSM", "ORD"],
        ["ORD", "BGI"],
        ["BGI", "LGA"],
        ["SIN", "CDG"],
        ["CDG", "SIN"],
        ["CDG", "BUD"],
        ["DEL", "DOH"],
        ["DEL", "CDG"],
        ["TLV", "DEL"],
        ["EWR", "HND"],
        ["HND", "ICN"],
        ["HND", "JFK"],
        ["ICN", "JFK"],
        ["JFK", "LGA"],
        ["EYW", "LHR"],
        ["LHR", "SFO"],
        ["SFO", "SAN"],
        ["SFO", "DSM"],
        ["SAN", "EYW"]
    ]
 */
//Please do this again
/**
Minimum Connections Needed To Connect All AirPorts
 AlgoExpert Hard
 */
public class MinCostToConnectAllAirPorts {

    static class AirPortNode{
        String airPortName;
        boolean isReachable;

        List<String> connectedAirPorts;

        List<String> unReachableNodes;

        public AirPortNode(String airPortName) {
            this.airPortName = airPortName;
            this.connectedAirPorts = new ArrayList<>();
            this.isReachable = true;
            this.unReachableNodes = new ArrayList<>();
        }

        @Override
        public String toString() {
            return airPortName;
        }
    }
   static Map<String,AirPortNode> airPortNodeGraph = new HashMap<>();

    public  static int airportConnections(
            List<String> airports, List<List<String>> routes, String startingAirport) {
        // Write your code here.
        for(String airPort:airports){
          airPortNodeGraph.put(airPort,new AirPortNode(airPort));
        }
        /*for(var route:routes){
            airPortNodeGraph.get(route.get(0)).connectedAirPorts.add(route.get(1));

        }*/

        List<AirPortNode> unReachableNodes = getUnReachableNodes(airports,startingAirport);

        markUnReachableNodes(unReachableNodes);

        return getMinimumConnections(unReachableNodes);
    }


    public static List<AirPortNode> getUnReachableNodes(List<String> airPorts, String startingAirPort){
        Set<String> reachableAirPorts=new HashSet<>();
        depthFirstSearchForUnReachableAirPorts(startingAirPort,reachableAirPorts);
        List<AirPortNode> unReachableNodes = new ArrayList<>();
        for(String airPort:airPorts){
            if(reachableAirPorts.contains(airPort))
                continue;
            AirPortNode airPortNode = airPortNodeGraph.get(airPort);
            airPortNode.isReachable=false;
            unReachableNodes.add(airPortNode);

        }
        return unReachableNodes;
    }
    public static void depthFirstSearchForUnReachableAirPorts(String startingAirPort,Set<String> reachableAirPorts){
        if(reachableAirPorts.contains(startingAirPort))
            return;
        reachableAirPorts.add(startingAirPort);
        List<String> connectedAirPorts = airPortNodeGraph.get(startingAirPort).connectedAirPorts;
        if(connectedAirPorts!=null)
            for(String connections:connectedAirPorts){
                depthFirstSearchForUnReachableAirPorts(connections,reachableAirPorts);
            }


    }

    public static void markUnReachableNodes(List<AirPortNode> unReachableNodes){
       // List<AirPortNode> unReachable;
        for(AirPortNode node:unReachableNodes){
            String airPort = node.airPortName;
            List<String> unReachableAirPorts = new ArrayList<>();

            dfsForUnReachableNodes(airPort,unReachableAirPorts,new HashSet<>());
            node.unReachableNodes = unReachableAirPorts;
          
        }
    }
    public static void dfsForUnReachableNodes(String airPort, List<String> unReachableAirPorts,Set<String> seen){
        if(airPortNodeGraph.get(airPort).isReachable)
            return;
        if(seen.contains(airPort))
            return;
        seen.add(airPort);
        unReachableAirPorts.add(airPort);
        for(String connected:airPortNodeGraph.get(airPort).connectedAirPorts){
            dfsForUnReachableNodes(connected,unReachableAirPorts,seen);
        }
    }

    public static int getMinimumConnections(List<AirPortNode> airPortNodes){
        airPortNodes.sort((a,b)->b.unReachableNodes.size()-a.unReachableNodes.size());
        System.out.println(airPortNodes+" "+airPortNodes.size());
        int count = 0;
        for(var node:airPortNodes){
            if(node.isReachable)
                continue;//Visited Set
            count++;
            for(String connections: node.unReachableNodes)
                airPortNodeGraph.get(connections).isReachable=true;
        }
        return count;
    }

    public static void main(String[] args) {
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
        System.out.println(airportConnections(airports,routes,"LGA"));
        //Phew
        //Output=3
    }
}
