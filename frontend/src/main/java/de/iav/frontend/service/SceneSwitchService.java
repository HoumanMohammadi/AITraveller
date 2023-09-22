package de.iav.frontend.service;

import de.iav.frontend.controller.QuestionerPageOneController;
import de.iav.frontend.controller.QuestionerPageTwoController;
import de.iav.frontend.controller.UserHomeController;
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
        QuestionerPageOneController questionerPageOneController = loader.getController();
        questionerPageOneController.setUserForQuestioner(user);

        Scene scene = new Scene(root);
        stage.setTitle("Questioner1");
        stage.setScene(scene);

        stage.show();
    }

    public void switchToQuestionerPageTwo(ActionEvent event, User user) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/de/iav/frontend/QuestionerPageTwo.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        QuestionerPageTwoController questionerPageTwoController = loader.getController();
        questionerPageTwoController.setUserForQuestioner(user);

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
