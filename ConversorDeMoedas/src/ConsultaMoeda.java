import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;

public class ConsultaMoeda {
    public Conversao buscarMoeda(String moeda) {
        URI conversor = URI.create("https://v6.exchangerate-api.com/v6/818a378aad3260ee53c3573e/latest/" + moeda);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(conversor)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversao.class);
        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter a conversao a partir desta moeda.");
        }

    }
}
