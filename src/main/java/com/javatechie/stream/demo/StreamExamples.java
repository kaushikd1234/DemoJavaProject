package com.javatechie.stream.demo;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamExamples {

    public static void main(String[] args) {

        String input = "Kaushikkkkdeoooooo";

        // approach 1 of finding the occurrence count of each character in the string

        Map<String, Long> myMap = Arrays.stream(input.split(""))
                .collect(groupingBy(Function.identity(), counting()));

        System.out.println(myMap);

        // approach 2 of finding the occurrence count of each character in the string

        Map<Character, Long> map = input.chars().mapToObj(element -> (char) element)
                .collect(groupingBy(Function.identity(), Collectors.counting()));

        // System.out.println(map);


        // find the duplicate key and print

        List<String> duplicates = myMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(toList());

        System.out.println(duplicates);

        // find out the unique elements from the map

        List<String> uniqueElements = myMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(toList());

        System.out.println(uniqueElements);

        /***   find out the first highest number from the integer array **/

        int[] integers = {2, 10, 31, 21, 5, 7, 11};


        Integer highestNumber = Arrays.stream(integers).boxed()
                .sorted(Comparator.reverseOrder())
                .findFirst().get();
        System.out.println("first highest number " + highestNumber);

        // find out the 2nd highest number from the array

        Integer secondHighest = Arrays.stream(integers).boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().get();

        System.out.println("second highest number is " + secondHighest);

        // find the string with the highest length in the string array

        String[] words = {"Kaushik", "javatechie", "awspracticesession demo"};

        String highestLenthWord = Arrays.stream(words).reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                .get();
        System.out.println(highestLenthWord);


        // find out the number from the integer array which starts with 1
        int[] intArray = {2, 10, 31, 21, 5, 7, 11};

        List<String> listStartingWithOne = Arrays.stream(intArray).boxed()
                .map(String::valueOf)
                .filter(element -> element.startsWith("2"))
                .collect(toList());

        System.out.println("list starting with 2 is " + listStartingWithOne);

        // sorting the list by department and then print the list with higest salary

        List<Employee> employees = Stream.of(new Employee(1, "Kaushik", "DEV", 80000),
                        new Employee(2, "Preeti", "DEV", 90000),
                        new Employee(3, "Pankaj", "QA", 40000),
                        new Employee(4, "Abhishek", "Manager", 90000),
                        new Employee(5, "Divya", "HR", 60000),
                        new Employee(6, "Anisha", "HR", 50000))
                .collect(Collectors.toList());

        Map<String, Employee> empMap = employees.stream().collect(groupingBy(Employee::getDepartment,
                collectingAndThen(maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));

        // System.out.println(empMap);


    }
}
