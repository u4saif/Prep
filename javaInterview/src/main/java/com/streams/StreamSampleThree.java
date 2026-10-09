package com.streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamSampleThree {

    public static void main(String[] args) {
        System.out.println("stream sample thee");
        List<Integer> numbers = Arrays.asList(1,3,60,2,54,60);
        numbers.stream()
                .map(num->num)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        Integer maxnum = numbers.stream().max(Integer::compare).orElse(null);
        System.out.println(maxnum);


        List<String> names = Arrays.asList("Alice", "Bob", "Annie", "Alex", "Charlie");
       long c =  names.stream().filter(name->name.startsWith("A"))
                .count();

        System.out.println(c);
//                .forEach(System.out::println);

        List<String> upperName = names.stream().map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(upperName);
        String input = "swiss";
        Optional<Character> nonRepeating = input.chars()
                .mapToObj(ch-> (char) ch)
                .filter(ch->input.indexOf(ch) == input.lastIndexOf(ch))
                .findFirst();
        System.out.println(nonRepeating);
        List<Integer> numberz = Arrays.asList(1, 2, 3, 4, 5);
        int total;
        total = numberz.stream().mapToInt(Integer::intValue).sum();
        System.out.println("total  "+total);

        List<String> words = Arrays.asList("Java", null, "Stream", null, "API");
        List<String> wordresutl=  words.stream().filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println(wordresutl);

        Map<String,Integer> mymap = Map.of("A",2,"B",4,"D",3);

        System.out.println( mymap.entrySet().stream().filter(item->item.getValue()%2==0).collect(Collectors.toSet()));
        System.out.println(numbers.stream().distinct().collect(Collectors.toSet()));
    }
}
