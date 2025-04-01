package com.funcional.funcional.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

//void accept(T t)
public class ConsumerApp {

    public static void ej(){
        Consumer<String> c = System.out::println;
        c.accept("Hello World d-_-b");
    }

    public static void multiplicacion (){
        List<Integer> arreglo = Arrays.asList(1, 2, 3, 4, 5);
        Consumer< List<Integer>> c = d -> d.forEach(num -> System.out.println(num + " * " + "2 : "  + multiplica(num, 2)));
        c.accept(arreglo);
    }

    public static int multiplica (int a, int b){
        return a*b;
    }

    public static void main(String[] args) {
        ej();
        multiplicacion();

    }
}
