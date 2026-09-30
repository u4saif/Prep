package dev.saif;

public class MyHashSet {
    int SIZE = 100;
    boolean[] arr;

    public MyHashSet() {
        arr = new boolean[SIZE];
    }

    public void  add(String value){
        int code = Math.floorMod(value.hashCode(),SIZE);
        arr[code] = true;
    }

    public void remove(int value){
        arr[value] = false;
    }

    public boolean contains(String value){
        int code = Math.floorMod(value.hashCode(),SIZE);
        if(arr[code]) return true;
        return false;
    }
}
