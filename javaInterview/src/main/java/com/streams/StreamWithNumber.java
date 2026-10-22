package com.streams;

import com.sun.security.jgss.GSSUtil;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamWithNumber {
    public static void main(String[] args) {
        System.out.println("Number with stream");
        List<Integer> number = Arrays.asList(5,2,6,10,53,3,22,0);
        List<Integer> numberTwo = Arrays.asList(5,2,6,3,22,0);
        Integer highest = number.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().orElse(null);
        System.out.println(highest);

        Integer highWithReduce = number.stream().reduce(Integer.MIN_VALUE,Integer::max);
        System.out.println("highWithReduce "+highWithReduce);

        HashSet<Integer> unique = new HashSet<>();
        List<Integer> dublicates =  number.stream()
                .filter(s->!unique.add(s)).collect(Collectors.toList());
        System.out.println("Dublicated "+ dublicates);

       Map<Boolean,List<Integer>> evenOdd = number.stream().collect(Collectors.partitioningBy(i->i%2==0));
       System.out.println(evenOdd);

       List<Integer> common = number.stream().filter( num-> numberTwo.contains(num)).toList();

        System.out.println("common"+common);


        String stringOne = "iamsfudsdnia";
        HashSet<Character> strSet = new HashSet<>();
       // Character step1 = stringOne.chars().mapToObj(ch->(char) ch).filter(item->strSet.add(item)).findFirst().orElse(null);
        //Better approach ↓
        Character step1  = stringOne.chars().mapToObj(ch->(char) ch).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                        .entrySet().stream().filter(ch->ch.getValue()==1)
                        .map(i->i.getKey())
                        .findFirst().orElse(null);


        System.out.println(step1);

    String nameStr = "saifuddins";
    Character nchar = nameStr.chars().mapToObj(ch->(char) ch)
            .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
            .entrySet().stream().filter(st->st.getValue()>1)
            .map(c->c.getKey())
            .findFirst().orElse(null);
        System.out.println(nchar);


    }



}


//1:07 Find Nth Highest Number (Must Know!)
//4:41 Top K Highest Numbers using Streams
//7:11 Max Element using .reduce()
//10:07 Identify Duplicate Elements in a List
//12:45 Partitioning: Separate Even & Odd Numbers
//16:29 Find Common Elements Between Two Lists
//21:23 First Non-Repeated Character (Tricky!)
//31:00 String Reversal the Java 8 Way
//36:27 Palindrome Check using Streams
//43:05 Deep Dive: Employee Object Coding Problems
//49:34 Logic for Highest Salary Employee
//53:49 Finding the Second Highest Salary
//54:51 How to Group Employees by Department
//57:52 Counting Employees by Gender
//1:00  Handling Employees with Identical Salaries
//1:14  Advanced: Convert Employee List to Map
//1:20  Date Filtering (Employees joined after 2010)
//1:24  Character Logic: Count Vowels & Consonants