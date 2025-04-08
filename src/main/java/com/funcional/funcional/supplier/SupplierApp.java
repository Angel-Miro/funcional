package com.funcional.funcional.supplier;

import java.time.LocalDate;
import java.util.function.Supplier;

// T get();
public class SupplierApp {

    // Se define un objeto en el suppier que es que tiene que regresar
    public static LocalDate ej(){
        Supplier<LocalDate> supplier = () -> LocalDate.now();
        return supplier.get();
    }

    public static void main(String[] args) {
        System.out.println("La fecha es: " + ej());
    }
}
