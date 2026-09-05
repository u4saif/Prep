package com.javadsa;

/**
 Array
 Link list
 Hashmap
 Hashset
 stack
 Queues
 priority queues
 tree
 graph
 map
*/
public class Main {
    public static void main(String[] args) {
//        LinkList ll = new LinkList();
//        ll.addTohead(10);
//        ll.addTohead(2099999999);
//        ll.addTohead(34);
//        ll.addTohead(34);
//        ll.addTohead(34);
//        ll.addTohead(34);
//        ll.addTohead(34);
//        ll.addTohead(34);
//        ll.addTohead(34);
//        ll.addTohead(34);
//        ll.addTohead(34);
//        ll.addTohead(34);
//        ll.addTohead(34);
//        ll.addTohead(34);
//        ll.addTohead(34);
//        ll.addTohead(34);
//        ll.addTohead(2099999999);
//        System.out.println("check if 20 present: " + ll.isPresent(2099999999));
//        ll.traverseList();
        MyStack ms = new MyStack(4);
        try {

            ms.push(23);
            ms.push(5);
            ms.push(6);
            ms.push(7);
            ms.push(87);
            System.out.println(ms.peak());
        }catch (Exception e){
            System.out.println(e);

    }}
}
