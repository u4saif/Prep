package dev.saif;

import java.util.Objects;

public class MyHashMap<K,V> {

    private int SIZE = 5;
    private Node<K, V> table[];

    public MyHashMap() {
        table = new Node[SIZE];
    }

    public class Node<K, V> {
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }


    }

    public void put(K key, V value) {
        int hashIndex = key.hashCode() % SIZE;
        Node currentNode = table[hashIndex];
        if (currentNode == null) {
            table[hashIndex] = new Node(key, value);
        } else {
            while (currentNode.next != null) {
                if (Objects.equals(key, currentNode.getKey())) {
                    currentNode.setValue(value);
                    return;
                }
                currentNode = currentNode.next;
            }
            currentNode.next = new Node(key, value);
        }
    }

    public V get(K key) {
        int hashIndex = key.hashCode() % SIZE;
        Node currentNode = table[hashIndex];

            while (currentNode!= null){
                if (Objects.equals(currentNode.getKey(), key)){
                    return (V) currentNode.getValue();
                }
                currentNode = currentNode.next;
            }

        return null;
    }


}
