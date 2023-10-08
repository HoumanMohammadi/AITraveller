package de.iav.frontend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.iav.frontend.model.QuestionerAnswers;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetSuggestionService {

    private static GetSuggestionService instance;
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    private GetSuggestionService() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public static synchronized GetSuggestionService getInstance() {
        if (instance == null) {
            instance = new GetSuggestionService();
        }
        return instance;
    }

    private String mapToString(Object object) {
        try {
            System.out.println("objectMapper  "+objectMapper.writeValueAsString(object));
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to map preference", e);
        }
    }


    public void getSuggestion(QuestionerAnswers questionerAnswers) {
        try {

            String requestBody = objectMapper.writeValueAsString(questionerAnswers);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/api/questioner/questionAnswers"))
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();
            System.out.println("send Builder to backend. Builder:"+ questionerAnswers);
            System.out.println("request body:   "+requestBody);

            httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(this::mapToString)
                    .join();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
