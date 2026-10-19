package com.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamFour {

    public static void main(String[] args) {
        System.out.println("Stream four");

        List<String> words = Arrays.asList("java", "stream", "api");
        List<String> sentanceCase = words.stream()
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                .collect(Collectors.toList());
        System.out.println(sentanceCase);


        List<Integer> numbers = Arrays.asList(4, 5, 6, 5, 4, 3, 3, 3);
        List<Integer> sortBasedFreq = numbers.stream()
                .sorted(Comparator.comparingInt(n -> -Collections.frequency(numbers, n)))
                .distinct()
                .toList();
        System.out.println(sortBasedFreq);

        //generate random number
        List<Integer> ranDouble = new Random().ints(5, 1, 3)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(ranDouble);

        List<Integer> numbersSum = Arrays.asList(1, 2, 3, 4, 3, 5);
        int targetSum = 6;
        List<List<Integer>> pairs = numbersSum.stream()
                .flatMap(num -> numbersSum.stream()
                        .filter(a -> a + num == targetSum).map(b -> Arrays.asList(num, b))

                ).distinct().toList();

        System.out.println(pairs);


        List<String> keys = Arrays.asList("A", "B", "C");
        List<Integer> values = Arrays.asList(1, 2, 3);

        Map<String,Integer> myMap = IntStream.range(0,keys.size())
                .boxed()
                .collect(Collectors.toMap(keys::get,values::get))
                ;
        System.out.println(myMap);

        List<Integer> numbers2 = Arrays.asList(1, 2, 4, 5,3);

        boolean isSorted = IntStream.range(0,numbers2.size() -1)
                .allMatch(index -> numbers2.get(index) < numbers2.get(index +1));

        System.out.println(isSorted);

        Map<String, Integer> map = Map.of("A", 1, "B", 2, "C", 3);

       List<String> myMap2 = map.entrySet().stream()
                .map(item-> item.getKey()+"=" + item.getValue())
                .collect(Collectors.toList());
        System.out.println( myMap2);


        List<Integer> numbersDublicate = Arrays.asList(1, 2, 3, 4, 2, 5, 3, 6);

       Set<Integer> dublicate =  numbersDublicate.stream().filter(num-> Collections.frequency(numbers,num)>1)

               .collect(Collectors.toSet());
        System.out.println(dublicate);


        String input = "success";
        Map<Character,Long> count = input.chars().mapToObj(i->(char) i ).
                collect(Collectors.groupingBy(c->c,Collectors.counting()));

        Set<Map.Entry<Character,Long>> result =  count.entrySet().stream().filter(item->item.getValue()>1)
                        .collect(Collectors.toSet());
        System.out.println(count);
        System.out.println(result);

        List<String> words1 = Arrays.asList("stream",  "programming", "awesome","javaae");
        String str = words1.stream()
                .max(Comparator.comparing(wrd->
                        (int) wrd.chars()
                        .filter(c->
                                "aeiou".indexOf(c)!=-1)
                                .count())
                ).orElse(null);

        System.out.println(str);

        List<String> words2 = Arrays.asList("stream",  "programming", "awesome","javaaiie");
        String str2 = words2.stream()
                .max(Comparator.comparing(wrd -> (int) wrd.chars()
                        .filter(c->"aeiou".indexOf(c) != -1)
                        .count())

        ).orElse("");
        System.out.println("str2 "+ str2);


     }
}
