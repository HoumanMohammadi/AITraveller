package de.iav.frontend.controller;

import de.iav.frontend.model.QuestionerAnswers;
import de.iav.frontend.service.SceneSwitchService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class QuestionerPageThreeController {
    private final SceneSwitchService sceneSwitchService= SceneSwitchService.getInstance();
    public CheckBox europeCheckbox;
    @FXML
    public CheckBox northAmericaCheckbox;
    @FXML
    public CheckBox southAmericaCheckbox;
    @FXML
    public CheckBox asiaCheckbox;
    @FXML
    public CheckBox africaCheckbox;
    @FXML
    public CheckBox australiaCheckbox;
    @FXML
    public CheckBox carCheckbox;
    @FXML
    public CheckBox trainCheckbox;
    @FXML
    public CheckBox busCheckbox;
    @FXML
    public CheckBox rvCheckbox;
    @FXML
    public CheckBox planeCheckbox;
    @FXML
    public CheckBox cultureCheckbox;
    @FXML
    public CheckBox adventureCheckbox;
    @FXML
    public CheckBox relaxingCheckbox;
    @FXML
    public CheckBox bikeCheckbox;
    @FXML
    public TextField preferredDestinationTextField;

    private  QuestionerAnswers.Builder questionerBuilder;

    public void setQuestionerBuilder(QuestionerAnswers.Builder questionerBuilder) {
        if (questionerBuilder != null) {
            System.out.println("before");
            this.questionerBuilder = questionerBuilder;
            System.out.println("after");
        } else {
            // Handle the case where questionerBuilder is null
            System.out.println("Error: questionerBuilder is null.");
        }
    }

    public void switchToPageTwo(ActionEvent event) throws IOException {
        setQuestionerBuilder(questionerBuilder);
        sceneSwitchService.switchToQuestionerPageOneFromTwo(event, questionerBuilder);
    }
    public void setDestinationTown(ActionEvent event) {
        questionerBuilder.preferredDestination(preferredDestinationTextField.getText());
    }

    @FXML
    private void handleMeansOfTravelCheckboxAction() {
        List<String> meansOfTravel = new ArrayList<>();
        if (carCheckbox.isSelected()){
            meansOfTravel.add("Car");
            System.out.println("Car added");
            System.out.println(questionerBuilder.toString());
        }
        if (busCheckbox.isSelected()) meansOfTravel.add("Bus");
        if (planeCheckbox.isSelected()) meansOfTravel.add("Plane");
        if (trainCheckbox.isSelected()) meansOfTravel.add("Train");
        if (rvCheckbox.isSelected()) meansOfTravel.add("RV");
        if (bikeCheckbox.isSelected()) meansOfTravel.add("Bike");

        questionerBuilder = questionerBuilder.meansOfTravel(meansOfTravel);
        System.out.println(questionerBuilder.toString());
    }

    @FXML
    private void handleMoodCheckboxAction() {
        List<String> mood = new ArrayList<>();
        if (relaxingCheckbox.isSelected()){
            mood.add("Relaxing");
            System.out.println("Relaxing added");
            System.out.println(questionerBuilder.toString());
        }
        if (adventureCheckbox.isSelected()) mood.add("Adventure");
        if (cultureCheckbox.isSelected()) mood.add("Culture");

        questionerBuilder = questionerBuilder.travelPurpose(mood);
        System.out.println(questionerBuilder.toString());
    }
    @FXML
    private void handleContinentCheckboxAction() {
        List<String> travelContinent = new ArrayList<>();
        if (europeCheckbox.isSelected()){
            travelContinent.add("Europe");
            System.out.println("Europe added");
            System.out.println(questionerBuilder.toString());
        }
        if (asiaCheckbox.isSelected()) travelContinent.add("Asia");
        if (africaCheckbox.isSelected()) travelContinent.add("Africa");
        if (northAmericaCheckbox.isSelected()) travelContinent.add("NorthAmerica");
        if (southAmericaCheckbox.isSelected()) travelContinent.add("SouthAmerica");
        if (australiaCheckbox.isSelected()) travelContinent.add("Australia");

        questionerBuilder = questionerBuilder.destinationContinent(travelContinent);
        System.out.println(questionerBuilder.toString());
    }
}
