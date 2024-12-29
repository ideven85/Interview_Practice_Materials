package com.cleo.algorithms.lists;
import java.util.*;
public class LRUCache {

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }
            static class Pair{
                String key;
                int value;

                public Pair(String key, int value) {
                    this.key = key;
                    this.value = value;
                }

                public Pair() {
                }
            }
            int maxSize;
    Pair[] map;
    int count=0;
            public LRUCache(int maxSize) {
                this.maxSize = Math.max(maxSize, 1);
                 map = new Pair[maxSize];
                 int count=0;
            }


    public void insertKeyValuePair(String key, int value) {
                // Write your code here.

            }
    LRUResult lruResult;
            public LRUResult getValueFromKey(String key) {
                // Write your code here.
                int value=0;
                for (int i = 0; i < map.length; i++) {
                    if(map[i].key.equals(key)){
                        value=map[i].value;
                        break;
                    }
                }
                if(value!=0)
                   lruResult=new LRUResult(true,value);
                else
                    lruResult = new LRUResult(false,0);
                return lruResult;
            }

            public String getMostRecentKey() {
                // Write your code here.
                return map[map.length-1].key;
            }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.insertKeyValuePair("a",1);
        cache.insertKeyValuePair("b",2);
        cache.insertKeyValuePair("c",3);
        cache.insertKeyValuePair("d",4);
        System.out.println(cache.getMostRecentKey());
        System.out.println(cache.getValueFromKey("a"));

    }



}
