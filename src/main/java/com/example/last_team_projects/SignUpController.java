package com.example.last_team_projects;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
   @FXML
   private Button button_signup_reg;
   @FXML
   private Button button_login_reg;

   @FXML
   private TextField tf_username_reg;
    @FXML
    private TextField tf_password_reg;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       button_signup_reg.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               if (!tf_username_reg.getText().trim().isEmpty() && !tf_password_reg.getText().trim().isEmpty()){
                   DBUtils.signUpUser(event, tf_username_reg.getText(), tf_password_reg.getText());
               }else {
                   System.out.println("Please fill in all application!");
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setContentText("Please fill in all application to sign up!");
                   alert.show();
               }
           }
       });

       button_login_reg.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               DBUtils.changeScene(event, "LogInAdmin.fxml", "Log In!", null);
           }
       });
    }
}
