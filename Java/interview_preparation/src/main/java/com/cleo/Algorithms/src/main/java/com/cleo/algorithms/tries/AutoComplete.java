package com.cleo.algorithms.tries;

import java.util.ArrayList;

public class AutoComplete {
    private TrieNode root;
    public int count;

    public AutoComplete() {
        this.root=new TrieNode('\0');
    }

    private void add(TrieNode root, String word) {
        if (word.isEmpty() ){
            root.isTerminating = true;
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
        add(root, word);
    }


    public boolean search(String word) {
        return search(root, word, "");
    }

    private boolean search(TrieNode root, String word, String autoCompleted) {
        if (word.isEmpty()) {
            if (root.isTerminating) {
                System.out.println(autoCompleted);
            }
            for (int i = 0; i < 26; i++) {
                if (root.children[i]!=null){
                    search(root.children[i],"",autoCompleted+root.children[i].data);
                }
            }
            return true;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return false;
        }
        return search(child, word.substring(1), autoCompleted + word.charAt(0));
    }


    public void autoComplete(ArrayList<String> input, String word) {

        // Write your code here
        for(String words:input)
            add(words);
        search(word);

    }
    private void autoCompleteHelper(TrieNode root,String word,StringBuilder sb){
        if(word.isEmpty()) {
            if(root.isTerminating)
                System.out.println(sb);
            for (int i = 0; i < 26; i++) {
                if(root.children[i]!=null) {
                    sb.append(root.children[i].data);
                    autoCompleteHelper(root.children[i], "", sb);
                }
            }
            return;

        }
        int index = word.charAt(0)-'a';
        TrieNode child=root.children[index];

        if(child!=null){

            sb.append(word.charAt(0));
            autoCompleteHelper(child,word.substring(1),sb);
        }

    }


    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("do");
        words.add("dont");
        words.add("no");
        words.add("note");
        words.add("notes");
        words.add("den");
        AutoComplete autoComplete = new AutoComplete();
        autoComplete.autoComplete(words,"no");

    }
}
