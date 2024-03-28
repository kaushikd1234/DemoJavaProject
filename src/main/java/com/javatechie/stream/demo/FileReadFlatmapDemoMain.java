package com.javatechie.stream.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileReadFlatmapDemoMain {

    public static void main(String[] args) {

        String fileName = "C:/kd/myfile.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            reader.lines().flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .forEach(System.out::println);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
