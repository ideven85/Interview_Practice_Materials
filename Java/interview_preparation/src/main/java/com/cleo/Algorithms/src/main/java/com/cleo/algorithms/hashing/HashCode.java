package com.cleo.algorithms.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashCode {
    public static void main(String[] args) {
        String s = "amit";
        int hash = (int)('a')+(int)('m')+(int)('i')+(int)('t');
        System.out.println(hash%26);
        System.out.println(.7*12);
        Map<Integer,Integer> map = new HashMap<>();
    }
}
/*public class Map<K,V> {
    ArrayList<Map<K,V>> buckets; int count;
    int numBuckets;
    public Map() {
        buckets = new ArrayList<>(); numBuckets = 20;
        for(int i=0;i<numBuckets;i++) {
            buckets.add(null); }
    }
    private int getBucketIndex(K Key) {
        int hc = Key.hashCode();
        int index = hc%numBuckets; return index;
    }
    public void insert (K value,V Value) {
        int bucketIndex = getBucketIndex(value); Map<K,V> head = buckets.get(bucketIndex); //element is not there ? just update its value
        while(head!= null) { if(head.key.equals(key)) {
            head.value = value;
            return; }
            head = head.next; }
// element is not there.insert at 0th position of linked list head = buckets.get(bucketIndex);
        MapNode<K,V> head = new MapNode<>(Key,Value); newNode.next = head;
        buckets.set(bucketIndex , newNode);
        count++;


 */