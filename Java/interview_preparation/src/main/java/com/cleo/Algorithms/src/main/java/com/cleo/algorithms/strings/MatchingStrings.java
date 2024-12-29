package com.cleo.algorithms.strings;

import java.util.*;


public class MatchingStrings {

    static class TrieNode{
        Map<Character,TrieNode> children = new HashMap<>();
        String word;

    }
    static class Trie{
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public void insert(String str){
            TrieNode current = root;
            for(char c:str.toCharArray()){
                if(!current.children.containsKey(c)){

                    current.children.put(c,new TrieNode());
                }
                current=current.children.get(c);
            }
            current.children.put(endSymbol,null);
            current.word=str;
        }

    }

    public void containsHelper(Trie trie,int index,String bigString, Set<String > contains){
        TrieNode currentNode = trie.root;
        if(currentNode==null)
            return;
        for (int i = index; i < bigString.length(); i++) {
            if(!currentNode.children.containsKey(bigString.charAt(i)))
                continue;
            currentNode=currentNode.children.get(bigString.charAt(i));
            if(currentNode.children.containsKey(trie.endSymbol)) {
                contains.add(currentNode.word);

            }
        }

    }


    int count;
    public int numMatchingSubseq(String bigString, String[] smallStrings) {
        Trie trie = new Trie();
        for(String word:smallStrings){
            trie.insert(word);
        }
        System.out.println(trie);
        Set<String > contains = new HashSet<>();
        for (int index = 0; index < bigString.length(); index++) {
            containsHelper(trie,index,bigString,contains);

        }
        for (int i = 0; i < smallStrings.length; i++) {
            if(contains.contains(smallStrings[i]))
                count++;
        }
       return count;

    }
 /*   public  List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        // Write your code here.
        Trie trie = new Trie();
        for(String word:smallStrings){
            trie.insert(word);
        }
        Set<String > contains = new HashSet<>();
        for (int index = 0; index < bigString.length(); index++) {
            containsHelper(trie,index,bigString,contains);

        }
        List<Boolean> list = new ArrayList<>();
        for(String word:smallStrings)
           list.add(contains.contains(word));


        return list;
    }

  */

    public static void main(String[] args) {
        String  s = "abcde";
        String[] words = new String[]{"a","b","cd","acf"};
        MatchingStrings numberOfMatchingSubSequences = new MatchingStrings();
        System.out.println(numberOfMatchingSubSequences.numMatchingSubseq(s,words));
    }
}
