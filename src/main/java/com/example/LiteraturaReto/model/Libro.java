package com.example.LiteraturaReto.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Libro(@JsonAlias("id") int idLibro,
                    @JsonAlias("title") String titulo,
                    @JsonAlias("authors") List<Autor> autors) {
}
