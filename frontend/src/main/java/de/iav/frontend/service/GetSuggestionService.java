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

    public void getSuggestion(QuestionerAnswers questionerBuilder) {
        try {

            String requestBody = objectMapper.writeValueAsString(questionerBuilder); // build() to get a QuestionerAnswers instance
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/api/questioner/questionAnswers"))
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();
            System.out.println("send Builder to backend. Builder:"+ questionerBuilder);
            System.out.println("request body:   "+requestBody);

            httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(this::mapToQuestionerBuilder)
                    .join();
            System.out.println("httpclient........."+httpClient);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private QuestionerAnswers mapToQuestionerBuilder(String responseBody) {
        try {
            System.out.println("objectMapper  " + responseBody);
            return objectMapper.readValue(responseBody, QuestionerAnswers.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to map preference", e);
        }
    }
}
