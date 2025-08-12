package com.MiLibreria.Practicas.apis;

import com.MiLibreria.Practicas.entidades.Libro;
import com.MiLibreria.Practicas.entidades.RespuestaAPI;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {
    private static final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static RespuestaAPI parsearRespuesta(String json) throws Exception{
        return mapper.readValue(json, RespuestaAPI.class);
    }

    public static Libro parsearLibro(String json) throws Exception{
        return mapper.readValue(json, Libro.class);
    }
}
