package de.iav.backend.gptApiCommunication;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
@RequiredArgsConstructor
public class ChatGPTService {
    private static final String API_URL = "https://api.openai.com/v1/chat/completions"; // Example API URL
    private final WebClient webClient= WebClient.create(API_URL);
    private final Gson gson;
    private final ChatGPTAPIRequest chatGPTAPIRequest;
    private final TransformQuestionerToText transformQuestionerToText;
    public ChatGPTResponse getChatSuggestion(QuestionerAnswers questionerBuilder) {
        Message messages= new Message();
        messages.role="user";
        messages.content= transformQuestionerToText.transform(questionerBuilder);
        List<Message> messagesList=new ArrayList<>();
        messagesList.add(messages);
        System.out.println("message list: "+ messagesList.toString());

        chatGPTAPIRequest.setModel("gpt-3.5-turbo");
        chatGPTAPIRequest.setMessages(messagesList);

        System.out.println("chatGPTAPIRequest: "+ chatGPTAPIRequest);


        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String apiKey = properties.getProperty("api.key");
        // Serialize the request object to JSON
        String jsonRequest = gson.toJson(chatGPTAPIRequest);
        System.out.println("request: "+ chatGPTAPIRequest.toString());
        System.out.println("jsonrequest: "+jsonRequest);

        // Send the request using WebClient
        ChatGPTResponse response= webClient.post()
                .header("Authorization", "Bearer "+ apiKey) // Replace with your actual API key
                .header("Content-Type", "application/json")
                .body(BodyInserters.fromValue(jsonRequest))
                .retrieve()
                .bodyToMono(ChatGPTResponse.class)
                .block(); // Block until the response is received (this is okay in this context)

        if (response != null) {
            List<Choices> choices = response.getChoices();
            for (Choices choice : choices) {
                Message message = choice.getMessage();
                if (message != null) {
                    String content = message.getContent();
                    System.out.println("Content: " + content);
                }
            }
        }
        return response;
    }
}
