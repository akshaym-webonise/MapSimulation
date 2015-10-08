package com.webonise.controllers;

import com.webonise.models.Coordinates;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class MainScreenController extends Region implements Initializable, Observer {

    private static final Logger LOG = LoggerFactory.getLogger(MainScreenController.class);

    private Coordinates coordinates;
    private WebEngine webEngine;
    private JSObject script;
    private ObservableList<Coordinates> tableRows;

    @FXML
    private WebView mapBrowser;
    @FXML
    private ProgressBar progressBar;

    @FXML
    private TableView<Coordinates> tableView;
    @FXML
    private TableColumn latColumn;
    @FXML
    private TableColumn lngColumn;


    public void initialize(URL location, ResourceBundle resources) {
        LOG.info("UI initialized");
        coordinates = new Coordinates();
        webEngine = mapBrowser.getEngine();
        webEngine.load(getClass().getResource("/html/MapBox.html").toExternalForm());
        progressBar.progressProperty().bind(webEngine.getLoadWorker().progressProperty());
        script = (JSObject) webEngine.executeScript("window");
        script.setMember("coordinates", coordinates);
        script.setMember("LOG", LOG);
        coordinates.addObserver(this);

        tableRows = FXCollections.observableArrayList();
        latColumn.setCellValueFactory(new PropertyValueFactory<Coordinates, Float>("latitude"));
        lngColumn.setCellValueFactory(new PropertyValueFactory<Coordinates, Float>("longitude"));
        tableView.setItems(tableRows);
    }

    public void update(Observable object, Object arg) {
        LOG.info("Acquired coordinates");
        Coordinates location = (Coordinates) object;
        tableRows.add(new Coordinates(location.getLatitude(), location.getLongitude()));
    }

    @FXML
    public void clearTheMap(ActionEvent event) {
        tableRows.clear();
        webEngine.executeScript("clearPolygon()");
    }
}
