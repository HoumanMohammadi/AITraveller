package de.iav.backend.gptApiCommunication;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questioner")
public class ChatGPTAPIController {

    private final ChatGPTService chatGPTService;

    //private final QuestionerAnswers.Builder questionerBuilder;


    public ChatGPTAPIController(ChatGPTService chatGPTService) {
        this.chatGPTService = chatGPTService;
        //this.questionerBuilder = questionerBuilder;
    }


    @PostMapping("/questionAnswers")
    public ChatGPTResponse getQuestionAnswers(@RequestBody QuestionerAnswers questionerBuilder) throws Exception {
        System.out.println("questionerBuilder.toString()"+questionerBuilder.toString());
        System.out.println(questionerBuilder.getCoTraveller());
        return chatGPTService.getChatSuggestion(questionerBuilder);
        //return questionerBuilder.toString();
    }
}
