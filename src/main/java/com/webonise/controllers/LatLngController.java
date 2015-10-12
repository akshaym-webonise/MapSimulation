package com.webonise.controllers;

import com.webonise.models.LatLng;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LatLngController {

    private ObservableList<LatLng> latLngList;
    private LatLng latLng;

    public LatLngController() {
        latLngList = FXCollections.observableArrayList();
        latLng = new LatLng();
    }

    public ObservableList<LatLng> getLatLngList() {
        return latLngList;
    }

    public void setLatLngList(ObservableList<LatLng> latLngList) {
        this.latLngList = latLngList;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public LatLng getNewLatLng() {
        return new LatLng();
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
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
