package com.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


    public class Main extends Application {

        @Override
        public void start(Stage stage) throws Exception {
            System.out.println(getClass());
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/login_page.fxml"));
            stage.setTitle("User Login");
            stage.setScene(new Scene(root, 710, 610));
            stage.show();
        }

        public static  void main(String[] args){
            launch(args);
        }
    }