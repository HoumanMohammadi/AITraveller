package de.iav.frontend.controller;

import de.iav.frontend.model.*;
import de.iav.frontend.service.GetSuggestionService;
import de.iav.frontend.service.SceneSwitchService;
import de.iav.frontend.service.TravelService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class AIResponseController {

    @FXML
    public Label label;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private User user;
    public String content;
    private  QuestionerAnswers.Builder questionerBuilder;
    private TravelService travelService;
    private final GetSuggestionService getSuggestionService = GetSuggestionService.getInstance();

    private final SceneSwitchService sceneSwitchService= SceneSwitchService.getInstance();
    User sampleUser = new User(
            "12345",
            "John",
            "Doe",
            "john.doe@example.com",
            "user"
    );




    public void switchToPageThree(ActionEvent event) throws IOException {
        setQuestionerBuilder(questionerBuilder);
        sceneSwitchService.switchToQuestionerPageThreeFromAIController(event, questionerBuilder, this);
    }


    public void setQuestionerBuilder(QuestionerAnswers.Builder questionerBuilder) {
        if (questionerBuilder != null) {
            this.questionerBuilder = questionerBuilder;
            receiveResponse(getSuggestionService.getSuggestion(questionerBuilder.build()));
        } else {
            // Handle the case where questionerBuilder is null
            System.out.println("Error: questionerBuilder is null.");
        }
    }

    public void switchToMainPage(ActionEvent event) throws IOException {
        sceneSwitchService.switchToUserHome(event,sampleUser);
        travelService.createNewTravel(new NewTravelDTO(content, sampleUser, LocalDateTime.now(), questionerBuilder.build()));
    }

    public void receiveResponse(ChatGPTResponse response) {
        Label label = new Label();
        scrollPane.setContent(label);

        List<Choices> choices = response.choices();
        for (Choices choice : choices) {
            Message message = choice.message();
            if (message != null) {
                content = message.content();
                System.out.println("Content: " + content);
                label.setText(content);
            }
        }
    }

}