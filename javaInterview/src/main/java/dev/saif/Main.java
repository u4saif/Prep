package dev.saif;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] s = {3,2,7,5,1,6};
        int total = 7;
        int[] result = checkTarget(s,total);
        System.out.println(Arrays.toString(result));

        MyHashMap<String,String> myHashMap = new MyHashMap<>();
        myHashMap.put("saif","hello");
        myHashMap.put("raja","raja");
        myHashMap.put("raj","RAJA");
        System.out.println(myHashMap.get("raj"));


        MyHashSet myset = new MyHashSet();
        myset.add("Aa");
//        myset.add("saif");
//        System.out.println(myset.contains("32"));
        System.out.println(myset.contains("cB"));
        boolean[] barr = new boolean[5];
        barr[2]=true;
        System.out.println(Arrays.toString(barr));
        System.out.println("Aa".hashCode());  // 2112
        System.out.println("BB".hashCode());
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