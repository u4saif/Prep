package com.javadsa;

//https://freedium-mirror.cfd/https://medium.com/@chandantechie/10-common-coding-interview-questions-using-java-4bbb55127a47

import java.util.*;

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
        int[] numArr = {2,4,6,3,5,7,8};
        System.out.println(getTargetSum(numArr,10).stream().map(Arrays::toString).toList());
        System.out.println(Arrays.deepToString(getTargetSum(numArr,10).toArray()));

    }

    private static List<Integer[]> getTargetSum(int[] numArr , int target) {
        Map<Integer,Integer> seenObj = new HashMap<>();
        List<Integer[]> result = new ArrayList<>();
        for(int index = 0; index < numArr.length; index++){
            int difference = target - numArr[index] ;
            if(seenObj.containsKey(difference)){
                result.add(new Integer[]{seenObj.get(difference), index});
               // return new int[]{seenObj.get(difference),num};
            }else {
                seenObj.put(numArr[index], index);
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
