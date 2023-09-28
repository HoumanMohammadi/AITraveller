package de.iav.frontend.controller;


import de.iav.frontend.model.QuestionerAnswers;
import de.iav.frontend.model.User;
import de.iav.frontend.service.SceneSwitchService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionerPageTwoController {
    private QuestionerAnswers questionerAnswers;
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
    private  QuestionerAnswers.Builder questionerBuilder;
    @FXML
    private void initialize() {
        if (travelDurationChoiceBox != null) {
            travelDurationChoiceBox.getItems().addAll("1 day", "2 days", "3 days", "4 days", "5 days");
            travelDurationChoiceBox.setValue("--SELECT--");
        }
    }

    @FXML
    private void handleSeasonRadioButtonAction() {
        RadioButton selectedRadioButton = (RadioButton) seasonToggleGroup.getSelectedToggle();
        if (selectedRadioButton != null) {
            String selectedSeason = selectedRadioButton.getText();
            questionerBuilder= questionerBuilder.season(selectedSeason);
            System.out.println("Selected Season: " + selectedSeason);
        } else {
            System.out.println("No season selected.");
        }
    }




    public void switchToPageOne(ActionEvent event) throws IOException {
        sceneSwitchService.switchToQuestionerPageOne(event, questionerBuilder);
    }
    @FXML
    private void handleCheckboxAction() {
        List<String> activities = new ArrayList<>();
        if (hikingCheckbox.isSelected()) activities.add("Hiking");
        if (scubaDivingCheckbox.isSelected()) activities.add("Scuba Diving");
        if (surfingCheckbox.isSelected()) activities.add("Surfing");
        if (yogaCheckbox.isSelected()) activities.add("Yoga");
        if (skiingCheckbox.isSelected()) activities.add("Skiing");
        if (swimmingCheckbox.isSelected()) activities.add("Swimming");
        if (sailingCheckbox.isSelected()) activities.add("Sailing");
        if (pokerCheckbox.isSelected()) activities.add("Poker");
        if (sunBathingCheckbox.isSelected()) activities.add("Sun Bathing");

        questionerBuilder = questionerBuilder.activity(activities);
    }

    public void setQuestionerBuilder(QuestionerAnswers.Builder questionerBuilder) {
        this.questionerBuilder = questionerBuilder;
    }

    public void handletravelDuration(ActionEvent event) {
        questionerBuilder.travelDuration(travelDurationChoiceBox.getValue());
    }
}
