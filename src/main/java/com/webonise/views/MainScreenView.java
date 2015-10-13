package com.webonise.views;

import com.webonise.controllers.LatLngController;
import com.webonise.controllers.ScriptController;
import com.webonise.models.LatLng;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MainScreenView extends AbstractScreenView {

    private static final Logger LOG = LoggerFactory.getLogger(MainScreenView.class);
    private static final String SCRIPT_DELETE_MARKERS = "deleteMarkers()";
    private static final String SCRIPT_CLEAR_POLYGON = "clearPolygon()";
    private static final String LAT = "lat";
    private static final String LNG = "lng";
    private static final String RESOURCE_HTML = "/html/MapBox.html";
    private static final String WINDOW = "window";
    private static final String CONTROLLER = "controller";
    private static final String LOGGER = "LOG";

    private WebEngine webEngine;
    private JSObject script;

    @Autowired
    private LatLngController latLngController;

    @FXML
    private WebView mapBrowser;

    @FXML
    private Button clearButton;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private TableView<LatLng> tableView;

    @FXML
    private TableColumn latColumn;

    @FXML
    private TableColumn lngColumn;

    public MainScreenView() {
        super();
    }

    @PostConstruct
    public void init() {
        LOG.debug("Initializing UI");
        webEngine = mapBrowser.getEngine();
        webEngine.load(Thread.currentThread().getClass().getResource(RESOURCE_HTML).toExternalForm());
        progressBar.progressProperty().bind(webEngine.getLoadWorker().progressProperty());

        latColumn.setCellValueFactory(new PropertyValueFactory<LatLng, Float>(LAT));
        lngColumn.setCellValueFactory(new PropertyValueFactory<LatLng, Float>(LNG));
        tableView.setItems(latLngController.getLatLngList());

        script = (JSObject) webEngine.executeScript(WINDOW);
        script.setMember(CONTROLLER, latLngController);
        script.setMember(LOGGER, new ScriptController());

        clearButton.setOnAction(event -> {
            webEngine.executeScript(SCRIPT_DELETE_MARKERS);
            webEngine.executeScript(SCRIPT_CLEAR_POLYGON);
            latLngController.getLatLngList().clear();
        });
    }
}
