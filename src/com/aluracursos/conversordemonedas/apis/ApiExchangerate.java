package com.aluracursos.conversordemonedas.apis;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiExchangerate {
    private final String acronimoMonedaBase;
    private final String acronimoMonedaObjetivo;

    public ApiExchangerate(String acronimoMonedaBase, String acronimoMonedaObjetivo) {
        this.acronimoMonedaBase = acronimoMonedaBase;
        this.acronimoMonedaObjetivo = acronimoMonedaObjetivo;
    }
    public String obtenerDatosApi() throws IOException, InterruptedException {

        String plantillaUri = "https://v6.exchangerate-api.com/v6/342317a62823f406dd7cc9c3/pair/";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(plantillaUri + acronimoMonedaBase + "/" + acronimoMonedaObjetivo))
                .GET()
                .build();

        try(HttpClient client = HttpClient.newHttpClient()){
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return  response.body();
        }
    }
}
