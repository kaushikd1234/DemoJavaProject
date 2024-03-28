package com.javatechie.stream.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class FileReadFlatmapDemoMain {

    public static void main(String[] args) {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("C:/file/sample.txt"));

            reader.lines().flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .forEach(System.out::println);

        } catch (Exception exception) {
            exception.printStackTrace();

        }

    }
}
