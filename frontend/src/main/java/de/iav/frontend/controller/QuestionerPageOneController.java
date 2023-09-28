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
    private QuestionerAnswers.Builder questionerBuilder = new QuestionerAnswers.Builder("", new ArrayList<>(), "", false, "", new ArrayList<>(), "", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

    @FXML
    private void initialize() {
        System.out.println(questionerBuilder.toString());
        if ( ageChoiceBox != null) {
            ageChoiceBox.getItems().addAll("16 to 20", "20 to 30", "30 to 40", "40 to 50", "50 to 70", "over 70");
            ageChoiceBox.setValue("--SELECT--");
        }
    }
    @FXML
    private void handleCheckboxAction() {
        System.out.println("Alone Checkbox selected: " + aloneCheckbox.isSelected());
        System.out.println("Parents Checkbox selected: " + parentsCheckbox.isSelected());
        System.out.println("Partner Checkbox selected: " + partnerCheckbox.isSelected());
        System.out.println("Children Checkbox selected: " + childrenCheckbox.isSelected());
        System.out.println("Friends Checkbox selected: " + friendsCheckbox.isSelected());

        List<String> coTraveller = new ArrayList<>();
        if (aloneCheckbox.isSelected()) coTraveller.add("alone");
        if (parentsCheckbox.isSelected()) coTraveller.add("parents");
        if (partnerCheckbox.isSelected()) coTraveller.add("partner");
        if (childrenCheckbox.isSelected()) coTraveller.add("children");
        if (friendsCheckbox.isSelected()) coTraveller.add("friends");

        System.out.println("Co-traveller List: " + coTraveller);

        questionerBuilder = questionerBuilder.coTraveller(coTraveller);
        System.out.println(questionerBuilder.toString());
    }
    public void switchToQuestionerPageTwo(ActionEvent event) throws IOException {
        System.out.println("go to questioner page 2");
        System.out.println(questionerBuilder.toString());
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

    public void handleAgeChoiceBox(ActionEvent event) {
        questionerBuilder.age(ageChoiceBox.getValue());
    }
}
