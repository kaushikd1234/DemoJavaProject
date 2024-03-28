package com.javatechie.sort.demo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortingDemoMain {

    public static void main(String[] args) {

        List<Person> personsList = Stream.of(new Person(1, "kaushik"),
                        new Person(8, "Rakesh"),
                        new Person(3, "Pankaj"),
                        new Person(4, "Rakesh"))
                .collect(Collectors.toList());

        List<Person> sortedList = personsList.stream().sorted(Comparator.comparingInt(Person::getId).reversed()
                        .thenComparing(Person::getName))
                .collect(Collectors.toList());

        System.out.println(sortedList);

    }
}
