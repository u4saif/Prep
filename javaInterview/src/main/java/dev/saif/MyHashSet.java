package dev.saif;

public class MyHashSet {
    int SIZE = 10000;
    boolean[] arr;

    public MyHashSet() {
        arr = new boolean[SIZE];
    }

    public void  add(int value){
        arr[value] = true;
    }

    public void remove(int value){
        arr[value] = false;
    }

    public boolean contains(int value){
        if(arr[value]) return true;
        return false;
    }
}
