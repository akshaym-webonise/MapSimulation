package com.webonise;

import com.webonise.config.MapSurveyAppConfiguration;
import com.webonise.controllers.MainScreenController;
import javafx.application.Application;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class MapSurveyApplication extends Application {

    private static final Logger LOG = LoggerFactory.getLogger(MainScreenController.class);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        LOG.debug("Loading app context");
        ApplicationContext context = new AnnotationConfigApplicationContext(MapSurveyAppConfiguration.class);
        MainScreenController mainScreenController = context.getBean(MainScreenController.class);
        mainScreenController.launch(primaryStage);
    }
}
