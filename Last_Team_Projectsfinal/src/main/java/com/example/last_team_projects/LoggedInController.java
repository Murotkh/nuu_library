package com.example.last_team_projects;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggedInController implements  Initializable{
    @FXML
    private Button button_myBooks;
    @FXML
    private Button button_settings;
    @FXML
    private Button button_logout;
    @FXML
    Label label_welcome;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    button_logout.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
         DBUtils.changeScene(event, "LogInAdmin.fxml", "Login!", null);
        }
    });
    button_myBooks.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            DBUtils.changeScene(event, "myBooks.fxml", "My Books!", null);
        }
    });
    button_settings.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            DBUtils.changeScene(event, "Settings.fxml", "Settings!", null);
        }
    });

    }
    public void setUserInformation(String username){
        label_welcome.setText("Welcome " + username + "!");
    }
}
