package de.iav.frontend.controller;

import de.iav.frontend.model.QuestionerAnswers;
import de.iav.frontend.model.User;
import de.iav.frontend.service.SceneSwitchService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class AIResponseController {
    @FXML
    private User user;
    private  QuestionerAnswers.Builder questionerBuilder;
    private final SceneSwitchService sceneSwitchService= SceneSwitchService.getInstance();
    public void switchToPageThree(ActionEvent event) throws IOException {
        setQuestionerBuilder(questionerBuilder);
        sceneSwitchService.switchToQuestionerPageThree(event, questionerBuilder);
    }

    public void setQuestionerBuilder(QuestionerAnswers.Builder questionerBuilder) {
        if (questionerBuilder != null) {
            this.questionerBuilder = questionerBuilder;
        } else {
            // Handle the case where questionerBuilder is null
            System.out.println("Error: questionerBuilder is null.");
        }
    }

    public void switchToMainPage(ActionEvent event) throws IOException {
        sceneSwitchService.switchToUserHome(event,user);
    }
}