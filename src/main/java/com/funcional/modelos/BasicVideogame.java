package com.funcional.modelos;

import com.funcional.modelos.enums.Console;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasicVideogame {
    private String name;
    private Double price;
    private Console console;
}
