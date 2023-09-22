package de.iav.frontend.controller;


import de.iav.frontend.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class QuestionerPageTwoController {

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
    private Button nextButton;

    @FXML
    private Button backButton;

    @FXML
    private void initialize() {
        if (travelDurationChoiceBox != null) {
            travelDurationChoiceBox.getItems().addAll("1 day", "2 days", "3 days", "4 days", "5 days");
            travelDurationChoiceBox.setValue("1 day");
        }
    }


    @FXML
    private void handleNextButtonAction() {
        // Code to handle Next button click
    }

    @FXML
    private void handleBackButtonAction() {
        // Code to handle Back button click
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

    // Add methods for handling checkbox selections if needed

    // Add any other methods you need

}
