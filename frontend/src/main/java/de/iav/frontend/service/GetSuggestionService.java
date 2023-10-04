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

    private String mapToString(String json) {
        try {
            return objectMapper.readValue(json, String.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to map preference", e);
        }
    }

    public String getSuggestion(QuestionerAnswers.Builder questionerBuilder) {
        try {
            //StudentWithoutMatriculationNumber studentDto = generateOneStudentDto();
            String requestBody = objectMapper.writeValueAsString(questionerBuilder);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/api/questioner"))
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();
            System.out.println("send Builder to backend. Builder:"+ questionerBuilder);

            return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(this::mapToString)
                    .join();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
