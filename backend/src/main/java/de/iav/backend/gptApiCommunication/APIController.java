package de.iav.backend.gptApiCommunication;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questioner")
public class APIController {
    private final ChatGPTClient chatGPTClient;


    public APIController(ChatGPTClient chatGPTClient) {
        this.chatGPTClient = chatGPTClient;
    }

    @GetMapping
    public APIResponse getTravelSuggestion(@RequestBody APIRequest apiRequest) throws Exception {
        return chatGPTClient.getChatSuggestion(apiRequest);
    }
}
