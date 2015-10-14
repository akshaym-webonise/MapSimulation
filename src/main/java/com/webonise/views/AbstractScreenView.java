package com.webonise.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class AbstractScreenView extends HBox {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractScreenView.class);

    private static final String FXML_DIRECTORY = "/fxml";
    private static final String FXML_FILE_FORMAT = "%s/%s.fxml";

    private FXMLLoader fxmlLoader;

    public AbstractScreenView() {
    }

    public AbstractScreenView(Class clazz) {
        super();
        try {
            String fxmlFilePath = String.format(FXML_FILE_FORMAT, FXML_DIRECTORY, clazz.getSimpleName());
            fxmlLoader = new FXMLLoader(Thread.currentThread().getClass().getResource(fxmlFilePath));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);
            fxmlLoader.load();
            LOG.debug("FXML loaded");
        } catch (IOException exception) {
            LOG.error(exception.getMessage());
        }
    }
}
