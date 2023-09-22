package de.iav.frontend.controller;

import de.iav.frontend.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class QuestionerController {

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

    public void setUserForQuestioner(User user) {
    }
}
