package com.funcional.funcional.stream;

import com.funcional.modelos.Album;
import com.funcional.modelos.Database;
import com.funcional.modelos.Review;
import com.funcional.modelos.Videogame;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Slf4j
public class StreamApp {

    public static void main (String[] args) {
        List<Album> albums = createListAlbum();


        streamConstructor();
        log.warn("#####################################################");
        streamFilter(albums, "rock");
        log.warn("#####################################################");
        streamInverse(albums);
        log.warn("#####################################################");
        streamMaxMin(albums);
        log.warn("#####################################################");
        streamSummary(albums);
        log.warn("#####################################################");
        streamAnyMatch(albums);
        log.warn("#####################################################");
        streamNoneMatch(albums);
        log.warn("#####################################################");
        streamAllMatch(albums);
        log.warn("#####################################################");
        streamFindFisrt(albums);
        log.warn("#####################################################");
        streamReduce();
        log.warn("#####################################################");
        streamMap(albums);
        log.warn("#####################################################");
        streamFlatMap(albums);
        log.warn("#####################################################");
        streamPeek();
        log.warn("#####################################################");
        streamSort();
        log.warn("#####################################################");
        streamGroupBy(albums);
    }

    public static void streamConstructor(){
        /**
         * Se genera el stream
         * */
        Stream<Videogame> stream = Database.videogames.stream();
        stream.forEach(System.out::println);
    }

    //Intermedio
    public static void streamFilter(List<Album> albums, String genero) {
        /**
         * El metodo filter recibe un Predicado
         */
        Predicate<Album> fx = album -> album.getGenero().equalsIgnoreCase(genero);
        List<Album> filteredAlbums = albums.stream().filter(fx).toList();//jdk 16 toList()
        //List<Album> filteredAlbums = albums.stream().filter(fx).collect(Collectors.toList()); //jdk 1.8
        filteredAlbums.forEach(System.out::println);

    }

    public static void streamInverse(List<Album> albums) {
        /***
         * El metodo sorter recibe un Comparator
         * Comparator es una function, recordemos que una function
         * recbe un objeto y regresa otro , o puede ser el mismo, en este
         * caso recibe un Album y regresa el anio
         */

        albums.stream().sorted(Comparator.comparing(Album::getAnio).reversed()).forEach(System.out::println);
    }

    public static void streamSort(){
        var list = Database.videogames.stream().sorted(Comparator.comparing(v -> v.getReviews().size())).collect(Collectors.toList());
        log.info("El valor de list ordenada es : {}", list);
    }

    //final
    public static void streamMaxMin(List<Album> albums) {
        int maxYear = albums.stream().map(Album::getAnio).max(Integer::compareTo).get();
        int minYear = albums.stream().map(Album::getAnio).min(Integer::compareTo).get();
        OptionalDouble avgYear = albums.stream().mapToInt(Album::getAnio).average();

        log.info("Max year: {}", maxYear);
        log.info("Min year: {}", minYear);
        log.info("Average year: {}", avgYear.getAsDouble());
    }

    public static void streamSummary(List<Album> albums) {
        /***
         *   El objeto IntsummaryStatistics regresa el min, max y el promedio
         */
        var summary = albums.stream().mapToInt(Album::getAnio).summaryStatistics();
        log.info("Summary: {}", summary);
    }

    //final
    public static void streamAnyMatch(List<Album> albums) {
        /**
         * Con anyMatch se verifica que aunque sea un elemento cumpla con el predicado
         */
        var bool= albums.stream().anyMatch(a -> a.getAnio() == 2007);
        log.info("anyMatch value is : {} ", bool);
    }

    //final
    public static void streamAllMatch(List<Album> albums) {
        /**
         * Con allMatch se verifica que todos los elementos cumplan con el predicado
         */
        var bool= albums.stream().allMatch(a -> a.getAnio() == 1980);
        log.info("allMatch value is : {} ", bool);
    }

    //final
    public static void streamNoneMatch(List<Album> albums) {
        var bool= albums.stream().noneMatch(a -> a.getAnio() == 2015);
        log.info("noneMatch value is : {} ", bool);
    }

