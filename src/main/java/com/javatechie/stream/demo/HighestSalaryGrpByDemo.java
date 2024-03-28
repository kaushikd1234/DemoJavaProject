package com.javatechie.stream.demo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class HighestSalaryGrpByDemo {

    public static void main(String[] args) {

        List<Employee> employeesList = Stream.of(
                        new Employee(1, "kaushik", "DEV", 40000),
                        new Employee(2, "Preeti", "DEV", 60000),
                        new Employee(3, "Himanshu", "QA", 45000),
                        new Employee(4, "Arunima", "QA", 40000),
                        new Employee(5, "Divya", "HR", 50000),
                        new Employee(5, "Ankesh", "HR", 56000))
                .collect(Collectors.toList());

        System.out.println("orig emp list " + employeesList);

        Map<String, Employee> map = employeesList.stream().collect(groupingBy(Employee::getDepartment,
                collectingAndThen(maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));

        System.out.println("map is after grouping " + map);


    }
}
