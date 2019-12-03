package Klm1.KLMLineMaintenanceServer.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "request")
public class Request  {

  @Id
  @Column(name = "id")
  @NotNull
  private String id;


  @Column(name = "status")
  @NotNull
  @Enumerated(EnumType.STRING)
  private Status status;

  @ManyToOne
  @NotNull
  @JoinColumn(name = "requestedEquipment")
  private EquipmentType equipmentType;

  @ManyToOne
  @NotNull
  @JoinColumn(name = "aircraftType")
  private  Aircraft aircraft;


  @ManyToOne
  @NotNull
  @JoinColumn(name = "requestedLocation")
  private Location location;

  @ManyToOne
  @JoinColumn(name = "usedEquipment")
  private Equipment equipment;

  @Column(name = "timeStamp")
  private LocalDateTime timeStamp;

  @Column(name = "departure")
  private LocalDateTime departure;


  public Request() {
  }

  public Request(@NotNull String id, @NotNull Status status, @NotNull EquipmentType equipmentType, @NotNull Aircraft aircraft, @NotNull Location location, Equipment equipment, LocalDateTime timeStamp, LocalDateTime departure) {
    this.id = id;
    this.status = status;
    this.equipmentType = equipmentType;
    this.aircraft = aircraft;
    this.location = location;
    this.equipment = equipment;
    this.timeStamp = timeStamp;
    this.departure = departure;
  }

  private enum Status{
    OP, IP, CAN, CL


  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public EquipmentType getEquipmentType() {
    return equipmentType;
  }

  public void setEquipmentType(EquipmentType equipmentType) {
    this.equipmentType = equipmentType;
  }

  public Aircraft getAircraft() {
    return aircraft;
  }

  public void setAircraft(Aircraft aircraft) {
    this.aircraft = aircraft;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public Equipment getEquipment() {
    return equipment;
  }

  public void setEquipment(Equipment equipment) {
    this.equipment = equipment;
  }

  public LocalDateTime getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(LocalDateTime timeStamp) {
    this.timeStamp = timeStamp;
  }

  public LocalDateTime getDeparture() {
    return departure;
  }

  public void setDeparture(LocalDateTime departure) {
    this.departure = departure;
  }
}
