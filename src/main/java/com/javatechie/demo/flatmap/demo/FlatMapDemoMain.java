package com.javatechie.demo.flatmap.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapDemoMain {

    public static void main(String[] args) {

        int[][] twoDimensionalArray = {{1, 2, 3},
                {5, 6, 8},
                {9, 10, 11}};

        // convert that to array of integers

        List<int[]> listOfIntegers = Arrays.asList(twoDimensionalArray);
        List<String> integersList = listOfIntegers.stream().flatMap(element -> Arrays.stream(element).mapToObj(Integer::toString))
                .collect(Collectors.toList());

        System.out.println(integersList);

        // convert the list oflist of Integers to List of Integers using flat Map

        List<Integer> flattenedList = Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(4, 5),
                        Arrays.asList(6, 7, 8)).stream().flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println("flattened List is " + flattenedList);


    }
}
