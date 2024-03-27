package com.javatechie.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class PrintEvenOddWriter {

    public static void main(String[] args) {

        ExecutorService executorServiceOdd = Executors.newFixedThreadPool(1);
        ExecutorService executorServiceEven = Executors.newFixedThreadPool(1);

//        CompletableFuture<Void> completableOdd = CompletableFuture.runAsync(() -> printOddNumber(), executorServiceOdd);
//        CompletableFuture<Void> completableEven = CompletableFuture.runAsync(() -> printEvenNumber(), executorServiceEven);
//
//        CompletableFuture<Void> finalResult = CompletableFuture.allOf(completableEven, completableOdd);
//        finalResult.join();

        CompletableFuture.runAsync(() -> printOddNumber(), executorServiceOdd)
                .thenRunAsync(() -> printEvenNumber(), executorServiceEven)
                .join();
    }

    private static void printOddNumber() {
        IntStream.rangeClosed(1, 10)
                .forEach(element -> {
                    if (element % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + " " + element);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
    }

    /**
     * prints the even number
     */
    private static void printEvenNumber() {

        IntStream.rangeClosed(1, 10)
                .forEach(element -> {
                    if (element % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + " " + element);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });


    }
}
