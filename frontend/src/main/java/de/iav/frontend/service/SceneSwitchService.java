package de.iav.frontend.service;

import de.iav.frontend.controller.QuestionerController;
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

    public void switchToQuestionerPageOne(ActionEvent event, User user) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/de/iav/frontend/QuestionerPageOne.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        QuestionerController questionerController = loader.getController();
        questionerController.setUserForQuestioner(user);

        Scene scene = new Scene(root);
        stage.setTitle("Questioner");
        stage.setScene(scene);

        stage.show();
    }

    public void switchToQuestionerPageTwo(ActionEvent event, User user) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/de/iav/frontend/QuestionerPageTwo.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        QuestionerController questionerController = loader.getController();
        questionerController.setUserForQuestioner(user);

        Scene scene = new Scene(root);
        stage.setTitle("Questioner");
        stage.setScene(scene);

        stage.show();
    }
}
