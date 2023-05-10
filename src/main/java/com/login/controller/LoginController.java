package com.login.controller;

import com.login.JdbcDao.JdbcDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class LoginController {

    @FXML
    public TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;
    @FXML
    private Button registerButton;

    @FXML
    public void login(ActionEvent actionEvent) throws IOException{

        Window owner = submitButton.getScene().getWindow();

        System.out.println(emailField.getText());
        System.out.println(passwordField.getText());

        if (emailField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your email id");
            return;
        }
        if (passwordField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a password");
            return;
        }

        String emailId = emailField.getText();
        String password = passwordField.getText();

        JdbcDao jdbcDao = new JdbcDao();
        boolean flag = jdbcDao.validate(emailId, password);

        if (!flag) {
            infoBox("Please enter correct Email and Password", null, "Failed");

        } else {
            infoBox("Login Successful!", null, "Success");
            //TODO 1. create a method that takes you to the home/main page when successful login
            toMainPageAfterLogin();

        }


    }
    //TODO 2. create the above described method here
    public void toMainPageAfterLogin() throws IOException {
        Stage stage= (Stage) submitButton.getScene().getWindow();
        stage.close();
        Stage newStage=new Stage();
        Parent root=FXMLLoader.load(getClass().getResource("/fxml/main_page.fxml"));
        newStage.setTitle("Welcome to the Main Page");
        newStage.setScene(new Scene(root,710,610));
        newStage.show();
        System.out.println("Going to Main Page.....");

    }
    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public void registerOnLoginPage() throws IOException {

        Stage stage= (Stage) registerButton.getScene().getWindow();
        stage.close();

        Stage primaryStage=new Stage();
        Parent root= FXMLLoader.load(getClass().getResource("/fxml/registration_page.fxml"));
        primaryStage.setTitle("Register user");
        primaryStage.setScene(new Scene(root,710,610));
        primaryStage.show();


    }

}
