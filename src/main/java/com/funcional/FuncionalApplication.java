package com.funcional;

import com.funcional.interfaces.Suma;
import com.funcional.interfaces.impl.SumaImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FuncionalApplication {

    public static void main(String[] args) {
        //Suma sum = new SumaImpl();
        Suma sum = (a,b) -> a+b; // Esto es posible gracias a que se define con @FunctionalInterface
        System.out.printf("Suma suma: %d%n", sum.suma(10, 20));

        SpringApplication.run(FuncionalApplication.class, args);
    }

}
