package com.webonise.controllers;

import com.webonise.views.MainScreenView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MainScreenController {

    private static final Logger LOG = LoggerFactory.getLogger(MainScreenController.class);
    private static final String MAIN_SCREEN_CSS = "/css/mainScreenView.css";
    private static final String APPLICATION_TITLE = "Map Survey";
    private static final int SCREEN_HEIGHT = 400;
    private static final int SCREEN_WIDTH = 600;

    @Autowired
    private MainScreenView mainScreenView;
    private Scene scene;

    public void launch(Stage primaryStage) {
        scene = new Scene(mainScreenView, SCREEN_WIDTH, SCREEN_HEIGHT);
        scene.getStylesheets().add(MAIN_SCREEN_CSS);
        primaryStage.setScene(scene);
        primaryStage.setTitle(APPLICATION_TITLE);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
