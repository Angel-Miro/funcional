package com.funcional.funcional.stream;

import com.funcional.modelos.Album;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public class StreamApp {

    public static void main (String[] args) {
        streamFilter(createListAlbum(), "rock");
        log.warn("#####################################################");
        streamInverse(createListAlbum());
    }

    public static void streamFilter(List<Album> albums, String genero) {
        Predicate<Album> fx = album -> album.getGenero().equalsIgnoreCase(genero);
        //List<Album> albumsFiltered = albums.stream().filter(fx).toList();//jdk 16 toList()
        List<Album> filteredAlbums = albums.stream().filter(fx).collect(Collectors.toList()); //jdk 1.8
        filteredAlbums.forEach(System.out::println);

    }

    public static void streamInverse(List<Album> albums) {
        albums.stream().sorted(Comparator.comparing(Album::getAnio)).forEach(System.out::println);
    }

    private static List<Album> createListAlbum() {
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
