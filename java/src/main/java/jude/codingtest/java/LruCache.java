package jude.codingtest.java;

import java.util.LinkedHashMap;


public class LruCache {

    /**
     * Design and implement a data structure for Least Recently Used (LRU) cache.
     * It should support the following operations: get and put.
     *
     * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
     *
     * The cache is initialized with a positive capacity.
     *
     * Follow up:
     * Could you do both operations in O(1) time complexity?
     *
     * Example:
     *
     * LruCache cache = new LruCache(2);
     *
     *cache.put(1,1);
     *cache.put(2,2);
     *cache.get(1);       // returns 1
     *cache.put(3,3);    // evicts key 2
     *cache.get(2);       // returns -1 (not found)
     *cache.put(4,4);    // evicts key 1
     *cache.get(1);       // returns -1 (not found)
     *cache.get(3);       // returns 3
     *cache.get(4);       // returns 4

     */


    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }



    public static class LRUCache {
        public LinkedHashMap<Integer, Integer> map;
        public int capacity;
        public int cursor;
        LRUCache(int value) {
            map = new LinkedHashMap<>();
            capacity = value;
            cursor = 0;
        }

        public int get(int key) {
            if(!map.containsKey(key))
                return -1;

            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)) {
                map.remove(key);
                map.put(key, value);
            } else {
                map.put(key, value);
                cursor++;
                if(cursor > capacity) {
                    int targetKey = map.keySet().iterator().next();
                    map.remove(targetKey);
                    cursor--;
                }
            }
        }

    }



    /**
     * Your LruCache object will be instantiated and called as such:
     * LruCache obj = new LruCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}
