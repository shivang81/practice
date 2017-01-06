package com.shivang.practiceds.tries;

import java.util.HashMap;

/**
 * Created by shivanggupta on 05/01/17.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            TrieNode node;
            if(children.containsKey(word.charAt(i))) {
                node = children.get(word.charAt(i));
            } else {
                node = new TrieNode(word.charAt(i));
                children.put(word.charAt(i), node);
            }
            children = node.children;
            if(i == word.length() - 1)
                node.isWord = true;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if(!node.children.containsKey(word.charAt(i)))
                return false;
            node = node.children.get(word.charAt(i));
        }
        return node.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if(!node.children.containsKey(prefix.charAt(i)))
                return false;
            node = node.children.get(prefix.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("application");
        trie.insert("boy");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("boy"));
        System.out.println(trie.search("ap"));
        System.out.println(trie.search("bo"));
        System.out.println(trie.search("xyz"));

        System.out.println();

        System.out.println(trie.startsWith("a"));
        System.out.println(trie.startsWith("b"));
        System.out.println(trie.startsWith("ap"));
        System.out.println(trie.startsWith("applica"));
        System.out.println(trie.startsWith("zx"));
    }

}