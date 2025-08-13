package com.MiLibreria.Practicas.entidades;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "libros")
@Getter
@Setter // Genera getters y setters
@NoArgsConstructor // Constructor vacío (requerido por JPA)
@AllArgsConstructor // Constructor con todos los campos
@ToString // Genera toString()
@JsonIgnoreProperties(ignoreUnknown = true)
public class Libro {
    @Id
    @JsonProperty("id")
    private Long id;  // Usamos el ID de la API como PK

    @Column(nullable = false, length = 200)
    @JsonProperty("title")
    private String título;

    // Para manejar la lista de idiomas como texto en la BD
    @Column(length = 100)
    private String idiomas;

    @Column(name = "descargas")
    @JsonProperty("download_count")
    private int nroDescargas;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @Transient
    @JsonProperty("authors")
    private List<Autor> authorsFromJson;

    @JsonSetter("authors")
    public void setAuthorsFromJson(List<Autor> authors){
        this.authorsFromJson = authors;
        if (authors != null && !authors.isEmpty()){
            this.autor = authors.get(0);
        }
    }

    @Transient
    @JsonProperty("languages")
    private List<String> languagesFromJson;

    @JsonSetter("languages")
    public void setLanguagesFromJson(List<String> languages){
        this.languagesFromJson = languages;
        if (languages != null && !languages.isEmpty()){
            this.idiomas = String.join(",", languages);
        }
    }

    public List<String> getIdiomasComoLista(){
        if (this.idiomas != null && !this.idiomas.isEmpty()){
            return Arrays.asList(this.idiomas.split(","));
        }
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", título='" + título + '\'' +
                ", idiomas=" + getIdiomasComoLista() +
                ", nroDescargas=" + nroDescargas +
                ", autores=" + autor;
    }
}