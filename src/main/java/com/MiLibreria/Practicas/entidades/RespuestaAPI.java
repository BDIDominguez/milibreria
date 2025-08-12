package com.MiLibreria.Practicas.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RespuestaAPI {
    @JsonProperty("count")
    private int totalesResultados;
    @JsonProperty("results")
    private List<Libro> libros;

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
