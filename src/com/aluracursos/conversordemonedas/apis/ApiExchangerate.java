package com.aluracursos.conversordemonedas.apis;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Clase que se encarga de realizar la solicitud a la API de tasa de cambio.
 * Utiliza el servicio de Exchangerate API para obtener la tasa de cambio entre dos monedas.
 */
public class ApiExchangerate {
    private final String acronimoMonedaBase;
    private final String acronimoMonedaObjetivo;

    /**
     * Constructor de la clase ApiExchangerate.
     *
     * @param acronimoMonedaBase El acrónimo de la moneda base (por ejemplo, "USD").
     * @param acronimoMonedaObjetivo El acrónimo de la moneda objetivo (por ejemplo, "EUR").
     */
    public ApiExchangerate(String acronimoMonedaBase, String acronimoMonedaObjetivo) {
        this.acronimoMonedaBase = acronimoMonedaBase;
        this.acronimoMonedaObjetivo = acronimoMonedaObjetivo;
    }

    /**
     * Realiza una solicitud GET a la API de Exchangerate para obtener la tasa de conversión
     * entre las dos monedas especificadas.
     *
     * @return El cuerpo de la respuesta de la API en formato JSON que contiene la tasa de conversión.
     * @throws IOException Si ocurre un error de entrada/salida durante la solicitud.
     * @throws InterruptedException Si la operación es interrumpida mientras espera la respuesta de la API.
     */
    public String obtenerDatosApi() throws IOException, InterruptedException {

        // URL base para la solicitud a la API
        String plantillaUri = "https://v6.exchangerate-api.com/v6/342317a62823f406dd7cc9c3/pair/";

        // Construcción de la solicitud HTTP GET
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(plantillaUri + acronimoMonedaBase + "/" + acronimoMonedaObjetivo))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        // Envío de la solicitud y obtención de la respuesta
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        }
    }
}
