package com.MiLibreria.Practicas.apis;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class Gutendex {
    private static final String BASE_URL = "https://gutendex.com/books/";
    private final HttpClient httpClient;

    public Gutendex(){
        this.httpClient = HttpClient.newBuilder()
                .version(HttpClient.newHttpClient().version().HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
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
