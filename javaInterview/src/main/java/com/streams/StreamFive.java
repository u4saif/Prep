package com.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamFive {

    public static void main(String[] args) {
    System.out.println("Stream Five");
    List<Integer> numbers = Arrays.asList(4, 5, 6, 5, 4, 3);
    List<Integer> result =  numbers.stream()
            .sorted(Comparator.comparingInt(n-> -Collections.frequency(numbers,n)))
            .distinct()
            .collect(Collectors.toList());
        System.out.println(result);
    List<Integer> ran = new Random().ints(5,1,10)
            .boxed()
            .limit(5)
            .collect(Collectors.toList());

        System.out.println(ran);


        // Find Pair of Numbers with a Given Sum

        List<Integer> numberSum = Arrays.asList(1, 2, 3, 4, 5);
        int targetSum = 9;

        List<List<Integer>> pairs = numberSum.stream()
                .flatMap(a-> numberSum.stream()
                        .filter(b->a+b == targetSum && a< b )
                        .map(b->Arrays.asList(a,b)))
                .collect(Collectors.toList());
        System.out.println(pairs);

//        57. Combine Two Lists into a Map

        List<String> keys = Arrays.asList("A","B","C");
        List<Integer> values = Arrays.asList(2,3,4);

        Map<String ,Integer> myMap = IntStream.range(0,keys.size())
                .boxed()
                .collect(Collectors.toMap(
                        keys::get,
                        values::get
                ));

        System.out.println(myMap);








    }
}
