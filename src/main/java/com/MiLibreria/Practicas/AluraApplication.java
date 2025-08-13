package com.MiLibreria.Practicas;

import com.MiLibreria.Practicas.apis.Gutendex;
import com.MiLibreria.Practicas.apis.JsonParser;
import com.MiLibreria.Practicas.entidades.AplicacionConsola;
import com.MiLibreria.Practicas.entidades.Libro;
import com.MiLibreria.Practicas.entidades.RespuestaAPI;
import com.MiLibreria.Practicas.service.LibroService;
import com.MiLibreria.Practicas.vistas.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class AluraApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AluraApplication.class, args);
		AplicacionConsola aplicacion = context.getBean(AplicacionConsola.class);
		aplicacion.ejecutar();
		context.close();
	}
}
