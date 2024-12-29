package com.cleo.algorithms.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuffixTrie {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }


    TrieNode root = new TrieNode();
    char endSymbol = '*';

    public SuffixTrie(String str) {
        // root.children.put('0',null);
        populateSuffixTrieFrom(str);
    }

    public void populateSuffixTrieFrom(String str) {
        // Write your code here.
        for (int i = 0; i < str.length(); i++) {
            populateSuffixTrieHelper(i, str);
        }

    }

    public void populateSuffixTrieHelper(int index, String str) {
        TrieNode node = root;
        for (int i = index; i < str.length(); i++) {
            if (!node.children.containsKey(str.charAt(i))) {
                node.children.put(str.charAt(i), new TrieNode());
            }
            node = node.children.get(str.charAt(i));
        }
       // node.children.put(endSymbol, null);

    }

    public boolean contains(String str) {
        // Write your code here.
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            if (!node.children.containsKey(str.charAt(i)))
                return false;
            node = node.children.get(str.charAt(i));
        }
        return true;

    }

}
