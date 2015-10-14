package com.webonise.views;

import com.webonise.controllers.ScriptLogger;
import com.webonise.controllers.WaypointController;
import com.webonise.models.Waypoint;
import com.webonise.models.status.WebEngineStatus;
import javafx.concurrent.Worker;
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
    private static final String RESOURCE_HTML = "/html/MapBox.html";
    private static final String WINDOW = "window";
    private static final String CONTROLLER = "controller";
    private static final String LOGGER = "LOG";
    private static final String WEB_ENGINE_STATUS = "webEngineStatus";

    private WebEngine webEngine;
    private JSObject script;
    private WebEngineStatus webEngineStatus;

    @Autowired
    private WaypointController waypointController;

    @Autowired
    private ScriptLogger scriptLogger;

    @FXML
    private WebView mapBrowser;

    @FXML
    private Button clearButton;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private TableView<Waypoint> tableView;

    @FXML
    private TableColumn latColumn;

    @FXML
    private TableColumn lngColumn;

    public MainScreenView() {
        super();
    }

    @PostConstruct
    public void init() {
        loadWebEngine();
        bindTableView();
        bindScriptMembers();
        bindButtonActions();
    }

    private void loadWebEngine() {
        LOG.debug("Initializing webEngine");
        webEngine = mapBrowser.getEngine();
        webEngine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == Worker.State.SUCCEEDED) {
                webEngineStatus = WebEngineStatus.ACTIVE;
                LOG.debug("WebEngine is " + String.valueOf(webEngineStatus));
            } else {
                webEngineStatus = WebEngineStatus.INACTIVE;
                LOG.debug("WebEngine is " + String.valueOf(webEngineStatus));
            }
        });
        progressBar.progressProperty().bind(webEngine.getLoadWorker().progressProperty());
        webEngine.load(Thread.currentThread().getClass().getResource(RESOURCE_HTML)
                .toExternalForm());
    }

    private void bindButtonActions() {
        LOG.debug("Binding button actions");
        clearButton.setOnAction(event -> {
            if (webEngineStatus == WebEngineStatus.ACTIVE) {
                webEngine.executeScript(SCRIPT_DELETE_MARKERS);
                webEngine.executeScript(SCRIPT_CLEAR_POLYGON);
                waypointController.clearWaypointList();
            } else {
                LOG.error("Network is offline");
            }
        });
    }

    private void bindScriptMembers() {
        script = (JSObject) webEngine.executeScript(WINDOW);
        script.setMember(CONTROLLER, waypointController);
        script.setMember(WEB_ENGINE_STATUS, webEngineStatus);
        script.setMember(LOGGER, scriptLogger);
    }

    private void bindTableView() {
        latColumn.setCellValueFactory(new PropertyValueFactory<Waypoint, Double>("lat"));
        lngColumn.setCellValueFactory(new PropertyValueFactory<Waypoint, Double>("lng"));
        tableView.setItems(waypointController.getWaypointList());
    }
}
