package com.webonise.models;

import org.springframework.stereotype.Component;

import java.util.Observable;

@Component
public class Coordinates extends Observable {
    private float latitude;
    private float longitude;
    private boolean isDataFromJs;

    public Coordinates() {
        this(0.00f, 0.00f);
    }

    public Coordinates(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.isDataFromJs = false;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLatitude() {
        return this.latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLongitude() {
        return this.longitude;
    }

    public void setDataFromJs(boolean value) {
        this.isDataFromJs = value;
        if (isDataFromJs) {
            setChanged();
            notifyObservers();
        }
    }

    public boolean isDataFromJs() {
        return this.isDataFromJs;
    }
}
