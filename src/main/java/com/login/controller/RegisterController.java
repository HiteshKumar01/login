package com.login.controller;

import com.login.JdbcDao.JdbcDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.*;

import java.io.IOException;



public class RegisterController {

    @FXML
    private TextArea nameField;
    @FXML
    private TextArea emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Button registerButtonMain;
    @FXML
    private Button goToLoginPage;



    @FXML
    public void register(ActionEvent event) throws  IOException {


        Window owner = registerButtonMain.getScene().getWindow();

        System.out.println(nameField.getText());
        System.out.println(emailField.getText());
        System.out.println(passwordField.getText());
        System.out.println(confirmPasswordField.getText());
        if (nameField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your name");
            System.out.println("enter all the fields.......");
            return;
        }

        if (emailField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your email id");
            System.out.println("enter all the fields......");
            return;
        }
        if (passwordField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a password");
            System.out.println("enter all the fields......");
            return;
        }
        if(confirmPasswordField.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR,owner,"Form Error!",
                    "Please re-enter the password");
            System.out.println("enter all the fields......");
            return;
        }

        String name = nameField.getText();
        String emailId = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword=confirmPasswordField.getText();

        JdbcDao jdbcDao = new JdbcDao();
        jdbcDao.insertRecord(name, emailId, password,confirmPassword);

        showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                "Welcome " + name);

        //TODO create a method and call it here so that when the user successfully registers itself, the flow goes to Login page
        toMainPageAfterLogin();
    }
//TODO the above function
    public void toMainPageAfterLogin() throws IOException {
        Stage stage= (Stage) registerButtonMain.getScene().getWindow();
        stage.close();
        Stage newStage=new Stage();
        Parent root=FXMLLoader.load(getClass().getResource("/fxml/login_page.fxml"));
        newStage.setTitle("Welcome to the Login Page");
        newStage.setScene(new Scene(root,710,610));
        newStage.show();
        System.out.println("Going to Login Page.....");

    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);

        alert.showAndWait();
    }

    public void loginPageFromRegisterPage() throws IOException {

        Stage stage= (Stage) goToLoginPage.getScene().getWindow();
        stage.close();

        Stage primaryStage=new Stage();
        Parent root= FXMLLoader.load(getClass().getResource("/fxml/login_page.fxml"));
        primaryStage.setTitle("Login user");
        primaryStage.setScene(new Scene(root,710,610));
        primaryStage.show();


    }
}
