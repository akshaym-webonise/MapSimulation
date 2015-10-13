package com.webonise.controllers;

import com.webonise.models.WayPoint;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Component;

@Component
public class WayPointController {

    private final ObservableList<WayPoint> wayPointList;

    public WayPointController() {
        wayPointList = FXCollections.observableArrayList();
    }

    public ObservableList<WayPoint> getWayPointList() {
        return FXCollections.unmodifiableObservableList(wayPointList);
    }

    public WayPoint getNewWayPoint() {
        return new WayPoint();
    }

    public void addToList(WayPoint point) {
        wayPointList.add(point);
    }

    public void updateMarker(WayPoint point) {
        int listSize = wayPointList.size();
        for (int index = 0; index < listSize; index++) {
            WayPoint current = wayPointList.get(index);
            if (current.getPointNo() == point.getPointNo()) {
                wayPointList.set(index, point);
                break;
            }
        }
    }

    public void deleteMarker(WayPoint point) {
        int listSize = wayPointList.size();
        for (int index = 0; index < listSize; index++) {
            WayPoint current = wayPointList.get(index);
            if (current.getPointNo() == point.getPointNo()) {
                wayPointList.remove(index);
                break;
            }
        }
    }
}
