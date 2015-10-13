package com.webonise.controllers;

import com.webonise.models.LatLng;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Component;

@Component
public class LatLngController {

    private ObservableList<LatLng> latLngList;

    public LatLngController() {
        latLngList = FXCollections.observableArrayList();
    }

    public ObservableList<LatLng> getLatLngList() {
        return latLngList;
    }

    public LatLng getNewLatLng() {
        return new LatLng();
    }

    public void addToList(LatLng point) {
        latLngList.add(point);
    }

    public void updateMarker(LatLng point) {
        for (int index = 0; index < latLngList.size(); index++) {
            LatLng current = latLngList.get(index);
            if (current.getPointNo() == point.getPointNo()) {
                latLngList.set(index, point);
                break;
            }
        }
    }

    public void deleteMarker(LatLng point) {
        for (int index = 0; index < latLngList.size(); index++) {
            LatLng current = latLngList.get(index);
            if (current.getPointNo() == point.getPointNo()) {
                latLngList.remove(index);
                break;
            }
        }
    }
}
