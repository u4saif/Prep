package com.javadsa;

import java.util.Date;

public class LinkList {
    public LinkList() {
        this.head = null;
    }
    
    public void addTohead(int value){
        if(this.head!=null){
            Node newNode = new Node(value , this.head);
            this.head = newNode;
        }else {
            Node newNode = new Node(value , null);
            this.head = newNode;
        }
    }

    public void traverseList(){
        Node currentNode = this.head;
        while (currentNode != null){
            System.out.print(currentNode.getValue()+"->");
            currentNode= currentNode.next;
        }
        System.out.println(":End");
    }
    public boolean isPresent(int searchKey){
        long currenrtime = System.currentTimeMillis();

        Node currentNode = this.head;
        while (currentNode!= null){
            if( currentNode.getValue() == searchKey) {
                long timetaken = System.currentTimeMillis() - currenrtime;
                System.out.println("timetaken: " + timetaken);
                return true;
            }
            currentNode = currentNode.next;
        }
        long timetaken = System.currentTimeMillis() - currenrtime;
        System.out.println("timetaken: " + timetaken);
        return false;
    }
    private Node head;
    
    public class Node{
        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    
}

