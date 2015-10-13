package com.webonise.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class AbstractScreenView extends HBox {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractScreenView.class);

    private static final String MAIN_SCREEN_FXML = "/fxml/MainScreenView.fxml";

    private FXMLLoader fxmlLoader;

    public AbstractScreenView() {
        super();
        try {
            fxmlLoader = new FXMLLoader(Thread.currentThread().getClass().getResource(MAIN_SCREEN_FXML));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);
            fxmlLoader.load();
            LOG.debug("FXML loaded");
        } catch (IOException exception) {
            LOG.error(exception.getMessage());
        }
    }
}
