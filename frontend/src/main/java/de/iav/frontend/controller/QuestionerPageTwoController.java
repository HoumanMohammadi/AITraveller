package de.iav.frontend.controller;


import de.iav.frontend.model.User;
import de.iav.frontend.service.SceneSwitchService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class QuestionerPageTwoController {

    private final SceneSwitchService sceneSwitchService= SceneSwitchService.getInstance();
    @FXML
    public RadioButton springRadioButton;
    @FXML
    public RadioButton summerRadioButton;
    @FXML
    public RadioButton fallRadioButton;
    @FXML
    public RadioButton winterRadioButton;
    @FXML
    private ChoiceBox<String> travelDurationChoiceBox;
    @FXML
    private CheckBox hikingCheckbox;
    @FXML
    private CheckBox scubaDivingCheckbox;
    @FXML
    private CheckBox surfingCheckbox;
    @FXML
    private CheckBox yogaCheckbox;
    @FXML
    private CheckBox skiingCheckbox;
    @FXML
    private CheckBox swimmingCheckbox;
    @FXML
    private CheckBox sailingCheckbox;
    @FXML
    private CheckBox pokerCheckbox;
    @FXML
    private CheckBox sunBathingCheckbox;
    @FXML
    private ToggleGroup seasonToggleGroup;
    @FXML
    private User user;
    @FXML
    private void initialize() {
        if (travelDurationChoiceBox != null) {
            travelDurationChoiceBox.getItems().addAll("1 day", "2 days", "3 days", "4 days", "5 days");
            travelDurationChoiceBox.setValue("1 day");
        }

        seasonToggleGroup.getToggles().addAll(springRadioButton, summerRadioButton, fallRadioButton, winterRadioButton);
    }

    @FXML
    private void handleSeasonRadioButtonAction() {
        RadioButton selectedRadioButton = (RadioButton) seasonToggleGroup.getSelectedToggle();
        if (selectedRadioButton != null) {
            String selectedSeason = selectedRadioButton.getText();
            System.out.println("Selected Season: " + selectedSeason);
        } else {
            System.out.println("No season selected.");
        }
    }
    public void setUserForQuestioner(User user) {
    }

    public void switchToPageOne(ActionEvent event) throws IOException {
        sceneSwitchService.switchToQuestionerPageOne(event, user);
    }
    @FXML
    private void handleCheckboxAction() {
        // Example: Check if the hiking checkbox is selected
        boolean isHikingSelected = hikingCheckbox.isSelected();
        boolean isScubaDivingSelected= scubaDivingCheckbox.isSelected();
        boolean isSurfingSelected= surfingCheckbox.isSelected();
        boolean isYogaSelected= yogaCheckbox.isSelected();
        boolean isSkiingSelected= skiingCheckbox.isSelected();
        boolean isSwimmingSelected= swimmingCheckbox.isSelected();
        boolean isSailingSelected= sailingCheckbox.isSelected();
        boolean isPokerSelected= pokerCheckbox.isSelected();
        boolean isSunBathingSelected= sunBathingCheckbox.isSelected();
    }
}
