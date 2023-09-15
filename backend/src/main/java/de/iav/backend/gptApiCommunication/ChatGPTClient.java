package de.iav.backend.gptApiCommunication;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@Service
@RequiredArgsConstructor
public class ChatGPTClient {
    private static final String API_URL = "https://api.openai.com/v1/chat/completions"; // Example API URL
    private final HttpClient client;
    private final Gson gson;

    public ChatGPTClient() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public APIResponse getChatSuggestion(APIRequest request) throws Exception {
        // Serialize the request object to JSON
        String jsonRequest = gson.toJson(request);

        // Prepare the HTTP request
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(API_URL))
                .header("Authorization", "Bearer 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") // Replace with your actual API key
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();

        // Send the request
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        // Deserialize the response
        APIResponse chatGPTResponse = gson.fromJson(response.body(), APIResponse.class);

        return chatGPTResponse;
    }
}
