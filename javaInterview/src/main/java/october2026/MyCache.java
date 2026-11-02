package october2026;

import java.util.HashMap;
import java.util.Map;

public class MyCache<K,V> {
    private int capacity;
    Map<K,Node<K,V>> cacheMap = new HashMap<>();
    Node<K,V> head = new Node(null,null);
    Node<K,V> tail = new Node(null,null);

    public MyCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private static final class Node<K,V>{
        K key;
        V value;
        Node<K,V> next ,prev;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private void unlink(Node<K,V> node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
//        cacheMap.remove(node);
    }

private void addTohead(Node<K,V> node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
//        cacheMap.put(node.key, node);

}

public V get(K key){
        Node<K,V> node = cacheMap.get(key);
        if(node != null){
            unlink(node);
            addTohead(node);
            return node.value;
        }

        return  null;
}

public void showAll(){
        for(Map.Entry item : cacheMap.entrySet()){
            System.out.println(item);
        }
}
    public void put(K key,V value){
        Node<K,V> nodeExist = cacheMap.get(key);
        //Update already existing node
        if(nodeExist !=null){
            nodeExist.value = value;
            unlink(nodeExist);
            addTohead(nodeExist);
            return;
        }

        if(cacheMap.size() == capacity){
            //remove from tail
            Node<K,V> lastNode = tail.prev;
            unlink(lastNode);
            cacheMap.remove(lastNode.key);
        }

        Node<K,V> freshNode = new Node(key,value);
        //add to head
        addTohead(freshNode);
        cacheMap.put(key,freshNode);
    }
}

class Test2{

    public static void main(String[] args) {
        System.out.println("Mycache");

        MyCache mycc = new MyCache(2);
        mycc.put(3,"three");

        mycc.put(4,"four");
        mycc.get(3);
        mycc.put(5,"five");
       System.out.println(mycc.get(3));
       mycc.put(6,"six");
       mycc.put(7,"six");
        mycc.showAll();
    }
}
