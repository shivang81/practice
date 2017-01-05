package com.shivang.practiceds.hash;

/**
 * Created by shivanggupta on 04/01/17.
 */
public class MyHashEntry {
    private String key;
    private String value;

    public MyHashEntry(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
