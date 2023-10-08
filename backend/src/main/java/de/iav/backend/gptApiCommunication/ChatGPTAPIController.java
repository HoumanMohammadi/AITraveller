package de.iav.backend.gptApiCommunication;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questioner")
public class ChatGPTAPIController {

    private final ChatGPTClient chatGPTClient;
    //private final QuestionerAnswers.Builder questionerBuilder;


    public ChatGPTAPIController(ChatGPTClient chatGPTClient) {
        this.chatGPTClient = chatGPTClient;
        //this.questionerBuilder = questionerBuilder;
    }


    @PostMapping("/questionAnswers")
    public ChatGPTResponse getQuestionAnswers(@RequestBody QuestionerAnswers.Builder questionerBuilder) throws Exception {
        System.out.println("questionerBuilder.toString()"+questionerBuilder.toString());
        System.out.println(questionerBuilder.build().getCoTraveller());
        return chatGPTClient.getChatSuggestion(questionerBuilder.toString());
        //return questionerBuilder.toString();
    }
}
