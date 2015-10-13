package com.webonise;

import com.webonise.config.AppConfig;
import com.webonise.controllers.MainScreenController;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class MapSurveyApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MainScreenController mainScreenController = context.getBean(MainScreenController.class);
        mainScreenController.launch(primaryStage);
    }
}
