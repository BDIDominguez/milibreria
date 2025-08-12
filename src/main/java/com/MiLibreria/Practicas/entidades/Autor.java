package com.MiLibreria.Practicas.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "autores")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 100)
    @JsonProperty("name")
    private String nombre;
    @Column(name = "anio_nacimiento")
    @JsonProperty("birth_year")
    private Integer nacido;
    @Column(name = "anio_fallecimiento")
    @JsonProperty("death_year")
    private Integer fallecimiento;

    @Override
    public String toString() {
        return nombre + '\'' +
                "(" + nacido +
                "-" + fallecimiento + ")";
    }
}
