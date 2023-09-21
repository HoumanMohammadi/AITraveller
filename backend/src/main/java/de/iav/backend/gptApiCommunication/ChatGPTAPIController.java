package de.iav.backend.gptApiCommunication;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questioner")
public class ChatGPTAPIController {
    private final ChatGPTClient chatGPTClient;


    public ChatGPTAPIController(ChatGPTClient chatGPTClient) {
        this.chatGPTClient = chatGPTClient;
    }

    @PostMapping
    public ChatGPTResponse getTravelSuggestion(@RequestBody ChatGPTAPIRequest chatGPTAPIRequest) throws Exception {
        return chatGPTClient.getChatSuggestion(chatGPTAPIRequest);
    }
}
