package com.javadsa;


import java.util.ArrayList;
import java.util.List;

public class MyStack  {
    private final int SIZE;
    private int stackLength = 0;
    private int[] arr;
    public MyStack(int size) {
        SIZE = size;
        arr = new int[SIZE];
    }

    public void push(int value) throws Exception{
        if(arr.length == stackLength){
            throw  new Exception("Stack overflow");
        }
        arr[stackLength] = value;
        stackLength++;
    }

    public int peak(){
        int topValue = arr[stackLength-1];
        return topValue;
    }
}
