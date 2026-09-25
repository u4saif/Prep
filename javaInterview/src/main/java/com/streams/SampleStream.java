package com.streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//1. Find first nonrepeating character in string using Stream API
public class SampleStream {
    public static void main(String[] args) {
        String str = "erty";
//        Stream<Character> result = str.chars().mapToObj(c-> (char) c);
//        LinkedHashMap<Character, Long> result2 = result.collect(Collectors.groupingBy( Function.identity(),() -> new LinkedHashMap<>(),Collectors.counting()));
//        Stream<Map.Entry<Character, Long>> result3 = result2.entrySet().stream().filter(v->v.getValue()==1);
//        System.out.println(result3.findFirst().orElse(null));


       Map.Entry<Character, Long> dublicate =     str.chars()
                .mapToObj(c->(char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()))
                .entrySet().stream()
                .filter(r->r.getValue()==1)
                .findFirst().orElse(null);

        System.out.println(dublicate);
    }
}
