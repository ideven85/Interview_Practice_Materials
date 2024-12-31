package com.cleo.algorithms.arrays;

import java.util.*;

public class TournamentWinner {

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        if(results.size()==1){
            if(results.get(0)==0)
                return competitions.get(0).get(1);
            else
                return competitions.get(0).get(0);
        }

        Map<String,Integer> winners = new HashMap<>();
        int i=0;
        String max="";int total=0;
        for(var c: competitions){
            String winner="";
            if(results.get(i++)==0)
                winner=c.get(1);
            else
                winner=c.get(0);
            if(winners.get(winner)==null)
                winners.put(winner,1);
            else{
                int temp = winners.get(winner);

                temp++;
                if(total<temp) {
                    total = temp;
                    max=winner;
                }
                winners.put(winner,temp);

            }
        }

        return max;

    }

}
