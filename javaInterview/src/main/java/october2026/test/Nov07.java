package october2026.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Nov07 {

    public static void main(String[] args) {
        System.out.println("Nov7");

        String str = "aaaaabbbbccccaaaabbbcccc";

       Map<Character,Long> result =  str.chars().mapToObj(ch->(char) ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()));
        System.out.println(result);
    }
}
