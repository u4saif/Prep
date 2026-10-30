package com.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTestOctober {
    static List<Employee> employeeList = new ArrayList<>();

    static {
        employeeList.add(new Employee("saif", "shaikh", 2000.00, List.of("project angular", "project react", "project X")));
        employeeList.add(new Employee("Shabbir", "Dawoodi", 5000.0, List.of("Project 1", "Project 2")));
        employeeList.add(new Employee("Nikhil", "Gupta", 6000.0, List.of("Project 1", "Project 3")));
        employeeList.add(new Employee("Shivam", "shaikh", 5000.0, List.of("Project 3", "Project 4")));
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

//    ----------------------------------
//1:00  Handling Employees with Identical Salaries done
//1:14  Advanced: Convert Employee List to Map
//1:20  Date Filtering (Employees joined after 2010)
//1:24  Character Logic: Count Vowels & Consonants
    public static void main(String[] args) {
        System.out.println("Stream Test October");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 43, 6, 7, 43, 2, 21);
        List<Integer> numbers2 = Arrays.asList(  7, 43, 2, 21);
        List abc = numbers.stream().sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(1)
                .collect(Collectors.toList());
        System.out.println(abc);
        System.out.println(numbers.stream().reduce(Integer.MIN_VALUE, Integer::max));
        HashSet<Integer> dublicate = new HashSet<>();
        System.out.println( numbers.stream().filter(item-> !dublicate.add(item)).collect(Collectors.toList()));

        System.out.println(numbers.stream().collect(Collectors.groupingBy((item)->item%2==0)));
        System.out.println(

                numbers.stream().filter(item->numbers2.contains(item)).distinct().collect(Collectors.toSet() )
        );

        String ss = "siwis";
        HashSet<Character> chSet = new HashSet<>();
        Map.Entry stricUniq =ss.chars().mapToObj(ch->(char) ch)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(item->item.getValue()==1)
                .findFirst().orElse(null);

        System.out.println(stricUniq);
        System.out.println(
                new StringBuilder(ss).reverse().toString()
        );

        System.out.println(
                ss.equals( new StringBuilder(ss).reverse().toString())
        );
        Employee highestPaid = employeeList.stream().sorted(
                Comparator.comparing((employee -> employee.getSalary()),Comparator.reverseOrder())
        ).findFirst().orElse(null);

        System.out.println(highestPaid);

        System.out.println(    employeeList.stream()
               .collect(Collectors.groupingBy(s->s.getSalary(),Collectors.counting())));

        System.out.println(ss.chars().mapToObj(ch->(char) ch)
                .collect(Collectors.groupingBy(s->"aeiou".indexOf(s)>-1)).get(false).stream().distinct().toList());
    }
}
