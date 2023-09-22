package de.iav.frontend.controller;

import de.iav.frontend.model.User;
import de.iav.frontend.service.SceneSwitchService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class QuestionerPageOneController {
    @FXML
    private User user;

    @FXML
    private Button nextButton;

    @FXML
    private Text question1;

    @FXML
    private ChoiceBox<String> travelWithChoiceBox;

    @FXML
    private CheckBox aloneCheckbox;

    @FXML
    private CheckBox parentsCheckbox;

    @FXML
    private CheckBox partnerCheckbox;

    @FXML
    private CheckBox childrenCheckbox;

    @FXML
    private CheckBox friendsCheckbox;

    @FXML
    private TextField locationTextField;

    @FXML
    private Button backButton;

    @FXML
    private Text question2;

    @FXML
    private CheckBox mobilityYesCheckbox;

    @FXML
    private CheckBox mobilityNoCheckbox;
    private final SceneSwitchService sceneSwitchService= SceneSwitchService.getInstance();

    public void setUserForQuestioner(User user) {
    }

    public void switchToQuestionerPageTwo(ActionEvent event) throws IOException {
        System.out.println("go to questioner page 2");
        sceneSwitchService.switchToQuestionerPageTwo(event, user);

    }

    public void switchToUserHome(ActionEvent event) throws IOException {
        sceneSwitchService.switchToUserHome(event, user);
    }
}
