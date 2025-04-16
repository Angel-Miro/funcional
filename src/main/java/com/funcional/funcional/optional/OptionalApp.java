package com.funcional.funcional.optional;

import com.funcional.modelos.Album;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class OptionalApp {
    public static void main(String[] args){
        Optional<Album> album = Optional.of(new Album("Espiritu del vino",
                "Heroes del Silencio", 1990,"Rock"));
        Optional<Album> albumEmpty = Optional.empty();

        System.out.println(album.isPresent());
        System.out.println(album.isEmpty());
        albumEmpty.ifPresent(a -> System.out.println(a.getNombre()));

        log.info("#####################################################################");
        log.info("#####################################################################");

        System.out.println(albumEmpty.orElse(new Album()));
        System.out.println(albumEmpty.orElseGet(Album::new));
        albumEmpty.orElseThrow(RuntimeException::new);
    }
}
