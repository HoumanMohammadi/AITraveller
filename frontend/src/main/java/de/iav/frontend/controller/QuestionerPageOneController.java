package de.iav.frontend.controller;

import de.iav.frontend.model.QuestionerAnswers;
import de.iav.frontend.model.User;
import de.iav.frontend.service.SceneSwitchService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionerPageOneController {
    @FXML
    public ChoiceBox<String> ageChoiceBox;
    @FXML
    public RadioButton noRadioButton;
    @FXML
    public RadioButton yesRadioButton;
    @FXML
    private ToggleGroup disabilityToggleGroup;
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
    @FXML
    private QuestionerAnswers.Builder questionerBuilder = new QuestionerAnswers.Builder(20, new ArrayList<>(), "", false, "", new ArrayList<>(), "", "", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    private final List<String> coTraveller = new ArrayList<>();


    @FXML
    private void initialize() {

        /*setQuestionerBuilder(questionerBuilder);
        System.out.println(questionerBuilder.toString());*/
        if ( ageChoiceBox != null) {
            ageChoiceBox.getItems().addAll("16 to 20", "20 to 30", "30 to 40", "40 to 50", "50 to 70", "over 70");
            ageChoiceBox.setValue("--SELECT--");
        }
    }

    public QuestionerAnswers.Builder getQuestionerBuilder() {
        return questionerBuilder;
    }

    @FXML
    private void handleCheckboxAction(ActionEvent event) {
        coTraveller.clear();
        if (aloneCheckbox.isSelected()) coTraveller.add("alone");
        if (parentsCheckbox.isSelected()) coTraveller.add("parents");
        if (partnerCheckbox.isSelected()) coTraveller.add("partner");
        if (childrenCheckbox.isSelected()) coTraveller.add("children");
        if (friendsCheckbox.isSelected()) coTraveller.add("friends");

        questionerBuilder.coTraveller.clear();
        questionerBuilder.coTraveller.addAll(coTraveller);

        System.out.println("Co-traveller List: " + coTraveller);
        System.out.println(questionerBuilder.toString());
    }

    public void setQuestionerBuilder(QuestionerAnswers.Builder questionerBuilder) {
        if (questionerBuilder== null){
            questionerBuilder = new QuestionerAnswers.Builder(20, new ArrayList<>(), "", false, "", new ArrayList<>(), "", "", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        }
        else
            this.questionerBuilder = questionerBuilder;
    }

    public void switchToQuestionerPageTwo(ActionEvent event) throws IOException {
        System.out.println("go to questioner page 2");
        System.out.println(questionerBuilder.toString());
        setQuestionerBuilder(questionerBuilder);
        sceneSwitchService.switchToQuestionerPageTwo(event, questionerBuilder);
    }

    public void switchToUserHome(ActionEvent event) throws IOException {
        sceneSwitchService.switchToUserHome(event, user);
    }

    public void setHomeTown(ActionEvent event) {
        questionerBuilder.livingCity(locationTextField.getText());
    }

    public void handleDisabilityRadioButtonAction(ActionEvent event) {
        System.out.println("calling disability handling");
        RadioButton selectedRadioButton = (RadioButton) disabilityToggleGroup.getSelectedToggle();
        if (selectedRadioButton != null) {
            String selectedValue = selectedRadioButton.getText();
            boolean selectedDisability = selectedValue.equals("YES"); // Assuming "Yes" is for true, "No" is for false
            questionerBuilder.disability(selectedDisability);
            System.out.println("Selected disability: " + selectedDisability);
        } else {
            System.out.println("No disability selected.");
        }
    }
   /* ("16 to 20", "20 to 30", "30 to 40", "40 to 50", "50 to 70", "over 70");
            ageChoiceBox.setValue("--SELECT--");*/

    public void handleAgeChoiceBox(ActionEvent event) {
        String ageChoice = ageChoiceBox.getValue();

        switch (ageChoice) {
            case "--SELECT--" -> questionerBuilder.age(22);
            case "16 to 20" -> questionerBuilder.age(16);
            case "20 to 30" -> questionerBuilder.age(25);
            case "30 to 40" -> questionerBuilder.age(35);
            case "40 to 50" -> questionerBuilder.age(45);
            case "50 to 60" -> questionerBuilder.age(55);
            case "60 to 70" -> questionerBuilder.age(65);
            case "over 70" -> questionerBuilder.age(75);
            default -> {
            }
        }
    }
}
