package com.funcional.funcional.ejercicios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFile {
    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources/lectura.txt");

        try(Stream<String> lines = Files.lines(path).onClose(() -> System.out.println(":::::File readed:::::"))) {
            lines.forEach(System.out::println);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
