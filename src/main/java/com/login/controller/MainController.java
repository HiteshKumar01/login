package com.login.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Button registerButtonInMain;
    @FXML
    private Button loginButtonInMain;

    public void toLoginPageFromMainPage() throws IOException{
        Stage stage= (Stage) loginButtonInMain.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        Parent root=FXMLLoader.load(getClass().getResource("/fxml/login_page.fxml"));
        primaryStage.setTitle("User Login");
        primaryStage.setScene(new Scene(root,710,610));
        primaryStage.show();


    }


    public void toRegisterPageFromMainPage() throws IOException {
        Stage stage= (Stage) registerButtonInMain.getScene().getWindow();
        stage.close();

        Stage primaryStage=new Stage();
        Parent root= FXMLLoader.load(getClass().getResource("/fxml/registration_page.fxml"));
        primaryStage.setTitle("Register user");
        primaryStage.setScene(new Scene(root,710,610));
        primaryStage.show();
    }


}
