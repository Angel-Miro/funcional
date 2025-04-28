package com.funcional.funcional.parallel;

import java.util.Arrays;
import java.util.List;

public class ParallelApp {

    // -D java.util.cuncurrent.ForkJoinPool.common.parallelism=5
    //Se indica el numero maximo de hilos
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.parallelStream().forEach(n -> System.out.println(n + " - " + Thread.currentThread().getName()));

    }
}
