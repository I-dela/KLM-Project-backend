package com.klmhva.LineMaintenanceBackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Run")
public class Run {

    @Id
    @GeneratedValue()
    private String id;
    private String runnerId;
    private String requestId;
    private String equipmentId;
    private Date acceptedDate;
    private Date closedDate;

    public Run(String runnerId, String requestId, String equipmentId, Date acceptedDate) {
        this.runnerId = runnerId;
        this.requestId = requestId;
        this.equipmentId = equipmentId;
        this.acceptedDate = acceptedDate;
    }

//    public Run(String runnerId, Request request, Equipment equipment, Date acceptedDate) {
//        this.runnerId = runnerId;
//        this.requestId = request.getId();
//        this.equipmentId = equipment.getId();
//        this.acceptedDate = acceptedDate;
//    }

    public String getId() {
        return id;
    }

    public String getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(String runnerId) {
        this.runnerId = runnerId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Date getAcceptedDate() {
        return acceptedDate;
    }

    public void setAcceptedDate(Date acceptedDate) {
        this.acceptedDate = acceptedDate;
    }

    public Date getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }
}