    //intermedio
    public static void streamMap(List<Album> albums) {
        /***
         * Map es de los mas usados, map recibe un objeto y regresa otro objeto
         * ya que recibe una function
         */
        albums.stream().map(s -> {
            s.setAnio(s.getAnio() + 1);
            return s;
        }).forEach(System.out::println);

    }

    //intermedio
    public static void streamFlatMap(List<Album> albums) {
        /***
         * flatMap es para trabajar listas de listas, o stream embebido de streams
         */
        albums.stream().flatMap(a -> {
            a.setAnio(a.getAnio() + 1);
            return Stream.of(a.getBanda(), a.getAnio());
        }).forEach(e -> {
            System.out.println("La banda es: " + ((Serializable) e).toString());
        });


        var reviews = Database.videogames.stream().flatMap(v -> v.getReviews().stream()).toList();
        log.info("La lista de reviews usando flatMap: {}", reviews);

        var totalReviews = Database.videogames.stream().flatMap(v -> v.getReviews().stream()).count();
        log.info("El total de reviews es: {}", totalReviews);
    }

    public static void streamGroupBy(List<Album> albums) {
        /***
         * Al igual que las BD el groupingBy agrupa bajo un criterio
         * el retorno de esta funcion es un mapa siendo Map<Filtro(Object), ObjectoAgrupado>, se pueden ir
         * agurpado por varios filtros , solo que la estructura de retorno se va aninando Map<Filtro, Map<Filtro, Objeto>>
         */
        Map<String, List<Album>> map = albums.stream().collect(Collectors.groupingBy(Album::getGenero));
        Map<String, Map<String,List<Album>>> map2 = albums.stream().collect(Collectors.groupingBy(Album::getGenero, Collectors.groupingBy(Album::getBanda)));
        System.out.println(map);
        System.out.println(map2);

    }

    public static void streamFindFisrt(List<Album> albums) {
        Optional<Album> album = albums.stream().findFirst();
        log.info("findFirst Method result : {}", album);
        album.ifPresent(System.out::println);
    }

    public static void streamReduce() {
        List<Videogame> videogames = Database.videogames.stream().collect(Collectors.toList());
        Optional<Integer> ventas = videogames.stream()
                                             .filter(Videogame::getIsDiscount)
                                             .map(Videogame::getTotalSold)
                                             .reduce(Integer::sum);
        log.info("Total sold values using .reduce() : {}", ventas);
    }

    public static void streamPeek(){
        List<Videogame> videogames = Database.videogames.stream().collect(Collectors.toList());
        videogames.stream().peek(v -> v.setName("")).forEach(System.out::println);
    }
    private  static List<Album> createListAlbum() {
        Album album = new Album("THRILLER", "MICHAEL JACKSON", 1982 ,"POP");
        Album album2 = new Album("BACK IN BLACK", "AC/DC", 1980 ,"ROCK");
        Album album3 = new Album("THE DARK SIDE OF THE MOON", "PINK FLOYD", 1973 ,"ROCK");
        Album album4 = new Album("THEIR GREATEST HITS", "EAGLES", 1976 ,"ROCK");
        Album album5 = new Album("ABBEY ROAD", "THE BEATLES", 1982 ,"POP");
        Album album6 = new Album("SENDEROS DE TRAICION", "HEROES DEL SILENCIO", 1990 ,"ROCK");
        Album album7 = new Album("TOUR 2007", "HEROES DEL SILENCIO", 2007 ,"ROCK");
        Album album8 = new Album("SODA STEREO", "SODA STEREO", 1984 ,"ROCK");
        Album album9 = new Album("EL ULTIMO CONCIERTO", "SODA STEREO", 1997 ,"ROCK");
        Album album10 = new Album("CAIFANES", "CAIFANES", 1988 ,"ROCK");
        Album album11 = new Album("EL SILENCIO", "CAIFANES", 1992 ,"ROCK");

        return Arrays.asList(album, album2, album3, album4, album5, album6, album7, album8, album9, album10, album11);
    }
}
