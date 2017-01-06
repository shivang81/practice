package com.shivang.practiceds.tries;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shivanggupta on 05/01/17.
 */
public class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isWord;

    public TrieNode(char c) {
        this.c = c;
    }

    public TrieNode() {
    }
}
