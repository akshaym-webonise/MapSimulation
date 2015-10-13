package com.webonise.controllers;

import com.webonise.views.MainScreenView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainScreenController {

    private static final Logger LOG = LoggerFactory.getLogger(MainScreenController.class);
    private static final String APPLICATION_TITLE = "Map Survey";
    private static final int SCREEN_HEIGHT = 400;
    private static final int SCREEN_WIDTH = 600;

    @Autowired
    private MainScreenView mainScreenView;

    public void launch(Stage primaryStage) {
        LOG.debug("Launching Map Simulation App");
        Scene scene = new Scene(mainScreenView, SCREEN_WIDTH, SCREEN_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle(APPLICATION_TITLE);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
