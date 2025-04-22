package com.funcional.funcional.bifunction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.function.BiFunction;

public class BiFunctionApp {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Auto {
        private String modelo;
        private String marca;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Ensambladora{
        private String nombre;
        private String tipoEnsablado;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Sucursal{
         Auto auto;
         Ensambladora ensabladora;
    }

    public static void main(String[] args) {
        BiFunction bi = (e,u) -> { return new Sucursal((Auto)e, (Ensambladora) u); };
        Auto auto  = new Auto("SEAT", "LEON CUPRA");
        Ensambladora ensambladora = new Ensambladora("CABORCA", "AUTOS");
        Sucursal sucursal = (Sucursal)bi.apply(auto,ensambladora);
        System.out.println(sucursal);

    }

}
