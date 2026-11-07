package october2026;

import java.util.Arrays;

public class MyHashMap<K,V> {

    //Map-> store key with hashcode and value in the bucket for the hashcode

    // put , get

    int size ;
    Node<K,V>[] arrBucket;
    public MyHashMap(int size){
        this.size = size;
        arrBucket = new Node[size];
    }

    public class Node<K,V>{
        K key;
        V value;
        Node next;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void put(K key , V value){
            Node newNode = new Node(key,value);
            int hashCode = key.hashCode();
        }

    }
}
