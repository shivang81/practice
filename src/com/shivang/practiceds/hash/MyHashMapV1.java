package com.shivang.practiceds.hash;

/**
 * A simple hash map implementation
 *
 * Created by shivanggupta on 04/01/17.
 */
public class MyHashMapV1 {
    public static final int HASH_SIZE = 256;

    private String[] hashMap;

    private int hashSize;

    public MyHashMapV1(int hashSize) {
        this.hashSize = hashSize;
        hashMap = new String[this.hashSize];
        for (int i = 0; i < this.hashSize; i++)
            hashMap[i] = null;
    }

    public MyHashMapV1() {
        this.hashSize = HASH_SIZE;
        hashMap = new String[HASH_SIZE];
        for (int i = 0; i < this.hashSize; i++)
            hashMap[i] = null;
    }

    public String get(String key) {
        int hash = hashFn(key);
        return hashMap[hash];
    }

    public void put(String key, String value) {
        int hash = hashFn(key);
        hashMap[hash] = value;
    }

    private int hashFn(String key) {
        int hashVal = 0;
        for (int i = 0; i < key.length(); i++) {
            hashVal ^= key.charAt(i);
        }
        return hashVal % this.hashSize;
    }

    public static void main(String[] args) {
        MyHashMapV1 map = new MyHashMapV1();
        map.put("1", "ABC");
        map.put("2", "DEF");
        map.put("4", "GHI");
        map.put("111", "JKL");
        System.out.println(map.get("1"));
        System.out.println(map.get("111"));

        MyHashMapV1 map2 = new MyHashMapV1(128);
        map2.put("1", "ABC");
        map2.put("2", "DEF");
        map2.put("4", "GHI");
        map2.put("111", "JKL");
        System.out.println(map.get("1"));
        System.out.println(map.get("111"));
    }

}
