package com.webonise;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MapSurveyApplication extends Application {

    private static final String MAIN_SECREEN_FXML = "fxml/MainScreenView.fxml";
    private static final String TITLE = "Map Survey";
    private static final int SCREEN_HEIGHT = 400;
    private static final int SCREEN_WIDTH = 600;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent parent = FXMLLoader.load(Thread.currentThread().getContextClassLoader().getResource(MAIN_SECREEN_FXML));
        primaryStage.setTitle(TITLE);
        primaryStage.setMaximized(true);
        primaryStage.setScene(new Scene(parent, SCREEN_WIDTH, SCREEN_HEIGHT));
        primaryStage.show();
    }
}