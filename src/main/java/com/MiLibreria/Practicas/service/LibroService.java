package com.MiLibreria.Practicas.service;

import com.MiLibreria.Practicas.apis.JsonParser;
import com.MiLibreria.Practicas.entidades.Autor;
import com.MiLibreria.Practicas.entidades.Libro;
import com.MiLibreria.Practicas.entidades.RespuestaAPI;
import com.MiLibreria.Practicas.repository.AutorRepository;
import com.MiLibreria.Practicas.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;

    public LibroService(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }


    public void guardarLibrosDesdeJson(String json) throws Exception{
        RespuestaAPI respuesta = JsonParser.parsearRespuesta(json);

        for (Libro libro : respuesta.getLibros()){
            if (libro.getAutor() != null){
                String nombre = libro.getAutor().getNombre();
                Optional<Autor> autorExistente = autorRepository.findByNombre(nombre);
                if (autorExistente.isPresent()){
                    libro.setAutor(autorExistente.get());
                } else {
                    autorRepository.save(libro.getAutor());
                }
            }
            libroRepository.save(libro);
        }
    }

    public List<Libro> consultarTodosLosLibros(){
        return libroRepository.findAll();
    }

    public List<Libro> consultarTodosLosLibrosConAutores(){
        return libroRepository.findAllWithAutores();
    }

    public List<Libro> consultarLibrosPorIdioma(String idioma){
        return libroRepository.findByIdiomasContaining(idioma);
    }


}
