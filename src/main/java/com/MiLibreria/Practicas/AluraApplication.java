package com.MiLibreria.Practicas;

import com.MiLibreria.Practicas.apis.Gutendex;
import com.MiLibreria.Practicas.apis.JsonParser;
import com.MiLibreria.Practicas.entidades.Libro;
import com.MiLibreria.Practicas.entidades.RespuestaAPI;
import com.MiLibreria.Practicas.vistas.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AluraApplication {

	public static void main(String[] args) {
		SpringApplication.run(AluraApplication.class, args);
		Gutendex gutendex = new Gutendex();
		Boolean continuar = true;
		while (continuar){
			Menu menu = new Menu();
			menu.imprimirOpciones();
			int eleccion = menu.capturaEleccion();
			switch (eleccion) {
				case 1:
					System.out.print(" Ingrese el titulo del libro que buscas:   ");
					String titulo = menu.capturaTexto();
                    try {
                        var respuesta = gutendex.buscarTitulo(titulo);
						System.out.println("los libros encdontrados: ");
						List<Libro> libros = procesarRespuesta(respuesta);
						libros.stream().forEach(libro -> System.out.println(libro.toString()));
						menu.presioneParaContinual();
                    } catch (Exception e) {
						System.out.println("Error al realizar la conexion con la API Gutendex " + e.getMessage());
						//throw new RuntimeException(e);
                    }
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
