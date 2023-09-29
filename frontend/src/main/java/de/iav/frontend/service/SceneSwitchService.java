package de.iav.frontend.service;

import de.iav.frontend.controller.QuestionerPageOneController;
import de.iav.frontend.controller.QuestionerPageTwoController;
import de.iav.frontend.controller.UserHomeController;
import de.iav.frontend.model.QuestionerAnswers;
import de.iav.frontend.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitchService {

    private static SceneSwitchService instance;

    public static synchronized SceneSwitchService getInstance() {
        if (instance==null){
            instance= new SceneSwitchService();
        }
        return instance;
    }

    public void switchToQuestionerPageOne(ActionEvent event, QuestionerAnswers.Builder questionerBuilder) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/de/iav/frontend/QuestionerPageOne.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        QuestionerPageOneController questionerPageOneController = loader.getController();
        //questionerPageOneController.setQuestionerBuilder(questionerBuilder);

        Scene scene = new Scene(root);
        stage.setTitle("Questioner1");
        stage.setScene(scene);

        stage.show();
    }

    public void switchToQuestionerPageTwo(ActionEvent event, QuestionerAnswers.Builder questionerBuilder) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/de/iav/frontend/QuestionerPageTwo.fxml"));
        System.out.println("debugger   "+questionerBuilder.toString());

        QuestionerPageTwoController controllerTwo = loader.getController();
        //controllerTwo.setQuestionerBuilder(questionerBuilder);
        Parent root = loader.load();
        System.out.println("Debug: setQuestionerBuilder called with non-null questionerBuilder");


        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);
        stage.setTitle("Questioner2");
        stage.setScene(scene);

        stage.show();
    }

    public void switchToUserHome(ActionEvent event, User user) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/de/iav/frontend/userHome.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        UserHomeController userHomeController = loader.getController();
        userHomeController.setUserForHome(user);

        Scene scene = new Scene(root);
        stage.setTitle("UserHome");
        stage.setScene(scene);

        stage.show();
    }
}
