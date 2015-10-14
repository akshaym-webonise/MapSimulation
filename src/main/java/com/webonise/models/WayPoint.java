package com.webonise.models;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Waypoint {
    public double lat;
    public double lng;
    public int pointNo;

    public Waypoint() {
        this(0, 0, 0);
    }

    public Waypoint(double lat, double lng, int pointNo) {
        this.lat = lat;
        this.lng = lng;
        this.pointNo = pointNo;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public int getPointNo() {
        return pointNo;
    }

    public void setPointNo(int pointNo) {
        this.pointNo = pointNo;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;

        if (object == null || getClass() != object.getClass()) return false;

        Waypoint latLng = (Waypoint) object;

        return new EqualsBuilder()
                .append(lat, latLng.lat)
                .append(lng, latLng.lng)
                .append(pointNo, latLng.pointNo)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(lat)
                .append(lng)
                .append(pointNo)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Waypoint{" +
                "lat=" + lat +
                ", lng=" + lng +
                ", pointNo=" + pointNo +
                '}';
    }
}
