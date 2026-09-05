package dev.saif;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] s = {3,2,7,5};
        int total = 7;
        int[] result = checkTarget(s,total);
        System.out.println(Arrays.toString(result));

        MyHashMap<String,String> myHashMap = new MyHashMap<>();
        myHashMap.put("saif","hello");
        myHashMap.put("raja","raja");
        myHashMap.put("raj","RAJA");
        System.out.println(myHashMap.get("raj"));


        MyHashSet myset = new MyHashSet();
        myset.add(23);
        myset.add(24);
        myset.add(9999);
        myset.remove(24);
        System.out.println(myset.contains(23));

    }


    public static int[] checkTarget(int[] s , int total){
        HashMap<Integer, Integer> comps = new HashMap<>();

        for(int i=0 ; i<=s.length;i++){
           int compliment = total - s[i];
           if(comps.containsKey(compliment)){
               return  new int[]{i,comps.get(compliment)};
           }
           comps.put(s[i],i);
        }

        return new int[]{2,1};
    }



}