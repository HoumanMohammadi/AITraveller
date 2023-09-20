package de.iav.backend.gptApiCommunication;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ChatGPTClient {
    private static final String API_URL = "https://api.openai.com/v1/chat/completions"; // Example API URL
    private final WebClient webClient= WebClient.create(API_URL);
    private final Gson gson;

    public APIResponse getChatSuggestion(APIRequest request) {
        // Serialize the request object to JSON
        String jsonRequest = gson.toJson(request);
        System.out.println("request: "+ request.toString());
        System.out.println("jsonrequest: "+jsonRequest);

        // Send the request using WebClient
        APIResponse response= webClient.post()
                .header("Authorization", "Bearer "+"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") // Replace with your actual API key
                .header("Content-Type", "application/json")
                .body(BodyInserters.fromValue(jsonRequest))
                .retrieve()
                .bodyToMono(APIResponse.class)
                .block(); // Block until the response is received (this is okay in this context)
        System.out.println(response);
        return response;
    }
}
