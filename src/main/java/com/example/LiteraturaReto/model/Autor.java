package com.example.LiteraturaReto.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Autor(@JsonAlias("name") String nombre,
                    @JsonAlias("birth_year") int fechaCumpleaños,
                    @JsonAlias("death_year") int fechaMuerte) {
}
