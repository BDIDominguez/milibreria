package com.MiLibreria.Practicas.service;

import com.MiLibreria.Practicas.entidades.Autor;
import com.MiLibreria.Practicas.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> consultarAutoresVivosEnAño(Integer año){
        return autorRepository.findByNacidoLessThanEqualAndFallecimientoIsNullOrFallecimientoGreaterThan(año, año);
    }

    public List<Autor> consultarAutoresVivos(){
        return autorRepository.findByFallecimientoIsNull();
    }

    public List<Autor> consultaAutores() {
        return autorRepository.findAll();
    }
}
