package com.shivang.practiceds.hash;

/**
 * Hash Map with linear probing
 *
 * Created by shivanggupta on 04/01/17.
 */
public class MyHashMapV2 {
    public static final int DEFAULT_HASH_SIZE = 256;

    private MyHashEntry[] hashMap;
    private int hashSize;

    public MyHashMapV2() {
        this.hashSize = DEFAULT_HASH_SIZE;
        hashMap = new MyHashEntry[this.hashSize];
        for (int i = 0; i < this.hashSize; i++)
            hashMap[i] = null;
    }

    public MyHashMapV2(int hashSize) {
        this.hashSize = hashSize;
        hashMap = new MyHashEntry[this.hashSize];
        for (int i = 0; i < this.hashSize; i++)
            hashMap[i] = null;
    }

    public String get(String key) {
        int hash = hashFn(key);
        int i = 0;
        while (hashMap[hash] != null && !hashMap[hash].getKey().equals(key) && i < this.hashSize) {
            hash = (hash + 1) % this.hashSize;
            i++;
        }
        if (i > this.hashSize || hashMap[hash] == null)
            return "Error";
        else
            return hashMap[hash].getValue();
    }

    public void put(String key, String value) {
        int hash = hashFn(key);
        int i = 0;
        while (hashMap[hash] != null && !hashMap[hash].getKey().equals(key) && i < this.hashSize) {
            hash = (hash + 1) % this.hashSize;
            i++;
        }
        if(i < this.hashSize)
            hashMap[hash] = new MyHashEntry(key, value);
    }

    private int hashFn(String key) {
        int hashVal = 0;
        for (int i = 0; i < key.length(); i++) {
            hashVal ^= key.charAt(i);
        }
        return hashVal % this.hashSize;
    }

    public static void main(String[] args) {
        MyHashMapV2 map1 = new MyHashMapV2();
        map1.put("1", "ABC");
        map1.put("2", "DEF");
        map1.put("111", "JKL");
        map1.put("11111", "PQR");
        System.out.println("Map 1: " + "2     -> " + map1.get("2"));
        System.out.println("Map 1: " + "1     -> " + map1.get("1"));
        System.out.println("Map 1: " + "111   -> " + map1.get("111"));
        System.out.println("Map 1: " + "11111 -> " + map1.get("11111"));

        MyHashMapV2 map2 = new MyHashMapV2(3);
        map2.put("1", "ABC");
        map2.put("2", "DEF");
        map2.put("111", "JKL");
        map2.put("11111", "PQR");
        System.out.println("Map 1: " + "2     -> " + map2.get("2"));
        System.out.println("Map 1: " + "1     -> " + map2.get("1"));
        System.out.println("Map 1: " + "111   -> " + map2.get("111"));
        System.out.println("Map 1: " + "11111 -> " + map2.get("11111"));


    }
}
