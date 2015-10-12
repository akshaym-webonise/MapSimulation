package com.webonise.models;

public class LatLng {
    public float lat;
    public float lng;
    public int pointNo;

    public LatLng() {
        this(0, 0);
    }

    public LatLng(float lat, float lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public int getPointNo() {
        return pointNo;
    }

    public void setPointNo(int pointNo) {
        this.pointNo = pointNo;
    }

    @Override
    public String toString() {
        return this.lat + " " + this.lng + " " + this.pointNo;
    }
}
