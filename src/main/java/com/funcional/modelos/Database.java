package com.funcional.modelos;

import com.funcional.modelos.enums.Console;

import java.util.Collections;
import java.util.List;

public class Database {

    public static List<Videogame> videogames;

    static {
        videogames = List.of(
                Videogame.builder()
                        .name("Forza horizon 5")
                        .price(50.06)
                        .console(Console.XBOX)
                        .reviews(List.of(
                                new Review("Is the best", 5),
                                new Review("Is the best but expensive", 4),
                                new Review("Is the best x2", 5)
                        ))
                        .officialWebsite("www.forza.com")
                        .isDiscount(false)
                        .totalSold(74)
                        .build(),
                Videogame.builder()
                        .name("Residen evil 4")
                        .price(55.20)
                        .console(Console.ALL)
                        .reviews(List.of(
                                new Review("Is the best", 5),
                                new Review("Is the best x2", 4),
                                new Review("Is the best x3", 5),
                                new Review("Is the best x4", 5)
                        ))
                        .officialWebsite("www.rs4.com")
                        .isDiscount(true)
                        .totalSold(96)
                        .build(),
                Videogame.builder()
                        .name("Assassins creed origins")
                        .price(15.55)
                        .console(Console.ALL)
                        .reviews(List.of(
                                new Review("Is the best Assassins ", 5)
                        ))
                        .officialWebsite("www.origins.com")
                        .isDiscount(false)
                        .totalSold(65)
                        .build(),
                Videogame.builder()
                        .name("Assassins creed odisey")
                        .price(15.55)
                        .console(Console.ALL)
                        .reviews(List.of(
                                new Review("Is the best Assassins ", 5),
                                new Review("Is the best Assassins x2 ", 5),
                                new Review("Is the best Assassins  x3", 5)
                        ))
                        .officialWebsite("www.odisey.com")
                        .isDiscount(false)
                        .totalSold(33)
                        .build(),
                Videogame.builder()
                        .name("Assassins creed valhalla")
                        .price(30.33)
                        .console(Console.ALL)
                        .reviews(List.of(
                                new Review("Is great Assassins ", 4),
                                new Review("Is great Assassins x2 ", 3),
                                new Review("Is great Assassins  x3", 4),
                                new Review("Is great Assassins  x4", 5)
                        ))
                        .officialWebsite("www.valhalla.com")
                        .isDiscount(false)
                        .totalSold(78)
                        .build(),
                Videogame.builder()
                        .name("GTA 5")
                        .price(25.5)
                        .console(Console.ALL)
                        .reviews(List.of(
                                new Review("Is the best", 4)
                        ))
                        .officialWebsite("www.gta.com")
                        .isDiscount(true)
                        .totalSold(140)
                        .build(),
                Videogame.builder()
                        .name("Crash 4")
                        .price(50.06)
                        .console(Console.ALL)
                        .reviews(List.of(
                                new Review("Is too short", 2),
                                new Review("Is too short x2", 1)
                        ))
                        .officialWebsite("www.crash.com")
                        .isDiscount(false)
                        .totalSold(188)
                        .build(),
                Videogame.builder()
                        .name("Forza horizon 4")
                        .price(10.06)
                        .console(Console.XBOX)
                        .reviews(Collections.emptyList())
                        .officialWebsite("www.forza.com")
                        .isDiscount(false)
                        .totalSold(52)
                        .build(),
                Videogame.builder()
                        .name("The last of us")
                        .price(40.06)
                        .console(Console.PLAYSTATION)
                        .reviews(List.of(
                                new Review("Is the best", 5),
                                new Review("When launch the part 3???", 5)
                        ))
                        .officialWebsite("www.last-of-us.com")
                        .isDiscount(false)
                        .totalSold(41)
                        .build(),
                Videogame.builder()
                        .name("Good of war")
                        .price(28.00)
                        .console(Console.PLAYSTATION)
                        .reviews(List.of(
                                new Review("not very good", 3),
                                new Review("not like me", 2),
                                new Review("not very good x2", 2)
                        ))
                        .officialWebsite("www.forza.com")
                        .isDiscount(false)
                        .totalSold(79)
                        .build(),
                Videogame.builder()
                        .name("Halo")
                        .price(50.06)
                        .console(Console.XBOX)
                        .reviews(List.of(new Review("Is the best", 4)))
                        .officialWebsite("www.halo.com")
                        .isDiscount(false)
                        .totalSold(14)
                        .build(),
                Videogame.builder()
                        .name("Mario bros")
                        .price(55.99)
                        .console(Console.NINTENDO)
                        .reviews(List.of(new Review("nintendo is the best", 5)))
                        .officialWebsite("www.mario.com")
                        .isDiscount(false)
                        .totalSold(64)
                        .build(),
                Videogame.builder()
                        .name("Geometry dash pc")
                        .price(0.99)
                        .console(Console.PC)
                        .reviews(List.of(
                                new Review("some comment", 5),
                                new Review("some comment", 2),
                                new Review("some comment", 4),
                                new Review("some comment", 4))
                        )
                        .officialWebsite("www.g.com")
                        .isDiscount(false)
                        .totalSold(236)
                        .build(),
                Videogame.builder()
                        .name("Luigi mansion")
                        .price(50.06)
                        .console(Console.NINTENDO)
                        .reviews(Collections.emptyList())
                        .officialWebsite("www.mario.com")
                        .isDiscount(false)
                        .totalSold(49)
                        .build(),
                Videogame.builder()
                        .name("Mario party")
                        .price(22.00)
                        .console(Console.NINTENDO)
                        .reviews(List.of(new Review("Too boring", 1)))
                        .officialWebsite("www.mario.com")
                        .isDiscount(false)
                        .totalSold(4)
                        .build(),
                Videogame.builder()
                        .name("COD black ops")
                        .price(18.60)
                        .console(Console.PLAYSTATION)
                        .reviews(List.of(new Review("5 Stars", 5), new Review("5 Stars", 5)))
                        .officialWebsite("www.cod.com")
                        .isDiscount(false)
                        .totalSold(900)
                        .build(),
                Videogame.builder()
                        .name("COD black mobile")
                        .price(0.0)
                        .console(Console.MOBILE)
                        .reviews(List.of(new Review("4 Stars", 4)))
                        .officialWebsite("www.cod.com")
                        .isDiscount(false)
                        .totalSold(1200)
                        .build(),
                Videogame.builder()
                        .name("Geometry dash")
                        .price(1.0)
                        .console(Console.MOBILE)
                        .reviews(List.of(
                                new Review("amazing", 5),
                                new Review("funny", 4),
                                new Review("ok", 5),
                                new Review("amazing2", 5),
                                new Review("funny2", 4),
                                new Review("ok2", 5)))
                        .officialWebsite("www.geometry.com")
                        .isDiscount(true)
                        .totalSold(2000)
                        .build(),
                Videogame.builder()
                        .name("Candy crush")
                        .price(0.0)
                        .console(Console.MOBILE)
                        .reviews(List.of(
                                new Review("", 5),
                                new Review("", 3),
                                new Review("", 3),
                                new Review("", 3),
                                new Review("", 3),
                                new Review("", 2)))
                        .officialWebsite("www.candy-crush.com")
                        .isDiscount(false)
                        .totalSold(2200)
                        .build(),
                Videogame.builder()
                        .name("Forza horizon 5")
                        .price(50.06)
                        .console(Console.XBOX)
                        .reviews(List.of(
                                new Review("Is the best", 5),
                                new Review("Is the best but expensive", 4),
                                new Review("Is the best x2", 5)
                        ))
                        .officialWebsite("www.forza.com")
                        .isDiscount(false)
                        .totalSold(74)
                        .build()
        );
    }
}
