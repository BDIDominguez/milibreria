package com.MiLibreria.Practicas.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "autores")
@Getter
@Setter // Genera getters y setters
@NoArgsConstructor // Constructor vacío (requerido por JPA)
@AllArgsConstructor // Constructor con todos los campos
@ToString // Genera toString()
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

    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;

    @Override
    public String toString() {
        return nombre + '\'' +
                "(" + nacido +
                "-" + fallecimiento + ")";
    }
}
