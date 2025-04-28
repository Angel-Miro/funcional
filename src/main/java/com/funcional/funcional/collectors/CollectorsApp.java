package com.funcional.funcional.collectors;

import com.funcional.modelos.Database;
import com.funcional.modelos.Videogame;
import com.funcional.modelos.enums.Console;

import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CollectorsApp {

    public static void main(String[] args) {
        Stream<Videogame> videogameStream = Database.videogames.stream();
        //System.out.println(generateListOrMap(videogameStream, "Set").getClass().getName());
        //System.out.println(generateMap(videogameStream));
        //partition(videogameStream).forEach((k, v) -> System.out.println(k + " - " + v));
        //grupingBy(videogameStream).forEach((k, v) -> System.out.println(k + " - " + v));
        groupingByAndSum(videogameStream).forEach((k, v) -> System.out.println(k + " - " + v.getSum()));
    }

    static Collection<Videogame> generateListOrMap(Stream<Videogame> stream, String type){
        /***
         * Creando un List o Set sea el caso
         */
        return (type.equals("List")) ? stream.collect(Collectors.toList()) : stream.collect(Collectors.toSet());
    }

    static Map<String, Double> generateMap(Stream<Videogame> stream){
        /**
         * Se puede generar un mapa a traves de un stream
         * */
        return stream.distinct().collect(Collectors.toMap(Videogame::getName, Videogame::getPrice));
    }

    static Map<Boolean, List<Videogame>> partition(Stream<Videogame> stream){
        /***
         *Se puede generar un mapa a partir de cierto criterio
         */
        return stream.collect(Collectors.partitioningBy(v -> v.getPrice() > 15.0));
    }

    static Map<Console, List<Videogame>> grupingBy(Stream<Videogame> stream){
        /**
         * Se puede emular el gruping by de una bd
         * */
        return stream.collect(Collectors.groupingBy(Videogame::getConsole));
    }

    static Map<Console, IntSummaryStatistics> groupingByAndSum(Stream<Videogame> stream){
        /**
         * Se puede emuilar el grouping by y un having count con el stream
         * */
        return stream.collect(Collectors.groupingBy(Videogame::getConsole, Collectors.summarizingInt(Videogame::getTotalSold)));
    }
}
