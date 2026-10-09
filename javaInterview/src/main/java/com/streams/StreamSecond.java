package com.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.random;

public class StreamSecond {
    static List<Employee> employeeList = new ArrayList<>();

    static {
        employeeList.add(new Employee("saif", "shaikh", 2000.00, List.of("project angular", "project react", "project X")));
        employeeList.add(new Employee("Shabbir", "Dawoodi", 5000.0, List.of("Project 1", "Project 2")));
        employeeList.add(new Employee("Nikhil", "Gupta", 6000.0, List.of("Project 1", "Project 3")));
        employeeList.add(new Employee("Shivam", "Kumar", 5500.0, List.of("Project 3", "Project 4")));
    }

    public static void main(String[] args) {
//
//    Set<Employee>   increamentedSalary  =   employeeList.stream()
//                .map(employee -> new Employee(employee.getFirstName(),employee.getLastName(),employee.getSalary()*1.5,employee.getProjects()))
//                .collect(Collectors.toSet());
//        System.out.println(increamentedSalary);

    //filter
    Employee firstEmp =     employeeList.stream()
                .filter(employee -> employee.getSalary()>5000)
                .findAny().orElse(null);

        System.out.println(firstEmp);

    //flat map

     List<String> projects =    employeeList.stream()
            .map(employee -> employee.getProjects())
            .flatMap(strings -> strings.stream())
             .distinct()
             .collect(Collectors.toList());

        System.out.println(projects);


        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);



    }

}
