package de.iav.frontend.user;

import java.net.URI;
import java.net.http.HttpResponse;
import java.util.List;
import java.net.http.HttpClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpRequest;

public class UserService {
    private static UserService instance;
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;
    public UserService() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public static synchronized UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public List<User> getAllUsers() {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8080/api/aitraveller/usersdata"))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(this::mapToUserList) // .thenApply(responseBody -> mapToStudent(responseBody))
                .join();
    }
    public User addUser(UserWithoutIdDto userWithoutIdDto) {
        try {
            String requestBody = objectMapper.writeValueAsString(userWithoutIdDto);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/api/aitraveller/usersdata"))
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();
            return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(this::mapToUser)
                    .join();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    private List<User> mapToUserList(String responseBody) {
        try {
            return objectMapper.readValue(responseBody, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to map users List", e);
        }
    }
    private User mapToUser(String json) {
        try {
            return objectMapper.readValue(json, User.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to map User", e);
        }
    }
    public User getUserByEmail(String email) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8080/api/aitraveller/usersdata/email/" + email))
                .build();

        User respondedUser = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(this::mapToUser) // .thenApply(responseBody -> mapToStudent(responseBody))
                .join();
        System.out.println("respondedUser: " + respondedUser);
        return respondedUser;
    }
}
