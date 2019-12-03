package Klm1.KLMLineMaintenanceServer.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "equipment")
public class Equipment {

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "equipment")
  private List<Request>requests;
  @Id
  private String serialNumber;
  private String id;
  private int type;

  @Enumerated(EnumType.STRING)
  private Status status;

  private String statusDescr;
  private String tracker;



  public Equipment() {
  }
  public Equipment(String serialNumber, String id, int type, Status status, String statusDescription, String tracker) {
    this.serialNumber = serialNumber;
    this.id = id;
    this.type = type;
    this.status = status;
    this.statusDescr= statusDescription;
    this.tracker = tracker;
  }
  enum Status{
    Usable , Inuse
    , Broken
  }


  public String getSerialNumber() {
    return serialNumber;
  }

  public String getId() {
    return id;
  }

  public int getType() {
    return type;
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

  public void setType(int type) {
    this.type = type;
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

  @Override
  public String toString() {
    return this.id;
  }
}


