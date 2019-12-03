package com.klmhva.LineMaintenanceBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "PickupRequest")
public class PickupRequest implements Request {

    @Id
    @GeneratedValue
    private String id;
    private Date dateRequested;
    private String mechanicId;
    private Status status;

    private String pickupLocation;
    private String equipmentId;

    public PickupRequest(Date dateRequested, String mechanicId, Status status, String pickupLocation, String equipmentId) {
        this.dateRequested = dateRequested;
        this.mechanicId = mechanicId;
        this.status = status;
        this.pickupLocation = pickupLocation;
        this.equipmentId = equipmentId;
    }

    public String getId() {
        return id;
    }

    public Date getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(Date dateRequested) {
        this.dateRequested = dateRequested;
    }

    public String getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(String mechanicId) {
        this.mechanicId = mechanicId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }
}
