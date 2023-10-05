package de.iav.backend.gptApiCommunication;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questioner")
public class ChatGPTAPIController {
/*
    private final ChatGPTClient chatGPTClient;
    //private final QuestionerAnswers.Builder questionerBuilder;


    public ChatGPTAPIController(ChatGPTClient chatGPTClient) {
        this.chatGPTClient = chatGPTClient;
        //this.questionerBuilder = questionerBuilder;
    }
*/

/*
    public ChatGPTResponse getTravelSuggestion(@RequestBody ChatGPTAPIRequest chatGPTAPIRequest) throws Exception {
        return chatGPTClient.getChatSuggestion(chatGPTAPIRequest);
    }*/
    @PostMapping("/questionAnswers")
    public void getQuestionAnswers(@RequestBody QuestionerAnswers.Builder questionerBuilder) throws Exception {
        System.out.println(questionerBuilder.toString());
        //return questionerBuilder.toString();
    }
}
