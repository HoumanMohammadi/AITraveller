package de.iav.frontend.controller;

import de.iav.frontend.model.User;
import de.iav.frontend.service.SceneSwitchService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class UserHomeController {
    @FXML
    private User user;
    private final SceneSwitchService sceneSwitchService= SceneSwitchService.getInstance();
    public void openQuestionerView(ActionEvent event) throws IOException {
        System.out.println("got to questioner");
        sceneSwitchService.switchToQuestionerPageOne(event, user);
    }
}
