package com.MiLibreria.Practicas.repository;

import com.MiLibreria.Practicas.entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByNacidoLessThanEqualAndFallecimientoIsNullOrFallecimientoGreaterThan(Integer año, Integer año1);

    List<Autor> findByFallecimientoIsNull();

    Optional<Autor> findByNombre(String nombre);
}
