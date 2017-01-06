package com.shivang.practiceds.hash;

import java.util.LinkedList;

/**
 * Hash Map with linear probing
 *
 * Created by shivanggupta on 04/01/17.
 */
public class MyHashMap {
    public static final int HASH_SIZE = 256;

    private MyHashEntry[] hashMap;

    public MyHashMap() {
        hashMap = new MyHashEntry[HASH_SIZE];
        for (int i = 0; i < HASH_SIZE; i++)
            hashMap[i] = null;
    }

    public String get(String key) {
        int hash = hashFn(key);
        while (hashMap[hash] != null && !hashMap[hash].getKey().equals(key))
            hash = (hash + 1) % HASH_SIZE;
        if (hashMap[hash] == null)
            return "Error";
        else
            return hashMap[hash].getValue();
    }

    public void put(String key, String value) {
        int hash = hashFn(key);
        while (hashMap[hash] != null && !hashMap[hash].getKey().equals(key))
            hash = (hash + 1) % HASH_SIZE;
        hashMap[hash] = new MyHashEntry(key, value);
    }

    private int hashFn(String key) {
        int hashVal = 0;
        for (int i = 0; i < key.length(); i++) {
            hashVal ^= key.charAt(i);
        }
        return hashVal % HASH_SIZE;
    }

    public static void main(String[] args) {
        MyHashMapV1 map2 = new MyHashMapV1(128);
        map2.put("1", "ABC");
        map2.put("2", "DEF");
        map2.put("111", "JKL");
        map2.put("11111", "PQR");
        System.out.println("Map 1: " + "2     -> " + map2.get("2"));
        System.out.println("Map 1: " + "1     -> " + map2.get("1"));
        System.out.println("Map 1: " + "111   -> " + map2.get("111"));
        System.out.println("Map 1: " + "11111 -> " + map2.get("11111"));

        MyHashMap map = new MyHashMap();
        map.put("1", "ABC");
        map.put("2", "DEF");
        map.put("111", "JKL");
        map.put("11111", "PQR");
        System.out.println("Map 2: " + "2     -> " + map.get("2"));
        System.out.println("Map 2: " + "1     -> " + map.get("1"));
        System.out.println("Map 2: " + "111   -> " + map.get("111"));
        System.out.println("Map 2: " + "11111 -> " + map.get("11111"));
    }
}
