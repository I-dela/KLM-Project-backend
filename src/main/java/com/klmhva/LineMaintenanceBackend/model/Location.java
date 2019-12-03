package com.klmhva.LineMaintenanceBackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

enum LocationType {
    PIER,
    BUFFER
}

@Entity
@Table(name = "Location")
public class Location {

    @Id
    private String location;
    private LocationType type;

    public Location(String location, LocationType type) {
        this.location = location;
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocationType getType() {
        return type;
    }

    public void setType(LocationType type) {
        this.type = type;
    }
}
