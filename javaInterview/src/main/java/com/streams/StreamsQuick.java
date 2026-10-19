package com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class StreamsQuick {

    public static void main(String[] args) {
        System.out.println("Stream quick recap");
//        Student s1 = new Student("saif", "shaikh", 4, Arrays.asList("aws","java","spring"),"CS");
        List<Student> studetns = Stream.of(
                new Student("saif", "shaikh", 4, Arrays.asList("aws","java","spring"),"CS"),

                new Student("raja", "shaikh", 5, Arrays.asList("CSS","javascript","HTML"),"ECE"),

                new Student("ayat", "rehman", 1, Arrays.asList("rhymes","aphabets","poems"),"NURSERY"),

                new Student("sultana", "shaikh", 6, Arrays.asList("bengla","history","songs"),"CS"),

                new Student("nasir", "nazir", 2, Arrays.asList("Trading","formula","chemical","songs"),"CHEMISTRY")

                ).collect(Collectors.toList());


//1. Filter students with a rank between 5 and 10
//       Long ranked = studetns.filter(s->5<= s.getRank() &&  s.getRank()<10)
//               .collect(Collectors.counting());
//
//        System.out.println(ranked);


//        studetns.forEach(System.out::println);
//2. Filter students by lastName and sort them by firstname
List<Student> sortedStudent = studetns.stream().filter(s->s.getLastName().equals(""))
                .sorted(Comparator.comparing(Student::getFirstName,Comparator.reverseOrder())).toList();
        System.out.println(sortedStudent);

//3. Extract all unique department names
List<String> dname= studetns.stream().map(Student::getDepartment).distinct().collect(Collectors.toList());
        System.out.println(dname);
//4. Find all skills from the student list
      List<String> skills = studetns.stream().flatMap(s -> s.getSkilss().stream()).distinct().collect(Collectors.toList());
        System.out.println(skills);
//5. Group students by department name

//6. Count the number of students in each department
//7. Find the department with the maximum number of students
//8. Find the average age of male and female students
//9. Find the highest rank in each department
//10. Find the student with the second-highest rank

    }


}

class Student{
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public List<String> getSkilss() {
        return skilss;
    }

    public void setSkilss(List<String> skilss) {
        this.skilss = skilss;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", rank=" + rank +
                ", skilss=" + skilss +
                ", department='" + department + '\'' +
                '}';
    }

    private String lastName;

    public Student(String firstName, String lastName, int rank, List<String> skilss, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rank = rank;
        this.skilss = skilss;
        this.department = department;
    }

    private int rank;
    private List<String> skilss;
    private String department;
}
