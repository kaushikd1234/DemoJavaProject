package com.javatechie.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ThreadDemo {

    // Declare a ThreadLocal variable
    private static ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> (int) (Math.random() * 100));

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        IntStream.rangeClosed(1, 5)
                .forEach(element -> executor.submit(() -> {
                    System.out.println(Thread.currentThread().getName() + "  : " + threadLocalValue.get());

                }));
        // Shutdown the executor
        executor.shutdown();
    }
}
