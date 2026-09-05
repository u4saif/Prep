package dev.saif;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyHashSetOptimized {

       private final int SIZE = 10000;
       private final int ARRAY_SIZE = 100;
       private  List<List<Integer>> parentList ;

    public MyHashSetOptimized() {
        parentList = new ArrayList<>(ARRAY_SIZE);

        for (int i=0;i<ARRAY_SIZE;i++){
            parentList.add(null);
        }
    }

    public void add(int value){
        int bucketIndex = value % ARRAY_SIZE;
        List<Integer> childItem = parentList.get(value);
        if(childItem==null){

        }
    }
}
