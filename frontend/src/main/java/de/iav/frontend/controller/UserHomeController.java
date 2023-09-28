package de.iav.frontend.controller;

import de.iav.frontend.model.QuestionerAnswers;
import de.iav.frontend.model.User;
import de.iav.frontend.service.SceneSwitchService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class UserHomeController {
    @FXML
    private User user;
    private QuestionerAnswers.Builder questionerBuilder;
    private final SceneSwitchService sceneSwitchService= SceneSwitchService.getInstance();
    public void openQuestionerPageOneView(ActionEvent event) throws IOException {
        System.out.println("go to questioner page 1");
        sceneSwitchService.switchToQuestionerPageOne(event, questionerBuilder);
    }

    public void setUserForHome(User user) {
    }
}
