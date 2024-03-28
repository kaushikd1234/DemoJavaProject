package com.javatechie.stream.demo;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class TempDemoMain {

    public static void main(String[] args) {

        String inputString = "Preetiijaaaannnnnnnsahu";

        List<String> listWithDuplicates = Arrays.stream(inputString.split(""))
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet()
                .stream().filter(element -> element.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("list with duplicates " + listWithDuplicates);

        List<String> listWithUniqueElements = Arrays.stream(inputString.split(""))
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet()
                .stream().filter(element -> element.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(listWithUniqueElements);

        String nonRepeatableElement = Arrays.stream(inputString.split(""))
                .collect(groupingBy(Function.identity(), LinkedHashMap::new, counting()))
                .entrySet()
                .stream().filter(element -> element.getValue() == 1)
                .findFirst()
                .get().getKey();

        System.out.println("first non repeat element is " + nonRepeatableElement);

    }
}
