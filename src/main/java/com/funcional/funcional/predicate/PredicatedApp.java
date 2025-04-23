package com.funcional.funcional.predicate;

import com.funcional.modelos.Album;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


//boolean test(T t)
public class PredicatedApp {

    //Definicion del predicado
    public static boolean ej(){

        Predicate<Integer> x =  e -> e >= 18;
        return x.test(19);
    }

    //El objeto que se defina en el predicado, manda a llamar todos los metodos de esa clase
    public static boolean ejString(){
        Predicate<String> e = s -> s.equals("igual");
        return e.test("igual");
    }

    //Operar dos predicados al mismo tiempo
    public static boolean ejInteraccionPredicados(){
        Predicate<Integer> mayor =  e -> e >= 10;
        Predicate<Integer> menor =  e -> e <= 40;

        return mayor.and(menor).test(16);
    }

    public static boolean ejPredicadoObjetos(Album album, Predicate<Album> predicate){
        Predicate<Album> fx = a -> a.getAnio() >= 2000 ;
        return predicate.and(fx).test(album);
    }

    public static void ejPredicadoRemoveIf(){
        List<Integer> lista = new ArrayList(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        lista.removeIf(x -> x % 2 == 0);
        lista.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Album album = new Album("El espiritu del vino", "Heroes del Silencio", 1980, "Rock");
        Predicate<Album> genero=  a -> a.getGenero().equals("Rock");


        System.out.println("El usuario es mayor de edad ? " + ej());
        System.out.println("La palabra es igual? " + ejString());
        System.out.println("El numero es mayor que 10 y menor que 40? " + ejInteraccionPredicados());
        System.out.println("El album cumple con las caracteristicas ? " + ejPredicadoObjetos(album, genero));
        System.out.println("El album cumple con las caracteristicas ? " + ejPredicadoObjetos(album, a -> a.getGenero().equals("Rock")));
        ejPredicadoRemoveIf();
    }
}
