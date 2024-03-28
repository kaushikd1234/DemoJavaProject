package com.javatechie.stream.demo;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamExamples {

    public static void main(String[] args) {

        String input = "Kaushikkkkdeoooooo";

        Map<Character, Long> map = input.chars().mapToObj(element -> (char) element)
                .collect(groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map);

        List<Employee> employees = Stream.of(new Employee(1, "Kaushik", "DEV", 80000),
                        new Employee(2, "Preeti", "DEV", 90000),
                        new Employee(3, "Pankaj", "QA", 40000),
                        new Employee(4, "Abhishek", "Manager", 90000),
                        new Employee(5, "Divya", "HR", 60000),
                        new Employee(6, "Anisha", "HR", 50000))
                .collect(Collectors.toList());

        Map<String, Employee> empMap = employees.stream().collect(groupingBy(Employee::getDepartment,
                collectingAndThen(maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));

        System.out.println(empMap);


    }
}
