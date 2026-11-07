package october2026.test;

import october2026.LruCache;

import java.util.HashMap;
import java.util.Map;

public class LeastRecentlyUsed <K,V>{
int SIZE;
Node head , tail;
Map<K,Node<K,V>> mymap = new HashMap<>();
    public LeastRecentlyUsed(int SIZE) {
        this.SIZE = SIZE;
        this.head = new Node(null, null);
        this.tail = new Node(null,null);
        this.head.next = tail;
        this.tail.prev = head;
    }

    public class Node<K,V>{
    K key;
    V value;
    Node<K,V> prev , next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

private void unlink(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
}

private void addToHead(Node node, K key){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        mymap.put(key,node);
}
public void put(K key , V value){
        //check if  key is null
        if(key == null){
            return;
        }
    //a;ready exist
        Node exisitingNode = mymap.get(key);
        if(exisitingNode != null){
            exisitingNode.value = value;
            unlink(exisitingNode);
        }
        Node freshNode = new Node(key , value);
        addToHead(freshNode,key);
    }

    public void seeNodes(){
        for(Map.Entry entry : mymap.entrySet()){
            System.out.print(entry.getKey()+"->");
        }
    }
}

class Sample{

    public static void main(String[] args) {
        LeastRecentlyUsed cache = new LeastRecentlyUsed(2);
        cache.put(200,"saif");
        cache.put(300,"saif300");
//        System.out.println( cache.get(200));
        cache.put(400,"saif400");
        cache.seeNodes();
//        System.out.println(cache.put(300););

    }
}
