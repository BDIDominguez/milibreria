package com.MiLibreria.Practicas.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@Service
public class Gutendex {
    private static final String BASE_URL = "https://gutendex.com/books/";
    private final HttpClient httpClient;

    @Autowired
    public Gutendex(HttpClient httpClient){
        this.httpClient = httpClient;
    }

    public String buscarTitulo(String titulo) throws Exception {
        String tituloCodificado = URLEncoder.encode(titulo, StandardCharsets.UTF_8);
        String busquedaURL = BASE_URL + "?search=" + tituloCodificado;

        HttpRequest consulta = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(busquedaURL))
                .header("Accept", "application/json")
                .build();

        HttpResponse<String> respuesta = httpClient.send(
                consulta,
                HttpResponse.BodyHandlers.ofString()
        );

        if (respuesta.statusCode() == 200) {
            return respuesta.body();
        } else {
            throw new RuntimeException("Error al consultar la API: " + respuesta.statusCode());
        }
    }
} // Fin de Clase
