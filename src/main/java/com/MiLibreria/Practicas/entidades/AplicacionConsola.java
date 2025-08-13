package com.MiLibreria.Practicas.entidades;

import com.MiLibreria.Practicas.apis.Gutendex;
import com.MiLibreria.Practicas.apis.JsonParser;
import com.MiLibreria.Practicas.service.AutorService;
import com.MiLibreria.Practicas.service.LibroService;
import com.MiLibreria.Practicas.vistas.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AplicacionConsola {
    private final Gutendex gutendex;
    private final Menu menu;
    private final LibroService libroService;
    private final AutorService autorService;

    @Autowired
    public AplicacionConsola(Gutendex gutendex, Menu menu, LibroService libroService, AutorService autorService){
        this.gutendex = gutendex;
        this.menu = menu;
        this.libroService = libroService;
        this.autorService = autorService;
    }

    public void ejecutar(){
        Boolean continuar = true;
        while (continuar){
            menu.imprimirOpciones();
            int eleccion = menu.capturaEleccion(1,7);

            switch (eleccion){
                case 1:
                    System.out.print(" Ingrese el titulo del libro que buscas:   ");
                    String titulo = menu.capturaTexto();
                    try {
                        var respuesta = gutendex.buscarTitulo(titulo);
                        System.out.println("Los libros encontrados: ");
                        List<Libro> libros = procesarRespuesta(respuesta);
                        libros.forEach(System.out::println);

                        libroService.guardarLibrosDesdeJson(respuesta);

                        menu.presioneParaContinual();
                    } catch (Exception e) {
                        System.out.println("Error al realizar la conexion con la API Gutendex " + e.getMessage());
                    }
                    break;
                case 2:
                    List<Libro> biblioteca = libroService.consultarTodosLosLibrosConAutores();
                    System.out.println("***** Libros disponibles en la base de datos");
                    biblioteca.forEach(libro -> System.out.println(libro.toString()));
                    menu.presioneParaContinual();
                    break;
                case 3:
                    menu.imprimirIdiomas();
                    int idiomaElegido = menu.capturaEleccion(1,2);
                    List<Libro> libros = new ArrayList<>();
                    String idioma = "";
                    switch (idiomaElegido){
                        case 1:
                            idioma = "español";
                            libros = libroService.consultarLibrosPorIdioma("es");
                            break;
                        case 2:
                            idioma = "ingles";
                            libros = libroService.consultarLibrosPorIdioma("en");
                            break;
                    }
                    System.out.println(" ************ LOS LIBROS EXISTENTES EN " + idioma + " SON:");
                    libros.forEach(libro -> System.out.println("Titulo: " + libro.getTítulo()));
                    menu.presioneParaContinual();
                    break;
                case 4:
                    List<Autor> autores = autorService.consultaAutores();
                    System.out.println(" ************ Autores Existentes ");
                    autores.forEach(autor -> System.out.println(autor.toString()));
                    menu.presioneParaContinual();
                    break;
                case 5:
                    System.out.println("Ingrese el año en el que desea buscar un autor vivo");
                    Integer año = menu.capturaEleccion(1100,2100);
                    List<Autor> autoresVivos = autorService.consultarAutoresVivosEnAño(año);
                    System.out.println("************* Autores Vivos para el " + año);
                    autoresVivos.forEach(autor -> System.out.println(autor.toString()));
                    menu.presioneParaContinual();
                    break;
                case 6:
                    menu.imprimirIdiomas();
                    int idiomaSeleccionado = menu.capturaEleccion(1,2);
                    String idiomaElejido = "";
                    int cantidadLibro = 0;
                    List<Libro> lista = new ArrayList<>();
                    switch (idiomaSeleccionado){
                        case 1:
                            idiomaElejido = "español";
                            lista = libroService.consultarLibrosPorIdioma("es");
                            break;
                        case 2:
                            idiomaElejido= "ingles";
                            lista = libroService.consultarLibrosPorIdioma("en");
                            break;
                    }
                    System.out.println(" ************ LOS LIBROS EXISTENTES EN " + idiomaSeleccionado + " SON:" + lista.size());
                    menu.presioneParaContinual();
                    break;
                case 7:
                    continuar = false;
                    System.out.println("Gracias por usar nuestro software...");
                    break;
            }
        }
    }
    public static List<Libro> procesarRespuesta(String json) throws Exception {
        RespuestaAPI resp = JsonParser.parsearRespuesta(json);
        return resp.getLibros();
    }
}
