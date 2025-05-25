package org.example;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {

    public Cambio consultaCambio(String moedaOrigem, String moedaDestino, double valor) {
        try {
            String endpoint = String.format("https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/" + moedaOrigem + "/" + moedaDestino);
            URI uri = URI.create(endpoint);

            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();

            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            RespostaApi dados = new Gson().fromJson(response.body(), RespostaApi.class);
            double valorConvertido = valor * dados.conversion_rate();

            return new Cambio(moedaOrigem, moedaDestino, valor, valorConvertido);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao consultar a API de câmbio", e);
        }
    }

    private record JsonResponse(double conversion_result) {
    }
}
