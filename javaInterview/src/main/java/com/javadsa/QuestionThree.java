import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QuestionThree {
    public static void main(String[] args) {
        List<Integer> arrIntegers = Arrays.asList(2, 413, 5, 3, 56, 41, 3);
        int[] nums = {2,4,5,73,6,3};
        // int[] arrIntegers2 = {2,3,6,5,4};
        // System.out.println(arrIntegers);
        // arrIntegers.stream().filter(x->x.toString().startsWith("5")).forEach(System.out::println);

        // System.out.println(temp);

        // arrIntegers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // Set<Integer> temp = new HashSet();
        // arrIntegers.stream().filter(x -> !temp.add(x)).findFirst()
        //         .ifPresent(x -> System.out.println("Dublicate present"));

        Arrays.stream(nums).min().ifPresent(System.out::println);

    }
}

/***
 * 
 * This video covers 25 Java 8 coding interview questions. Here is the list of
 * questions addressed in the video:
 * 1. **Find the first occurrence element** in a list of integers (0:46).
 * arrIntegers.stream().findFirst().ifPresent(System.out::println);
 * 2. **Find the total number of elements** in a list using stream (2:08).
 * long total = arrIntegers.stream().count();
 * 3. **Find all even and odd numbers** in a list (3:04).
 * arrIntegers.stream().filter(x->x%2==0).forEach(System.out::println);
 * 4. **Find numbers starting with 5** (4:53).
 * 5. **Find duplicate elements** in an integer list (6:10).
 * 6. **Find the maximum and minimum value** in a list (8:14).
 * Set<Integer> temp = new HashSet<>();
 * arrIntegers.stream().filter(x->temp.add(x)).forEach(System.out::println);
 * 
 * Set<Integer> temp = new HashSet();
 * numList.stream().filter(x->!temp.add(x)).forEach(System.out::println)
 * 
 * 7. **Sort all values** in a stream in ascending order (10:08).
 * 8. **Sort the list in descending order** (10:56).
 * 
 * 9. **Check if an array contains duplicate values** (11:44).
 * 
 * 10. **Find the square of numbers** and filter those greater than 50 (14:02).
 * 11. **Sort an array and convert it into a stream** (16:26).
 * 12. **Convert words to uppercase** using map (17:32).
 * 13. **Find the maximum element in an array** (19:07).
 * 14. **Concatenate two streams** (20:00).
 * 15. **Print 10 random numbers** using a stream (21:17).
 * 16. **Print current date and time** (22:22).
 * 17. **Format date and time** (DD-MM-YYYY) (23:15).
 * 18. **Check if a list is empty** using Optional (24:18).
 * 19. **Determine the occurrence count of a particular value** (26:51).
 * 20. **Find duplicate elements and their counts** in a string array (28:48).
 * 21. **Calculate the sum of employee salaries** (32:16).
 * 22. **Print the count of each character in a string** (35:41).
 * 23. **Convert a list of objects into a map** considering duplicate keys.
 * 24. **Homework Question 1** (41:58).
 * 25. **Homework Question 2** (41:58).
 */

/**
 * List<Integer> numList = new Arrays.asList(1,2,4,56,3);
 * numList.stream().findFirst().ifPresent(System.out::println);
 * 1. **Find the first occurrence element** in a list of integers (0:46).
 * numlist.stream().count()
 * 2. **Find the total number of elements** in a list using stream (2:08).
 * numlist.stream().filter(x->x%2==0).forEach(System.out::println)
 * 3. **Find all even and odd numbers** in a list (3:04).
 * 4. **Find numbers starting with 5** (4:53).
 * numList.stream().filter(x->x.toString().startsWith()).forEach(System.out::println)
 * 5. **Find duplicate elements** in an integer list (6:10).
 * Set<Integer> temp = new HashSet();
 * numList.stream().filter(x->!temp.add(x)).forEach(System.out::println)
 * 6. **Find the maximum and minimum value** in a list (8:14).
 * 7. **Sort all values** in a stream in ascending order (10:08).
 * 8. **Sort the list in descending order** (10:56).
 * 9. **Check if an array contains duplicate values** (11:44).
 * 10. **Find the square of numbers** and filter those greater than 50 (14:02).
 * 11. **Sort an array and convert it into a stream** (16:26).
 * 12. **Convert words to uppercase** using map (17:32).
 * 13. **Find the maximum element in an array** (19:07).
 * 14. **Concatenate two streams** (20:00).
 * 15. **Print 10 random numbers** using a stream (21:17).
 * 16. **Print current date and time** (22:22).
 * 17. **Format date and time** (DD-MM-YYYY) (23:15).
 * 18. **Check if a list is empty** using Optional (24:18).
 * 19. **Determine the occurrence count of a particular value** (26:51).
 * 20. **Find duplicate elements and their counts** in a string array (28:48).
 * 21. **Calculate the sum of employee salaries** (32:16).
 * 22. **Print the count of each character in a string** (35:41).
 * 23. **Convert a list of objects into a map** considering duplicate keys
 * (38:55).
 * 24. **Homework Question 1** (41:58).
 * 25. **Homework Question 2** (41:58).
 */