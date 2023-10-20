package de.iav.frontend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.iav.frontend.model.NewTravelDTO;
import de.iav.frontend.model.Travel;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TravelService {
    private static TravelService instance;
    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final String BASE_URL = "http://localhost:8080/api/aitraveller/travels"; // Replace with your actual backend URL

    public Travel createNewTravel(NewTravelDTO newTravelDTO) {
        try {
            String requestBody = objectMapper.writeValueAsString(newTravelDTO);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL))
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(this::mapToTravel)
                    .join();

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    private Travel mapToTravel(String responseBody) {
        try {
            return objectMapper.readValue(responseBody, Travel.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
