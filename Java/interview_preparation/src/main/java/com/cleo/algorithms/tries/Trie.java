package com.cleo.algorithms.tries;


import java.util.ArrayList;
import java.util.Arrays;

class TrieNode{

    char data;
    boolean isTerminating;
    TrieNode[] children;
    int childCount;

    public TrieNode(char data) {
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
        childCount = 0;
    }
}

public class Trie {

    private final TrieNode root;

    public int getCount() {
        return count;
    }

    private int count;
    public Trie() {
        root = new TrieNode('\0');
    }

    public boolean search(String word){
        return search(root, word);
    }

    private boolean search(TrieNode root, String word) {
        // implement this function
        if(root==null)
            return false;
        if(word.isEmpty()) {

            return root.isTerminating;
        }
        char ch = word.charAt(0);
        int childIndex=ch-'a';
        if(root.children[childIndex]==null)
            return false;
        TrieNode child=root.children[childIndex];

          return search(child,word.substring(1));
    }

    private boolean add(TrieNode root, String word){
        if(word.isEmpty()){
            root.isTerminating = true;
            return true;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null){
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
      return   add(child, word.substring(1));

    }

    public void add(String word){
        if(add(root, word))
            count++;
    }

    public void remove(String word){
        if(remove(root,word))
            count--;
    }
    private boolean remove(TrieNode root,String word){

        if(word.isEmpty()){
            root.isTerminating=false;
            return true;
        }


            int childIndex=word.charAt(0)-'a';
            TrieNode child=root.children[childIndex];
            if(child!=null)
               return remove(child,word.substring(1));
            else
                return false;



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
    public boolean patternMatching(ArrayList<String> vect, String pattern) {
        // Write your code here
        //dictionary=["habcd","dehf","ghi","hello"]
        // [pattern="hi"]
        // answer=true
        for(String word:vect){
            add(word);
        }
        return false;

    }
  /*  public boolean delete(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        // All nodes below 'deleteBelow' and on the path starting with 'deleteChar' (including itself) will be deleted if needed
        TrieNode deleteBelow = null;
        char deleteChar = '\0';

        // Search to ensure word is present
        TrieNode parent = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);

            TrieNode child = parent.children.get(cur); // Check if having a TrieNode associated with 'cur'
            if (child == null) { // null if 'word' is way too long or its prefix doesn't appear in the Trie
                return false;
            }

            if (parent.children.size() > 1 || parent.isEndOfWord) { // Update 'deleteBelow' and 'deleteChar'
                deleteBelow = parent;
                deleteChar = cur;
            }

            parent = child;
        }

        if (!parent.isEndOfWord) { // word isn't in trie
            return false;
        }

        if (parent.children.isEmpty()) {
            deleteBelow.children.remove(deleteChar);
        } else {
            parent.isEndOfWord = false; // Delete word by mark it as not the end of a word
        }

        return true;
    }
   */

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("anc"));
        trie.add("de");
        trie.add("anchit");
        trie.add("aanchal");
        trie.add("aashvi");
       // System.out.println(Arrays.toString(trie.root.children).substring(0,10));
         System.out.println(trie.search("deven"));
        System.out.println(trie.search("aashvi"));
        System.out.println(trie.search("aa"));
        trie.remove("deven");
        System.out.println(trie.search("deven"));
        System.out.println(trie.getCount());
        //trie.print(trie.root,"");
        trie.print();
    }
}