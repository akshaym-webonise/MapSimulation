package com.webonise.models;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class WayPoint {
    public double lat;
    public double lng;
    public int pointNo;

    public WayPoint() {
        this(0, 0);
    }

    public WayPoint(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
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

        WayPoint latLng = (WayPoint) object;

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
        return "WayPoint{" +
                "lat=" + lat +
                ", lng=" + lng +
                ", pointNo=" + pointNo +
                '}';
    }
}
