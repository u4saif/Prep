package october2026.test;

import java.util.HashMap;
import java.util.Map;
//head-> ---items <- tail
public class LRU<K,V> {
    int Capacity;
    Node<K,V> head , tail;
    Map<K,Node<K,V>> mymap = new HashMap<>();

    public LRU(int capacity){
        this.Capacity = capacity;
        head = new Node<>(null,null);
        tail = new Node<>(null,null);
        head.next = tail;
        tail.prev = null;
    }

    public class Node<K,V>{
        K key;
        V value;
        Node<K,V> next , prev;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private void unlink(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void addToHead(Node node){

        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void put(K key , V value){
        Node alreadyPresent = mymap.get(key);
        if(alreadyPresent != null){
            alreadyPresent.value = value;
            return;
        }

        if(mymap.size() == Capacity){
            Node lrusedNode = tail.prev;
            unlink(lrusedNode);
            mymap.remove(lrusedNode.key);
        }

        Node freshNode = new Node(key , value);
        addToHead(freshNode);
        mymap.put(key , freshNode);
    }

    public void showAll(){
        for(Map.Entry item : mymap.entrySet()){
            System.out.println(item);
        }
    }
}

class Test2{

    public static void main(String[] args) {
        System.out.println("Mycache");

        LRU mycc = new LRU(1);
        mycc.put(3,"three");

        mycc.put(4,"four");
//        mycc.get(3);
        mycc.put(5,"five");
//        System.out.println(mycc.get(3));
        mycc.put(6,"six");
        mycc.put(7,"six");
        mycc.showAll();
    }
}