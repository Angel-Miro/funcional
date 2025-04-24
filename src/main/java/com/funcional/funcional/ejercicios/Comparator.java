package com.funcional.funcional.ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Comparator {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(11, 3, 7, 44, 15, 9, 6, 8, 5, 1);
        List<String> names = Arrays.asList("Cochiloco", "Calamardo", "Angel", "Patiño");


        lista.sort((a,b) -> a-b);
        names.sort(String::compareTo);

        System.out.println(lista);
        System.out.println(names);
    }
}
