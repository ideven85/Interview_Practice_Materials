package com.cleo.algorithms.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PalindromePair {
    private final TrieNode root;
    public int count;

    public PalindromePair() {
        root = new TrieNode('\0');
    }
    int counter=0;
    private void add(TrieNode root, String word) {
        if(counter==0) {
         //   System.out.print(word+ " ");
            counter++;
        }
        if (word.length() == 0) {
            root.isTerminating = true;
            counter--;
            return;
        }

        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];

        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }

        add(child, word.substring(1));
    }

    public void add(String word) {
        if (word.isEmpty()) return;
        add(root, word);
       // System.out.print(word+" ");
        add(word.substring(1));
        add(word.substring(0, word.length() - 1));
    }

    private boolean search(TrieNode root, String word) {
        if (word.isEmpty()) {
            return root.isTerminating;
        }

        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];

        if (child == null) {
            return false;
        }

        return search(child, word.substring(1));

    }

    public boolean search(String word) {
        return search(root, word);
    }

    private void print(TrieNode root, String word) {
        if (root == null) {
            return;
        }

        if (root.isTerminating) {
            System.out.println(word);
        }

        for (TrieNode child : root.children) {
            if (child == null) {
                continue;
            }
            String fwd = word + child.data;
            print(child, fwd);
        }
    }

    public void print() {
        print(this.root, "");
    }





    /*..................... Palindrome Pair................... */


    public boolean isPalindromePair(ArrayList<String> words) {
        for (String s : words) add(s);
        boolean ans = false;
        for (String s : words) {
            if (search(new StringBuilder(s).reverse().toString())) {
                ans = true;
                break;
            }
        }
        return ans;
    }











    /*..................... Palindrome Pair................... */



    public boolean isPalindromePairV1(ArrayList<String> words) {
        for (String s : words) add(s);
        boolean ans = false;
        for (String s : words) {
            if (search(new StringBuffer(s).reverse().toString())) {
                ans = true;
                break;
            }
        }
        return ans;
    }
      public static void main(String[] args) {
        PalindromePair pair = new PalindromePair();
        ArrayList<String> words = new ArrayList<>();
        words.add("ab");
        words.add("bba");
        words.add("ghi");
        words.add("mcba");
        words.add("notes");
        words.add("den");
      //  words.add("cba");
        //do dont no not note notes den
        System.out.println(pair.isPalindromePairV1(words));
        String word="bbbab";
          System.out.println("Notes:(seton)"+pair.search("seton"));
        System.out.println(word.equals(new StringBuilder(word).reverse().toString()));

    }

}
