package com.webonise.models;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class LatLng {
    public double lat;
    public double lng;
    public int pointNo;

    public LatLng() {
        this(0, 0);
    }

    public LatLng(double lat, double lng) {
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
    public int hashCode() {
        return (new HashCodeBuilder()).append(this.lat).append(this.lng).append(this.pointNo).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj == this) {
            return true;
        } else if (obj.getClass() != this.getClass()) {
            return false;
        } else {
            LatLng latLng = (LatLng) obj;
            return (new EqualsBuilder()).append(this.lat, latLng.lat).append(this.lng, latLng.lng).append(this.pointNo, latLng.pointNo).isEquals();
        }
    }

    @Override
    public String toString() {
        return this.lat + " " + this.lng + " " + this.pointNo;
    }
}
