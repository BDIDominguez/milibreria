package com.MiLibreria.Practicas.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Libro {
    @Id
    @JsonProperty("id")
    private long id;
    @Column(nullable = false, length = 200)
    @JsonProperty("title")
    private String título;
    @Column(length = 100)
    @JsonProperty("languages")
    private List<String> idiomas;
    @Column(name = "descargas")
    @JsonProperty("download_count")
    private int nroDescargas;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    @JsonProperty("authors")
    private List<Autor> autores;

    @PrePersist
    @PreUpdate
    private void convertirIdiomas(){
        if (this.idiomasList != null){
            this.idiomas = String.join(",", this.idiomasList);
        }
    }

    @Transient
    @JsonProperty("languages")
    private List<String> idiomasList;

    // Método para obtener idiomas como List
    public List<String> getIdiomasList() {
        if(this.idiomas != null) {
            return List.of(this.idiomas.split(","));
        }
        return null;
    }


    // Método para obtener idiomas como String concatenado
    public String getIdiomasAsString() {
        return String.join(", ", idiomas);
    }

    // Método para obtener el primer autor (o null)
    public Autor getPrimerAutor() {
        return autores != null && !autores.isEmpty() ? autores.get(0) : null;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", título='" + título + '\'' +
                ", idiomas=" + idiomas +
                ", nroDescargas=" + nroDescargas +
                ", autores=" + autores;
        /*
        return "Libro{" +
                "id=" + id +
                ", título='" + título + '\'' +
                ", idiomas=" + idiomas +
                ", nroDescargas=" + nroDescargas +
                ", autores=" + autores +
                '}';
         */
    }
}
