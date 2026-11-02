package october2026;

import java.util.HashMap;
import java.util.Map;

public class Cache<K,V> {
    private final int capacity;
    private final Map<K,Node<K,V>> map = new HashMap<>();
    private final Node<K,V> head = new Node(null,null);
    private final Node<K,V> tail = new Node(null,null);

    public Cache(int capacity) {
        if(capacity <=0) throw new IllegalArgumentException("capacity must be greater than Zero");
        this.capacity = capacity;
        head.next=tail;
        tail.prev=head;
    }

    private static final class Node<K,V>{
        final K key;
        V value;
        Node<K,V> prev, next;

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private void addToHead(Node<K,V> newNode){
        newNode.prev = head;
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
    }

    private void unlink(Node<K,V> pastNode){
        pastNode.prev.next = pastNode.next;
        pastNode.next.prev = pastNode.prev;
    }

    public Node get(K key){
        if(key == null) return null;
        Node<K,V> node = map.get(key);
        if (node !=null) {
            unlink(node);
            addToHead(node);
            return node;
        }
        return null;
    }

    public void put(K key, V value){
        Node<K,V> existingNode = map.get(key);
        if(existingNode != null){
            existingNode.value = value;
            unlink(existingNode);
            addToHead(existingNode);
            return;
        }

        if(map.size() == capacity){
            Node<K,V> lruNode = tail.prev;
            unlink(lruNode);
            map.remove(lruNode.key);
        }

        Node<K,V> addFreshNode = new Node<>(key , value);
        addToHead(addFreshNode);
        map.put(key , addFreshNode);
    }
}

class Test{

    public static void main(String[] args) {
        System.out.println("Lru test started");
        Cache cc = new Cache(2);
        cc.put(2, "two");
        cc.put(3, "three");
        cc.get(2);
        cc.put(4, "four");
        System.out.println(cc.get(2));
    }
}