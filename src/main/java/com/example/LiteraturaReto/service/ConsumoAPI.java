package com.example.LiteraturaReto.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {

    public String obtenerDatos(String url) {
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)  // <- sigue redirecciones
                .build();


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url.trim()))
                .header("User-Agent", "Java HttpClient")
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Código HTTP: " + response.statusCode());
            System.out.println("Longitud de respuesta: " + response.body().length());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al consumir API", e);
        }
    }
}
