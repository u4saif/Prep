package october2026.test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class InterviewTest {

    public static void main(String[] args) {
        HelloImpl obj = new HelloImpl();
        obj.display();

        String str = "aaaaabbbbccccaaaabbbcccc";
        Map<Character, Long> countMap =  str.chars().mapToObj(ch->(char) ch)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,Collectors.counting()));

        System.out.println(countMap);
    }
}

interface Hello{
    void display();
}

class HelloImpl implements Hello{

      public void display(){
        System.out.println("hello");
    }
//Employee has: id, name, age, salary.  Asumming this class have the getter and setter already created
//    List<Employee> list = new ArrayList<>();
//
//      list.stream()
//              .filter((emp)->emp.getSalary>50000)
//            .map(emp->emp.getName())
//            .sorted(Comparator.reverseOrder())
//            .collect(Collection.toList())

}