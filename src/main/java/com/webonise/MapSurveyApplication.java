package com.webonise;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MapSurveyApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent parent = FXMLLoader.load(Thread.currentThread().getContextClassLoader().getResource
                ("fxml/MainScreenView.fxml"));
        primaryStage.setTitle("Map Survey");
        primaryStage.setMaximized(true);
        primaryStage.setScene(new Scene(parent, 600, 400));
        primaryStage.show();
    }
}
