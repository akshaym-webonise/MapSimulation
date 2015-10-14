package com.webonise.controllers;

import com.webonise.models.Waypoint;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Component;

@Component
public class WaypointController {

    private final ObservableList<Waypoint> waypointList;

    public WaypointController() {
        waypointList = FXCollections.observableArrayList();
    }

    public ObservableList<Waypoint> getWaypointList() {
        return FXCollections.unmodifiableObservableList(waypointList);
    }

    public Waypoint getNewWaypoint() {
        return new Waypoint();
    }

    public void addToList(Waypoint point) {
        waypointList.add(point);
    }

    public void clearWaypointList() {
        waypointList.clear();
    }

    public void updateMarker(Waypoint point) {
        int listSize = waypointList.size();
        for (int index = 0; index < listSize; index++) {
            Waypoint current = waypointList.get(index);
            if (current.getPointNo() == point.getPointNo()) {
                waypointList.set(index, point);
                break;
            }
        }
    }

    public void deleteMarker(Waypoint point) {
        int listSize = waypointList.size();
        for (int index = 0; index < listSize; index++) {
            Waypoint current = waypointList.get(index);
            if (current.getPointNo() == point.getPointNo()) {
                waypointList.remove(index);
                break;
            }
        }
    }
}
