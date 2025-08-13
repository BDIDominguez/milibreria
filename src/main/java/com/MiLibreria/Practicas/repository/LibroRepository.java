package com.MiLibreria.Practicas.repository;

import com.MiLibreria.Practicas.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    @Query("SELECT l FROM Libro l LEFT JOIN FETCH l.autor")
    List<Libro> findAllWithAutores();
    List<Libro> findByIdiomasContaining(String idioma);
}
