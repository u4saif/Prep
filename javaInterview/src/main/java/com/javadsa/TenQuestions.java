package com.javadsa;

//https://freedium-mirror.cfd/https://medium.com/@chandantechie/10-common-coding-interview-questions-using-java-4bbb55127a47

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TenQuestions {

    public static void main(String[] args) {

        System.out.println("Ten questions");
        //reverse a string
        String str = "Hello saif";
        System.out.println(reverseString(str));

        // check if palindrome
        String p = "racecar";
        System.out.println(isPalindrome(p));

        //Find Duplicate in Array of Integer
        int[] nums = {23,4,23,4,6,7,2,21};
        System.out.println(getDuplicates(nums));

        // Find duplicate Fruits;
        String [] fruits = {"apple","banana","apple","mango","banana"};
        System.out.println(getDuplicates(fruits));

        //Find the two sum
        int[] numArr = {2,3,5,7,4,6,8};
        System.out.println(getTargetSum(numArr,10));

    }

    private static List<Integer> getTargetSum(int[] numArr , int targetsum) {
        Set<Integer> seen= new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int num : numArr){
            int defrence = num - targetsum;
            if (seen.add(defrence)){
                result.add(defrence);
            }
        }
        return result;
    }

    private static List<Integer> getDuplicates(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> dublicate = new ArrayList<>();
        for (int num: nums){
            if(!seen.add(num)){
                dublicate.add(num);
            }
        }
        return dublicate;
    }


    private static Set<String> getDuplicates(String[] arr) {
        Set<String> seen = new HashSet<>();
        List<String> duplicate = new ArrayList<>();
        for (String item : arr){
            if(!seen.add(item)){
                duplicate.add(item);
            }
        }
        return seen;
    }

    public static String reverseString(String s){
       StringBuilder str2 = new StringBuilder(s);
       return str2.reverse().toString();

    }

    public static Boolean isPalindrome(String s) {
        int left =0;
        int right = s.length() -1 ;
        while (left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}
