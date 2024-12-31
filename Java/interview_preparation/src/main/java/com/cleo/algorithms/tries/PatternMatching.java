package com.cleo.algorithms.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PatternMatching {

    private final TrieNode root;
    public int count;

    public PatternMatching() {
        root = new TrieNode('\0');
    }

    public boolean search(String word){
        return search(root, word);
    }

    private boolean search(TrieNode root, String word) {
        if(word.isEmpty()){
            return true;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null){
            return false;
        }
        return search(child, word.substring(1));
    }

    //4
    //abc def ghi cba
    //de
    //true

    // TODO: 04/09/23 "Correct me"
    public boolean patternMatching(ArrayList<String> vect, String pattern) {
        // Write your code here
        //dictionary=["habcd","dehf","ghi","hello"]
        // [pattern="hi"]
        // answer=true

        //Brute Force Approach
       for(String word: vect){
           if(word.length()<pattern.length())
               continue;
           int n = word.length();
           if(word.contains(pattern))
               return true;
       }
        return false;

    }

    public static void main(String[] args) {
        //abc def ghi cba

        ArrayList<String> dictionary = new ArrayList<>();
        dictionary.add("abc");
        dictionary.add("def");
        dictionary.add("ghi");
        dictionary.add("cba");
        String pattern = "de";
        PatternMatching patternMatching = new PatternMatching();
        var start = System.nanoTime();
        System.out.println(patternMatching.patternMatching(dictionary,pattern));
        var end = System.nanoTime();
        System.out.println(1.0*(end-start)/60.0);
    }
}
