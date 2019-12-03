package com.klmhva.LineMaintenanceBackend.model;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "EquipmentRequest")
public class EquipmentRequest implements Request{

    @Id
    @GeneratedValue
    private String id;
    private Date dateRequested;
    private String mechanicId;
    private Status status;

    private String equipmentType;
    private String aircraftType;
    private String requestedLocation;
    private Date expectedDeparture;
    private String wheelPosition;

    private String noseWheelAmount;
    private String rightWheelAmount;
    private String leftWheelAMount;

    public EquipmentRequest(Date dateRequested, String mechanicId, Status status, String equipmentType, String aircraftType, String requestedLocation, Date expectedDeparture, String wheelPosition) {
        this.dateRequested = dateRequested;
        this.mechanicId = mechanicId;
        this.status = status;
        this.equipmentType = equipmentType;
        this.aircraftType = aircraftType;
        this.requestedLocation = requestedLocation;
        this.expectedDeparture = expectedDeparture;
        this.wheelPosition = wheelPosition;
    }

    public EquipmentRequest(Date dateRequested, String mechanicId, Status status, String equipmentType, String aircraftType, String requestedLocation, Date expectedDeparture, String wheelPosition, String noseWheelAmount, String rightWheelAmount, String leftWheelAMount) {
        this.dateRequested = dateRequested;
        this.mechanicId = mechanicId;
        this.status = status;
        this.equipmentType = equipmentType;
        this.aircraftType = aircraftType;
        this.requestedLocation = requestedLocation;
        this.expectedDeparture = expectedDeparture;
        this.wheelPosition = wheelPosition;
        this.noseWheelAmount = noseWheelAmount;
        this.rightWheelAmount = rightWheelAmount;
        this.leftWheelAMount = leftWheelAMount;
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

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public String getRequestedLocation() {
        return requestedLocation;
    }

    public void setRequestedLocation(String requestedLocation) {
        this.requestedLocation = requestedLocation;
    }

    public Date getExpectedDeparture() {
        return expectedDeparture;
    }

    public void setExpectedDeparture(Date expectedDeparture) {
        this.expectedDeparture = expectedDeparture;
    }

    public String getWheelPosition() {
        return wheelPosition;
    }

    public void setWheelPosition(String wheelPosition) {
        this.wheelPosition = wheelPosition;
    }

    public String getNoseWheelAmount() {
        return noseWheelAmount;
    }

    public void setNoseWheelAmount(String noseWheelAmount) {
        this.noseWheelAmount = noseWheelAmount;
    }

    public String getRightWheelAmount() {
        return rightWheelAmount;
    }

    public void setRightWheelAmount(String rightWheelAmount) {
        this.rightWheelAmount = rightWheelAmount;
    }

    public String getLeftWheelAMount() {
        return leftWheelAMount;
    }

    public void setLeftWheelAMount(String leftWheelAMount) {
        this.leftWheelAMount = leftWheelAMount;
    }
}
