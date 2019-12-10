package Klm1.KLMLineMaintenanceServer.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "equipment")
@NamedQuery(name = "find_all_equipment", query = "SELECT e FROM Equipment e")
@NamedQuery(name = "find_equipment_by_status", query = "SELECT e FROM Equipment e WHERE e.status = :status")
@NamedQuery(name = "find_equipment_by_type_and_status", query = "SELECT e FROM Equipment e WHERE e.type = :type AND e.status = :status")
public class Equipment {

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "equipment")
  @JsonIgnore
  private List<Request>requests;

  @Id
  private String serialNumber;
  private String id;

  @ManyToOne
  @NotNull
  @JoinColumn(name = "type")
  private EquipmentType type;

  @Enumerated(EnumType.STRING)
  private Status status;

  private String statusDescr;
  private String tracker;

  public Equipment() {
  }

  public Equipment(List<Request> requests, String serialNumber, String id, @NotNull EquipmentType type, Status status, String statusDescr, String tracker) {
    this.requests = requests;
    this.serialNumber = serialNumber;
    this.id = id;
    this.type = type;
    this.status = status;
    this.statusDescr = statusDescr;
    this.tracker = tracker;
  }

  public enum Status{
    Usable , Inuse
    , Broken
  }


  public EquipmentType getType() {
    return type;
  }

  public void setType(EquipmentType type) {
    this.type = type;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public String getId() {
    return id;
  }


  public Status getStatus() {
    return status;
  }

  public String getStatusDescription() {
    return statusDescr;
  }

  public String getTracker() {
    return tracker;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public void setId(String id) {
    this.id = id;
  }


  public void setStatus(Status status) {
    this.status = status;
  }

  public void setStatusDescription(String statusDescription) {
    this.statusDescr = statusDescription;
  }

  public void setTracker(String tracker) {
    this.tracker = tracker;
  }

  public List<Request> getRequests() {
    return requests;
  }

  public void setRequests(List<Request> requests) {
    this.requests = requests;
  }

  public String getStatusDescr() {
    return statusDescr;
  }

  public void setStatusDescr(String statusDescr) {
    this.statusDescr = statusDescr;
  }

  @Override
  public String toString() {
    return this.id;
  }
}


